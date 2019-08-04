package com.example.cs564.dao;

import com.example.cs564.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepo extends JpaRepository<PlaylistEntity, Long> {
    PlaylistEntity findByPid(Long pid);
}
