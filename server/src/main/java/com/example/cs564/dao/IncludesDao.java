package com.example.cs564.dao;

import com.example.cs564.entity.SongEntity;

import java.util.List;

public interface IncludesDao {
    List<SongEntity> findAllByPid(Long Pid);
}
