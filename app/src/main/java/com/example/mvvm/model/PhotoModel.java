package com.example.mvvm.model;

import com.google.gson.annotations.SerializedName;

public class PhotoModel {

    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;

    public PhotoModel(String title, String url, String thumbnailUrl) {
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }



}
