package com.example.cs564.service.impl;

import com.example.cs564.dao.CuratesRepo;
import com.example.cs564.dao.FollowsRepo;
import com.example.cs564.dao.PlaylistRepo;
import com.example.cs564.dao.StoredProcedureDao;
import com.example.cs564.entity.FollowsEntity;
import com.example.cs564.entity.PlaylistEntity;
import com.example.cs564.service.CuratesService;
import com.example.cs564.service.FollowsService;
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
    @Autowired
    private CuratesRepo curatesRepo;
    @Autowired
    private FollowsRepo followsRepo;
    @Autowired
    private CuratesService curatesService;
    @Autowired
    private FollowsService followsService;
    @Autowired
    private StoredProcedureDao storedProcedureDao;


//    @Override
//    public List<PlaylistEntity> getAllByPage(Long uid, int page, int size) {
//        Sort sort = new Sort(Sort.Direction.DESC, "pid");
//        Pageable pageable = PageRequest.of(page, size, sort);
//        return playlistRepo.findAllByUid(uid, pageable);
//    }

    @Override
    public PlaylistEntity getByPid(Long pid) {
        return playlistRepo.findByPid(pid);
    }

    @Override
    public boolean privacy(Long uid, Long pid, int privacy) {
        // If not the creator, than operation denied.
        if (curatesRepo.findOneByUidAndPid(uid, pid) == null) {
            return false;
        }
        storedProcedureDao.updatePlaylistPrivacy(pid, privacy);
        return true;
    }

    @Override
    public void create(Long uid, PlaylistEntity playlistEntity) {
        storedProcedureDao.createPlaylist(uid, playlistEntity);
    }


    @Override
    public boolean remove(Long uid, Long pid) {
        if (curatesRepo.findOneByUidAndPid(uid, pid) == null) {
            return false;
        }
        storedProcedureDao.removePlaylist(uid, pid);
        return true;
    }
}
