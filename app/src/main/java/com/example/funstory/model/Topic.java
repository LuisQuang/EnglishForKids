package com.example.funstory.model;

import android.graphics.Bitmap;

import java.util.Objects;

public class Topic {
    private final String name;
    private final Bitmap img;

    public Topic(String name, Bitmap img) {
        this.name = name;
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return name.equals(topic.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public Bitmap getImg() {
        return img;
    }
}
