package com.example.cs564.service;

import com.example.cs564.entity.PlaylistEntity;
import org.springframework.data.domain.Page;


public interface PlaylistService {
    Page<PlaylistEntity> getAllByPage(int page, int size);
    void create(PlaylistEntity playlistEntity);
    void remove(Long pid);
}
