package com.batarang_solutions_mvc.demo.controller;

import com.batarang_solutions_mvc.demo.model.Author;
import com.batarang_solutions_mvc.demo.model.OrganicResult;
import com.batarang_solutions_mvc.demo.service.OrganicResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OrganicResultController {

    @Autowired
    private OrganicResultService organicResultService;

    @GetMapping("/fetch-data")
    public String fetchData() {
        organicResultService.fetchAndSaveData();
        return "Data fetched and saved successfully!";
    }

    @GetMapping("/authors/position/{position}")
    public List<Author> getAuthorsByPosition(@PathVariable int position) {
        return organicResultService.findAuthorsByPosition(position);
    }


    @GetMapping("/authors/top10")
    public List<Author> getTop10Authors() {
        return organicResultService.findTop10().stream()
                .flatMap(result -> result.getPublicationInfo().getAuthors().stream())
                .collect(Collectors.toList());
    }

    @GetMapping("/authors/{position}/summary")
    public List<OrganicResult> getPositionAuthorSummary(@PathVariable int position) {
        return organicResultService.findByPositionAndAuthorAndSummary(position);
    }

    @GetMapping("/authors/{position}/title")
    public List<OrganicResult> getPositionAuthorTitle(@PathVariable int position) {
        return organicResultService.findByPositionAndAuthorTitle(position);
    }

    @GetMapping("/authors/{position}/snippet")
    public List<OrganicResult> getPositionSnippet(@PathVariable int position) {
        return organicResultService.findByPositionAndSnippet(position);
    }
}
