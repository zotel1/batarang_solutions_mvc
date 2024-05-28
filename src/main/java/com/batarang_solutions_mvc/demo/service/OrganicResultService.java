package com.batarang_solutions_mvc.demo.service;

import com.batarang_solutions_mvc.demo.model.OrganicResult;
import com.batarang_solutions_mvc.demo.model.OrganicResultsResponse;
import com.batarang_solutions_mvc.demo.repository.OrganicResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrganicResultService {

    @Autowired
    private OrganicResultRepository organicResultRepository;

    public List<OrganicResult> findAuthorsByPosition(int position) {

        return organicResultRepository.findByPosition(position);
        // List<OrganicResult> results = organicResultRepository.findByPosition(position);
       // return results.stream()
         //       .limit(10)
           //     .flatMap(result -> result.getPublicationInfo().getAuthors().stream())
             //   .collect(Collectors.toList());
    }

    public List<OrganicResult> findTop10() {
        return organicResultRepository.findAll().stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    // implementar la logica
    public List<OrganicResult> findByPositionAndAuthorAndSummary(int position) {
        return organicResultRepository.findByPosition(position);
       // return organicResultRepository.findByPosition(position).stream()
         //       .map(result -> new OrganicResult(result.getPosition(), result.getPublicationInfo().getAuthors(), result.getPublicationInfo().getSummary()))
           //     .collect(Collectors.toList());
    }

    public List<OrganicResult> findByPositionAndAuthorTitle(int position) {

        return organicResultRepository.findByPosition(position);
        //  return organicResultRepository.findByPosition(position).stream()
        ////      .collect(Collectors.toList());
    }


    public List<OrganicResult> findByPositionAndSnippet(int position) {
        return organicResultRepository.findByPosition(position);
        //.stream()
         //       .map(result -> new OrganicResult(result.getPosition(), result.getSnippet()))
           //     .collect(Collectors.toList());

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

