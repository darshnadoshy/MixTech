package com.example.cs564.dao;

import com.example.cs564.entity.PlaylistEntity;

import java.util.List;

/**
 * Direct Access Object to follows table
 * implement manually
 */

public interface FollowsDao {
    List<PlaylistEntity> getAllByUid(Long uid);
}
