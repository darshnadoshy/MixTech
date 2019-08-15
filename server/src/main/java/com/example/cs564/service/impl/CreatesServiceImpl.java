package com.example.cs564.service.impl;

import com.example.cs564.dao.CreatesDao;
import com.example.cs564.dao.CreatesRepo;
import com.example.cs564.entity.CreatesEntity;
import com.example.cs564.entity.MatchEntity;
import com.example.cs564.entity.key.CreatesKey;
import com.example.cs564.service.CreatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * creates
 */

@Service("CreatesService")
public class CreatesServiceImpl implements CreatesService {
    @Autowired
    private CreatesRepo createsRepo;
    @Autowired
    private CreatesDao createsDao;

    @Override
    public void create(CreatesEntity createsEntity) {
        createsRepo.save(createsEntity);
    }

    @Override
    public void remove(CreatesKey key) {
        createsRepo.deleteById(key);
    }

    @Override
    public List<MatchEntity> getAllByUid(Long uid) {
        return createsDao.findAllById(uid);
    }


}
