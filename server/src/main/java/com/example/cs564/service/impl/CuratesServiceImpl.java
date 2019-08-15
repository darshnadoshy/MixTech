package com.example.cs564.service.impl;

import com.example.cs564.dao.CuratesDao;
import com.example.cs564.dao.CuratesRepo;
import com.example.cs564.entity.CuratesEntity;
import com.example.cs564.entity.PlaylistEntity;
import com.example.cs564.entity.key.CuratesKey;
import com.example.cs564.service.CuratesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * services related to playlist creation
 */
@Service("CuratesService")
public class CuratesServiceImpl implements CuratesService {
    @Autowired
    private CuratesRepo curatesRepo;
    @Autowired
    private CuratesDao curatesDao;

    /**
     * get all playlist of a user
     * @param uid user id
     * @return playlists of a user
     */
    @Override
    public List<PlaylistEntity> getAllByUid(Long uid) {
        return curatesDao.findAllByUid(uid);
    }

    /**
     * link a playlist that created by a user
     * @param uid user id
     * @param pid playlist id
     */
    @Override
    public void create(Long uid, Long pid) {
        curatesRepo.save(new CuratesEntity(uid, pid));
    }

    /**
     * unlink a playlist that created by a user
     * @param uid user id
     * @param pid playlist id
     */
    @Override
    public void remove(Long uid, Long pid) {
        CuratesKey curatesKey = new CuratesKey(uid, pid);
        curatesRepo.deleteById(curatesKey);
    }
}
