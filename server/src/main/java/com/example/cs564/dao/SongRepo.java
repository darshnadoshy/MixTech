package com.example.cs564.dao;

import com.example.cs564.entity.SongEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepo extends JpaRepository<SongEntity, String> {
    List<SongEntity> findBySnameLike(String sname, Sort sort);

    SongEntity findBySpotifyID(String spotifyID);

    List<SongEntity> findBySnameLike(String sname, Pageable pageable);
}
