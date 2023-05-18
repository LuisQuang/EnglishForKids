package com.example.funstory.model;

public class Story {
    private final String name;
    private final String content;

    public Story(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
