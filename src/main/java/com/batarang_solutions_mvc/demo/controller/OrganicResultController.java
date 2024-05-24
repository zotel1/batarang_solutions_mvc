package com.batarang_solutions_mvc.demo.controller;

import com.batarang_solutions_mvc.demo.service.OrganicResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganicResultController {

    @Autowired
    private OrganicResultService organicResultService;

    @GetMapping("/fetch-data")
    public String fetchData() {
        organicResultService.fetchAndSaveData();
        return "Data fetched and saved successfully!";
    }
}
