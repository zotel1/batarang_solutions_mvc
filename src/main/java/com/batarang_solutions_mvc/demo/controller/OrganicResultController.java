package com.batarang_solutions_mvc.demo.controller;

import com.batarang_solutions_mvc.demo.model.Author;
import com.batarang_solutions_mvc.demo.service.OrganicResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
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
    public List<List<Author>> getTop10Authors() {
        List<List<Author>> top10Authors = new ArrayList<>();
        for (int i = 1; i <= 10 ; i++) {
            List<Author> authors = organicResultService.findAuthorsByPosition(i);
            top10Authors.add(authors);
        }
        return top10Authors;
    }
}
