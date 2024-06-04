package com.batarang_solutions_mvc.demo.controller;

import com.batarang_solutions_mvc.demo.dto.PublicationInfoDTO;
import com.batarang_solutions_mvc.demo.model.OrganicResult;
import com.batarang_solutions_mvc.demo.service.OrganicResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organic-results")
public class OrganicResultController {

    @Autowired
    private OrganicResultService organicResultService;

   // @GetMapping("/fetch-data")
   @GetMapping("/fetch-and-save")
    public String fetchData() {
        organicResultService.fetchAndSaveData();
        return "Data fetched and saved successfully!";
    }

    @GetMapping("/authors/position/{position}")
    public List<PublicationInfoDTO> getAuthorsByPosition(@PathVariable int position) {
        return organicResultService.findAuthorsByPosition(position);
    }


    @GetMapping("/top10")
    public List<PublicationInfoDTO> getTop1OrganicResults() {
        return organicResultService.findTop10();
        //return organicResultService.findTop10().stream()
          //      .flatMap(result -> result.getPublicationInfo().getAuthors().stream())
            //    .collect(Collectors.toList());
    }

    @GetMapping("/authors/summary/{position}")
    public List<PublicationInfoDTO> getByPositionAndAuthorSummary(@PathVariable int position) {
        return organicResultService.findByPositionAndAuthorAndSummary(position);
    }

    @GetMapping("/authors/title/{position}")
    public List<PublicationInfoDTO> getByPositionAndAuthorTitle(@PathVariable int position) {
        return organicResultService.findByPositionAndAuthorTitle(position);
    }

    @GetMapping("/authors/snippet/{position}")
    public List<PublicationInfoDTO> getByPositionAndSnippet(@PathVariable int position) {
        return organicResultService.findByPositionAndSnippet(position);
    }
}
