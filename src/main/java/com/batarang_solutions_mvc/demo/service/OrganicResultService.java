package com.batarang_solutions_mvc.demo.service;

import com.batarang_solutions_mvc.demo.dto.PublicationInfoDTO;
import com.batarang_solutions_mvc.demo.model.Author;
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

    //public List<PublicationInfoDTO> findAuthorsByPosition(int position) {
      //  List<OrganicResult> results = organicResultRepository.findByPosition(position);

        //return results.stream()
          //      .map(result -> {
            //        String summary = result.getPublicationInfo().getSummary();
              //      List<Author> authors = result.getPublicationInfo().getAuthors();
                //    return new PublicationInfoDTO(result.getPosition(), summary, authors);
               // })
               // .collect(Collectors.toList());
    //}

    public List<PublicationInfoDTO> findAuthorsByPosition(int position) {
        List<OrganicResult> results = organicResultRepository.findByPosition(position);

        return results.stream()
                .map(result -> {
                    String summary = result.getPublicationInfo().getSummary();
                    List<Author> authors = result.getPublicationInfo().getAuthors();
                    return new PublicationInfoDTO(result.getPosition(), summary, authors, null); // title is null here
                })
                .collect(Collectors.toList());
    }


    // probamos nuevo metodo
    //public List<OrganicResult> findAuthorsByPosition(int position) {

      //  return organicResultRepository.findByPosition(position);
        // List<OrganicResult> results = organicResultRepository.findByPosition(position);
       // return results.stream()
         //       .limit(10)
           //     .flatMap(result -> result.getPublicationInfo().getAuthors().stream())
             //   .collect(Collectors.toList());
    //}

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

    //metodo antiguo
    //public List<OrganicResult> findTop10() {
      //  return organicResultRepository.findAll().stream()
        //        .limit(10)
          //      .collect(Collectors.toList());
    //}

    // implementar la logica
    //public List<OrganicResult> findByPositionAndAuthorAndSummary(int position) {
      //  return organicResultRepository.findByPosition(position);
       // return organicResultRepository.findByPosition(position).stream()
         //       .map(result -> new OrganicResult(result.getPosition(), result.getPublicationInfo().getAuthors(), result.getPublicationInfo().getSummary()))
           //     .collect(Collectors.toList());
    //}

    public List<PublicationInfoDTO> findByPositionAndAuthorAndSummary(int position) {
        List<OrganicResult> results = organicResultRepository.findByPosition(position);

        return results.stream()
                .map(result -> {
                    String summary = result.getPublicationInfo().getSummary();
                    List<Author> authors = result.getPublicationInfo().getAuthors();
                    return new PublicationInfoDTO(result.getPosition(), summary, authors, null); // title is null here
                })
                .collect(Collectors.toList());
    }


    // metodo antiguo
//    public List<PublicationInfoDTO> findByPositionAndAuthorAndSummary(int position) {
  //      List<OrganicResult> results = organicResultRepository.findByPosition(position);

    //    return results.stream()
      //          .map(result -> {
        //            String summary = result.getPublicationInfo().getSummary();
          //          List<Author> authors = result.getPublicationInfo().getAuthors();
            //        return new PublicationInfoDTO(, summary, authors);
              //  })
                //.collect(Collectors.toList());
    //}

   // public List<OrganicResult> findByPositionAndAuthorTitle(int position) {

     //   return organicResultRepository.findByPosition(position);
        //  return organicResultRepository.findByPosition(position).stream()
        ////      .collect(Collectors.toList());
    //}

    // metodo antiguo
    //public List<PublicationInfoDTO> findByPositionAndAuthorTitle(int position) {
      //  List<OrganicResult> results = organicResultRepository.findByPosition(position);
        //return results.stream()
          //      .map(result -> {
            //        String summary = result.getPublicationInfo().getSummary();
              //      List<Author> authors = result.getPublicationInfo().getAuthors();
                //    String title = result.getTitle();
                  //  return new PublicationInfoDTO(result.getPosition(), summary, authors, title);
               // })
               // .collect(Collectors.toList());
   // }

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


// metodo antiguo
   // public List<OrganicResult> findByPositionAndSnippet(int position) {
     //   return organicResultRepository.findByPosition(position);
        //.stream()
         //       .map(result -> new OrganicResult(result.getPosition(), result.getSnippet()))
           //     .collect(Collectors.toList());

    //}

    // metodo nuevo
    public List<PublicationInfoDTO> findByPositionAndSnippet(int position) {
        List<OrganicResult> results = organicResultRepository.findByPosition(position);

        return results.stream()
                .map(result -> {
                    String snippet = result.getSnippet();
                    List<Author> authors = result.getPublicationInfo().getAuthors();
                    return new PublicationInfoDTO(result.getPosition(), snippet, authors, null); // title is null here
                })
                .collect(Collectors.toList());
    }


    public void fetchAndSaveData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://serpapi.com/search?engine=google_scholar&q=ciencia&api_key=";
        //0a7f9bd044bb822ed6f3ae5a254d75e457cdc399e66257ca84eff292af3f1a0e";

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

