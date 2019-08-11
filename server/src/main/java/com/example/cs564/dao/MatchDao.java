package com.example.cs564.dao;

import com.example.cs564.entity.MatchEntity;
import com.example.cs564.response.DisplayMatchResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MatchDao {

    List<DisplayMatchResponse> displayMatch(Long uid);
    void addSongTwo(String spotifyUri2, Long mid);
    List<DisplayMatchResponse> displayCompleteMatch(Long uid);
    List<DisplayMatchResponse> displayIncompleteMatch(Long uid);
    MatchEntity getMatchBySongs(String spotifyUri1, String sporifyUri2, Long uid);
}
