package com.example.cs564.dao;

import com.example.cs564.entity.MatchEntity;

import java.util.List;

public interface CreatesDao {

    List<MatchEntity> findAllById(Long uid);

}
