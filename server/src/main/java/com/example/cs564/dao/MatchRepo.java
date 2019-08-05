package com.example.cs564.dao;

import com.example.cs564.entity.MatchEntity;
import com.example.cs564.entity.key.CreatesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends JpaRepository<MatchEntity, Long> {

    MatchEntity findByMid(Long mid);
}
