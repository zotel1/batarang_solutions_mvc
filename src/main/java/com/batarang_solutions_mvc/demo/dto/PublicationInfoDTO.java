package com.batarang_solutions_mvc.demo.dto;

import com.batarang_solutions_mvc.demo.model.Author;

import java.util.List;

public class PublicationInfoDTO {
    private int position;
    private String summary;
    private List<Author> authors;
    private String title;

    // Constructor
    public PublicationInfoDTO(int position, String summary, List<Author> authors, String title) {
        this.position = position;
        this.summary = summary;
        this.authors = authors;
        this.title = title;
    }

    // Getters y Setters
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}

