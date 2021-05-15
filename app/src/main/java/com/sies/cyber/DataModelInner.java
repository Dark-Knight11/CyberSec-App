package com.sies.cyber;

public class DataModelInner {
    String title;
    int topic_no;
    int lock;
    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }

    public DataModelInner(String title, int topic_no, int lock,int score) {
        this.title = title;
        this.topic_no = topic_no;
        this.lock = lock;
        this.score = score;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getTopic_no() {
        return topic_no;
    }

    public void setTopic_no(int topic_no) {
        this.topic_no = topic_no;
    }
}
