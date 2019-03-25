package com.hfad.FreeChampions;

import java.util.List;

public class ChampionResponse {
    private String title;
    private List<FreeChampions> results;
    public ChampionResponse() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FreeChampions> getResults() {
        return results;
    }

    public void setResults(List<FreeChampions> results) {
        this.results = results;
    }
}
