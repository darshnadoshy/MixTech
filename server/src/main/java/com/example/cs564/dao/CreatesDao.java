package com.example.cs564.dao;

import com.example.cs564.entity.MatchEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Direct Access Object to creates table
 * implement manually
 */

@Repository
public interface CreatesDao {


    List<MatchEntity> findAllById(Long uid);

}
