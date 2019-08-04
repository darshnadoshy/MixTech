package com.example.cs564.service;

import com.example.cs564.entity.SongEntity;

import java.util.List;

public interface PlaylistSongService {
    List<SongEntity> getAllByPid(Long pid);
    void add(String spotifyUri, Long pid);
    void remove(String spotifyUri, Long pid);
}
