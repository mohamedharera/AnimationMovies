package com.example.mohamed.volleyapp.models;

/**
 * Created by Mohamed on 9/10/2018.
 */

public class Anime {
    private String name;
    private String description;
    private String rating;
    private int episode;
    private String category;
    private String studio;
    private String img_url;

    public Anime() {
    }

    public Anime(String name, String description, String rating, int episode, String category, String studio, String img_url) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.episode = episode;
        this.category = category;
        this.studio = studio;
        this.img_url = img_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public int getEpisode() {
        return episode;
    }

    public String getCategory() {
        return category;
    }

    public String getStudio() {
        return studio;
    }

    public String getImg_url() {
        return img_url;
    }
}
