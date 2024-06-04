package com.batarang_solutions_mvc.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganicResult {

    public OrganicResult() {}

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "organic_result_id")
    private  List<Author> authors;

    @Column(unique = true)
    private  String summary;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int position;

    @Column(unique = true)
    private String title;

    @Column(unique = true)
    private String link;

    @Column(unique = true)
    private String snippet;


    @JsonProperty("publication_info")
    @OneToOne(cascade = CascadeType.ALL)
    private PublicationInfo publicationInfo;

    public OrganicResult(int position, List<Author> authors, String summary) {
        this.position = position;
        this.authors = authors;
        this.summary = summary;

    }


    public OrganicResult(List<Author> authors, String summary, int position, String snippet) {
        this.authors = authors;
        this.summary = summary;
        this.position = position;
        this.snippet = snippet;
    }


    public OrganicResult(int position, String snippet) {
        this.position = position;
        this.snippet = snippet;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public PublicationInfo getPublicationInfo() {
        return publicationInfo;
    }

    public void setPublicationInfo(PublicationInfo publicationInfo) {
        this.publicationInfo = publicationInfo;
    }
}
