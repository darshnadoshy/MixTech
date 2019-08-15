package com.example.cs564.dao;

import com.example.cs564.entity.SongEntity;

import java.util.List;

/**
 * Direct Access Object to includes table
 * implement manually
 */

public interface IncludesDao {
    List<SongEntity> findAllByPid(Long Pid);
}
