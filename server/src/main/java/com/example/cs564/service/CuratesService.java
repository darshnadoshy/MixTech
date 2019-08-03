package com.example.cs564.service;

import com.example.cs564.entity.PlaylistEntity;

import java.util.List;

public interface CuratesService {
    List<PlaylistEntity> getAllByUid(Long uid);
    void remove(Long uid, Long pid);
}
