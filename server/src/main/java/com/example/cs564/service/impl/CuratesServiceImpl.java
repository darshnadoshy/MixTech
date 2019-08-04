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

@Service("CuratesService")
public class CuratesServiceImpl implements CuratesService {
    @Autowired
    private CuratesRepo curatesRepo;
    @Autowired
    private CuratesDao curatesDao;

    @Override
    public List<PlaylistEntity> getAllByUid(Long uid) {
        return curatesDao.findAllByUid(uid);
    }

    @Override
    public void create(Long uid, Long pid) {
        curatesRepo.save(new CuratesEntity(uid, pid));
    }

    @Override
    public void remove(Long uid, Long pid) {
        CuratesKey curatesKey = new CuratesKey(uid, pid);
        curatesRepo.deleteById(curatesKey);
    }
}
