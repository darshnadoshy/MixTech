package com.example.cs564.service.impl;

import com.example.cs564.dao.CuratesRepo;
import com.example.cs564.dao.FollowsDao;
import com.example.cs564.dao.FollowsRepo;
import com.example.cs564.dao.PlaylistRepo;
import com.example.cs564.entity.FollowsEntity;
import com.example.cs564.entity.PlaylistEntity;
import com.example.cs564.entity.key.FollowsKey;
import com.example.cs564.service.FollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FollwoService")
public class FollowServiceImpl implements FollowsService {
    @Autowired
    private FollowsRepo followsRepo;
    @Autowired
    private FollowsDao followsDao;
    @Autowired
    private PlaylistRepo playlistRepo;
    @Autowired
    private CuratesRepo curatesRepo;

    @Override
    public List<PlaylistEntity> getAllByUid(Long uid) {
        return followsDao.getAllByUid(uid);
    }

    @Override
    public boolean follow(Long pid, Long uid) {
        // non-creator follow a playlist
        // playlist creator should automatically follow his/her playlist
        if ( (playlistRepo.findByPid(pid)).getPrivacy() == 1 || curatesRepo.findOneByUidAndPid(uid, pid) != null) {
            if (followsRepo.findByPidAndUid(pid, uid) == null) {
                followsRepo.save(new FollowsEntity(pid, uid, 1));
            } else {
                followsRepo.updateAccessByPidAndUid(pid, uid, 1);
            }
            return true;
        }
        // user cannot follow a private playlist
        else {
            return false;
        }
    }

    @Override
    public boolean unfollow(Long pid, Long uid) {
        if (curatesRepo.findOneByUidAndPid(uid, pid) != null) {
            return false;
        }
        followsRepo.updateAccessByPidAndUid(pid, uid, 0);
        return true;
    }

    @Override
    public void unfollow(Long pid) {
        List<FollowsEntity> list = followsRepo.findAllByPid(pid);
        followsRepo.deleteAll(list);
    }
}
