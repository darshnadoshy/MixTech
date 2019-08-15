package com.example.cs564.service;

import com.example.cs564.entity.PlaylistEntity;

import java.util.List;

/**
 * services related to playlist creation
 */

public interface CuratesService {
    List<PlaylistEntity> getAllByUid(Long uid);
    void create(Long uid, Long pid);
    void remove(Long uid, Long pid);
}
