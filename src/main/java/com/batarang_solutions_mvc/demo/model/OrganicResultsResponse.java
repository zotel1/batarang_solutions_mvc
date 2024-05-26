package com.batarang_solutions_mvc.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganicResultsResponse {

    @JsonProperty("organic_results")
    private List<OrganicResult> organicResults;

    public List<OrganicResult> getOrganicResults() {
        return organicResults;
    }

    public void setOrganicResults(List<OrganicResult> organicResults) {
        this.organicResults = organicResults;
    }
}
