package com.example.cs564.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "matches")
@Data
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;

    private String mname;
    private String spotify_uri1;
    private String spotify_uri2;

    public MatchEntity() {}

    public MatchEntity(String mname, String spotify_uri1, String spotify_uri2) {
        this.mname = mname;
        this.spotify_uri1 = spotify_uri1;
        this.spotify_uri2 = spotify_uri2;
    }
}
