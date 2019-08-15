package com.example.cs564.dao;

import com.example.cs564.entity.PlaylistEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Direct Access Object to playlists table
 * utilize Spring JPA's built-in functionalities
 */

@Repository
public interface PlaylistRepo extends JpaRepository<PlaylistEntity, Long> {
    PlaylistEntity findByPid(Long pid);
}
