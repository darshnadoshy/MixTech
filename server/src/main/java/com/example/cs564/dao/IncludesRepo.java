package com.example.cs564.dao;

import com.example.cs564.entity.IncludesEntity;
import com.example.cs564.entity.key.IncludesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncludesRepo extends JpaRepository<IncludesEntity, IncludesKey> {
    IncludesEntity findBySpotifyUriAndPid(String spotifyUri, Long pid);
}
