package com.example.cs564.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "song")
@Data
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String spotify_uri;

    private String sname;
    private String album_name;
    private String mname;
    private Float danceability;
    private Float energy;
    private Integer skey;
    private Float loudness;
    private Integer smode;
    private Float speechiness;
    private Float acousticness;
    private Float instrumentalness;
    private Float liveness;
    private Float valence;
    private Float tempo;
    private Integer duration_ms;

    public SongEntity() {}

    public SongEntity(String spotify_uri) {
        this.spotify_uri = spotify_uri;
    }

    public SongEntity(String spotify_uri, String sname, String album_name, String mname,
                      Float danceability, Float energy, Integer skey,
                      Float loudness, Integer smode, Float speechiness,
                      Float instrumentalness, Float liveness, Float valuence,
                      Float tempo, Integer duration_ms) {
        this.spotify_uri = spotify_uri;
        this.sname = sname;
        this.album_name = album_name;
        this.mname = mname;
        this.danceability = danceability;
        this.energy = energy;
        this.skey = skey;
        this.loudness = loudness;
        this.smode = smode;
        this.speechiness = speechiness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valuence;
        this.tempo = tempo;
        this.duration_ms = duration_ms;
    }
}
