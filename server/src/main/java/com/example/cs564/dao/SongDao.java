package com.example.cs564.dao;

import com.example.cs564.entity.SongEntity;
import com.example.cs564.request.AdvanceSearchRequest;

import java.util.List;

public interface SongDao {
//    List<SongEntity> findAllByAudioFeatures(AdvanceSearchRequest request);
    List<SongEntity> findAllByAudioFeatures(String query);
}
