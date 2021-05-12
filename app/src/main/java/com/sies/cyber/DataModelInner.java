package com.sies.cyber;

public class DataModelInner {
    String title;
    int topic_no;
    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public DataModelInner(String title, int topic_no) {
        this.title = title;
        this.topic_no = topic_no;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getDescription() {
//        return description;
//    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    public int getTopic_no() {
        return topic_no;
    }

    public void setTopic_no(int topic_no) {
        this.topic_no = topic_no;
    }
}
