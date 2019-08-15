package com.example.cs564.entity;

import com.example.cs564.entity.key.IncludesKey;
import lombok.Data;

import javax.persistence.*;

/**
 * curates table
 */

@Entity
@IdClass(IncludesKey.class)
@Table(name = "include")
@Data
public class IncludesEntity {
    @Id
    @Column(name = "spotifyUri")
    private String spotifyUri;
    @Id
    private Long pid;

    public IncludesEntity() {}

    public IncludesEntity(String spotify_uri, Long pid) {
        this.spotifyUri = spotify_uri;
        this.pid = pid;
    }
}
