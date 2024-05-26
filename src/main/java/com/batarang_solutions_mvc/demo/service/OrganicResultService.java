package com.batarang_solutions_mvc.demo.service;

import com.batarang_solutions_mvc.demo.model.Author;
import com.batarang_solutions_mvc.demo.model.OrganicResult;
import com.batarang_solutions_mvc.demo.model.OrganicResultsResponse;
import com.batarang_solutions_mvc.demo.repository.OrganicResultRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrganicResultService {

    @Autowired
    private OrganicResultRepository organicResultRepository;

    public List<Author> findAuthorsByPosition(int position) {
        List<OrganicResult> results = organicResultRepository.findByPosition(position);
        return results.stream()
                .flatMap(result -> result.getPublicationInfo().getAuthors().stream())
                .collect(Collectors.toList());
    }

    public void fetchAndSaveData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://serpapi.com/search?engine=google_scholar&q=ciencia&api_key=";

        String jsonResponse = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
           // List<OrganicResult> results = objectMapper.readValue(jsonResponse, new TypeReference<List<OrganicResult>>() {
           // });
            OrganicResultsResponse response = objectMapper.readValue(jsonResponse, OrganicResultsResponse.class);
            List<OrganicResult> results = response.getOrganicResults();
            organicResultRepository.saveAll(results);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

