package com.example.cs564.service;

import com.example.cs564.entity.PlaylistEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * services related to playlists
 */

public interface PlaylistService {
//    List<PlaylistEntity> getAllByPage(Long uid, int page, int size);
    PlaylistEntity getByPid(Long pid);
    boolean privacy(Long uid, Long pid, int privacy);
    void create(Long uid, PlaylistEntity playlistEntity);
    boolean remove(Long uid, Long pid);
}
