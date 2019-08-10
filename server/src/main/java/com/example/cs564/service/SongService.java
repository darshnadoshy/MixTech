package com.example.cs564.service;

import com.example.cs564.entity.SongEntity;
import com.example.cs564.request.AdvanceSearchRequest;

import java.util.List;

public interface SongService {
    List<SongEntity> getAllByName(String name);
    List<SongEntity> getAllByNameInPage(String name, int page, int size);
    List<SongEntity> getAllByAudioFeatures(AdvanceSearchRequest request);
    SongEntity getByID(String spotifyID);
}
