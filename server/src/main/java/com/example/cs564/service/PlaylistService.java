package com.example.cs564.service;

import com.example.cs564.entity.PlaylistEntity;
import org.springframework.data.domain.Page;

import java.util.List;


public interface PlaylistService {
    Page<PlaylistEntity> getAllByPage(int page, int size);
    PlaylistEntity getByPid(Long pid);
    boolean privacy(Long uid, Long pid, int privacy);
    Long create(Long uid, PlaylistEntity playlistEntity);
    boolean remove(Long uid, Long pid);
}
