package com.sies.cyber;

public class DataModelInner {
    String title, description, topic;

    public DataModelInner(String title, String description, String topic) {
        this.title = title;
        this.description = description;
        this.topic = topic;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
