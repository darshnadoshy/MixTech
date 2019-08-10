package com.example.cs564.dao;

import com.example.cs564.entity.MatchEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatesDao {


    List<MatchEntity> findAllById(Long uid);

}
