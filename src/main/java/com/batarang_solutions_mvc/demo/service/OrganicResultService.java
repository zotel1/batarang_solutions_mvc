package com.batarang_solutions_mvc.demo.service;

import aj.org.objectweb.asm.TypeReference;
import com.batarang_solutions_mvc.demo.model.OrganicResult;
import com.batarang_solutions_mvc.demo.repository.OrganicResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class OrganicResultService {

    @Autowired
    private OrganicResultRepository organicResultRepository;

    public void fetchAndSaveData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://serpapi.com/search?engine=google_scholar&q=ciencia&api_key=";

        String jsonResponse = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<OrganicResult> results = objectMapper.readValue(jsonResponse, new <List<OrganicResult>());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
