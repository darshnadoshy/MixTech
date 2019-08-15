package com.example.cs564.dao;


import com.example.cs564.entity.PlaylistEntity;

import java.util.List;

/**
 * Direct Access Object to curates table
 * implement manually
 */

public interface CuratesDao {
    List<PlaylistEntity> findAllByUid(Long uid);
}