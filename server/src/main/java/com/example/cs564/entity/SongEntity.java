package com.example.cs564.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "song")
@Data
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "spotify_uri")
    private String spotifyID;
    private String sname;
    @Column(name = "album_name")
    private String albumName;
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
    @Column(name = "duration_ms")
    private Integer durationMs;
    @Column(name = "time_signature")
    private Integer timeSignature;

    public SongEntity() {}

    public SongEntity(String spotifyID) {
        this.spotifyID = spotifyID;
    }

    public SongEntity(String spotifyID, String sname, String albumName, String mname,
                      Float danceability, Float energy, Integer skey,
                      Float loudness, Integer smode, Float speechiness,
                      Float instrumentalness, Float liveness, Float valuence,
                      Float tempo, Integer durationMs) {
        this.spotifyID = spotifyID;
        this.sname = sname;
        this.albumName = albumName;
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
        this.durationMs = durationMs;
    }
}
