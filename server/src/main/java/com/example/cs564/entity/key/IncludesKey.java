package com.example.cs564.entity.key;

import lombok.Data;

import java.io.Serializable;

@Data
public class IncludesKey implements Serializable {
    private String spotify_uri;
    private Long pid;

    public IncludesKey() {}

    public IncludesKey(String spotify_uri, Long pid) {
        this.spotify_uri = spotify_uri;
        this.pid = pid;
    }
}
