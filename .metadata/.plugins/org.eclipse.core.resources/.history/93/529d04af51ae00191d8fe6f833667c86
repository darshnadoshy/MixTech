package com.example.cs564.service.impl;

import com.example.cs564.dao.PlaylistRepo;
import com.example.cs564.entity.PlaylistEntity;
import com.example.cs564.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PlaylistService")
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    private PlaylistRepo playlistRepo;

    @Override
    public Page<PlaylistEntity> getAllByPage(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "pid");
        Pageable pageable = PageRequest.of(page, size, sort);
        return playlistRepo.findAll(pageable);
    }

    @Override
    public List<PlaylistEntity> getAll() {
        return playlistRepo.findAll();
    }

    @Override
    public void create(PlaylistEntity playlistEntity) {
        playlistRepo.save(playlistEntity);
    }

    @Override
    public void remove(Long pid) {
        playlistRepo.deleteById(pid);
    }
}
