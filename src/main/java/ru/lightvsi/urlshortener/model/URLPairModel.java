package ru.lightvsi.urlshortener.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class URLPairModel {
    private String url;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    public URLPairModel() {
    }

    public URLPairModel(String url) {
        this.url = url;
    }

    public URLPairModel(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "URLPairModel{" +
                "url='" + url + '\'' +
                ", durl='" + name + '\'' +
                '}';
    }
}
