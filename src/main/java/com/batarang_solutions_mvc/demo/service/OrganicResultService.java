package com.batarang_solutions_mvc.demo.service;

import com.batarang_solutions_mvc.demo.dto.PublicationInfoDTO;
import com.batarang_solutions_mvc.demo.model.Author;
import com.batarang_solutions_mvc.demo.model.OrganicResult;
import com.batarang_solutions_mvc.demo.model.OrganicResultsResponse;
import com.batarang_solutions_mvc.demo.repository.OrganicResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrganicResultService {

    @Autowired
    private OrganicResultRepository organicResultRepository;

    public List<PublicationInfoDTO> findAuthorsByPosition(int position) {
        List<OrganicResult> results = organicResultRepository.findByPosition(position);

        return results.stream()
                .map(result -> {
                    String summary = result.getPublicationInfo().getSummary();
                    List<Author> authors = result.getPublicationInfo().getAuthors();
                    return new PublicationInfoDTO(result.getPosition(), summary, authors); // title is null here
                })
                .collect(Collectors.toList());
    }

    public List<PublicationInfoDTO> findTop10() {
        return organicResultRepository.findAll().stream()
                .limit(10)
                .map(result -> {
                    String summary = result.getPublicationInfo().getSummary();
                    List<Author> authors = result.getPublicationInfo().getAuthors();
                    String title = result.getTitle();
                    return new PublicationInfoDTO(result.getPosition(), summary, authors, title);
                })
                .collect(Collectors.toList());
    }

    public List<PublicationInfoDTO> findByPositionAndAuthorAndSummary(int position) {
        List<OrganicResult> results = organicResultRepository.findByPosition(position);

        return results.stream()
                .map(result -> {
                    String summary = result.getPublicationInfo().getSummary();
                    List<Author> authors = result.getPublicationInfo().getAuthors();
                    return new PublicationInfoDTO(result.getPosition(), summary, authors); // title is null here
                })
                .collect(Collectors.toList());
    }

    public List<PublicationInfoDTO> findByPositionAndAuthorTitle(int position) {
        List<OrganicResult> results = organicResultRepository.findByPosition(position);

        return results.stream()
                .map(result -> {
                    String summary = result.getPublicationInfo().getSummary();
                    List<Author> authors = result.getPublicationInfo().getAuthors();
                    String title = result.getTitle();
                    return new PublicationInfoDTO(result.getPosition(), summary, authors, title);
                })
                .collect(Collectors.toList());
    }

    public List<PublicationInfoDTO> findByPositionAndSnippet(int position) {
        List<OrganicResult> results = organicResultRepository.findByPosition(position);

        return results.stream()
                .map(result -> {
                    String snippet = result.getSnippet();
                    List<Author> authors = result.getPublicationInfo().getAuthors();
                    return new PublicationInfoDTO(result.getPosition(), snippet, authors); // title is null here
                })
                .collect(Collectors.toList());
    }


    public void fetchAndSaveData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://serpapi.com/search?engine=google_scholar&q=ciencia&api_key=";

        String jsonResponse = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            OrganicResultsResponse response = objectMapper.readValue(jsonResponse, OrganicResultsResponse.class);
            List<OrganicResult> results = response.getOrganicResults();
            organicResultRepository.saveAll(results);

        } catch (DataIntegrityViolationException e) {
            System.out.println("Error: Ya existe un registro con el mismo dato.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

