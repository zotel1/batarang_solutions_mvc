package com.batarang_solutions_mvc.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganicResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int position;
    private String title;
    private String link;
    private String snippet;

    @JsonProperty("publication_info")
    @OneToOne("cascade = CascadeType.ALL")
    private PublicationInfo publicationInfo;

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
