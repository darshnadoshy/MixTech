package com.example.cs564.service.impl;

import com.example.cs564.dao.IncludesDao;
import com.example.cs564.dao.IncludesRepo;
import com.example.cs564.entity.IncludesEntity;
import com.example.cs564.entity.SongEntity;
import com.example.cs564.entity.key.IncludesKey;
import com.example.cs564.service.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PlaylistSongService")
public class PlaylistSongServiceImpl implements PlaylistSongService {
    @Autowired
    private IncludesDao includesDao;
    @Autowired
    private IncludesRepo includesRepo;

    @Override
    public List<SongEntity> getAllByPid(Long pid) {
        return includesDao.findAllByPid(pid);
    }

    @Override
    public void add(String spotifyUri, Long pid) {
        if (includesRepo.findBySpotifyUriAndPid(spotifyUri, pid) != null) {
//            // TODO: If already exist...
        }
        includesRepo.save(new IncludesEntity(spotifyUri, pid));
    }

    @Override
    public void remove(String spotifyUri, Long pid) {
        includesRepo.deleteById(new IncludesKey(spotifyUri, pid));
    }
}
