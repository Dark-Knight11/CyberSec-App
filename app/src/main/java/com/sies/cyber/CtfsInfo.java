package com.sies.cyber;

public class CtfsInfo {
    private String title;
    private String ctftime_url;
    private String description;
    private String start;
    private String finish;

    public CtfsInfo(String title, String ctftime_url, String description, String start, String finish) {
        this.title = title;
        this.ctftime_url = ctftime_url;
        this.description = description;
        this.start = start;
        this.finish = finish;
    }

    public String getTitle() {
        return title;
    }

    public String getCtftime_url() {
        return ctftime_url;
    }

    public String getDescription() {
        return description;
    }

    public String getStart() {
        return start;
    }

    public String getFinish() {
        return finish;
    }
}
