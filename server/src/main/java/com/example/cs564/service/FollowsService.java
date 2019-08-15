package com.example.cs564.service;

import com.example.cs564.entity.PlaylistEntity;

import java.util.List;

/**
 * services related to follow/unfollow playlists
 */

public interface FollowsService {
    List<PlaylistEntity> getAllByUid(Long uid);
    boolean follow(Long pid, Long uid);
    boolean unfollow(Long pid, Long uid);
    void unfollow(Long pid);
}
