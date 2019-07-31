package com.example.cs564.service.impl;

import com.example.cs564.dao.SongRepo;
import com.example.cs564.entity.SongEntity;
import com.example.cs564.request.AdvanceSearchRequest;
import com.example.cs564.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SongService")
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepo songRepo;


    @Override
    public List<SongEntity> getAllByName(String sname) {
        return songRepo.findBySnameLike("%" + sname + "%");
    }

    @Override
    public List<SongEntity> getAllByAudioFeatures(AdvanceSearchRequest request) {
        return null;
    }
}
