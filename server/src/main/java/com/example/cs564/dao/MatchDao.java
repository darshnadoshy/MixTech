package com.example.cs564.dao;

import com.example.cs564.response.DisplayMatchResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MatchDao {

    List<DisplayMatchResponse> displayMatch(Long uid);
    List<DisplayMatchResponse> displayCompleteMatch(Long uid);
    List<DisplayMatchResponse> displayIncompleteMatch(Long uid);
}
