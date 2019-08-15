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
 * service related to match creation
 */

@Service("CreatesService")
public class CreatesServiceImpl implements CreatesService {
    @Autowired
    private CreatesRepo createsRepo;
    @Autowired
    private CreatesDao createsDao;

    /**
     * create a match
     * @param createsEntity info for match creation
     */
    @Override
    public void create(CreatesEntity createsEntity) {
        createsRepo.save(createsEntity);
    }

    /**
     * remove a match
     * @param key of match to remove
     */
    @Override
    public void remove(CreatesKey key) {
        createsRepo.deleteById(key);
    }

    /**
     * get all matches of a user
     *
     * @param uid user id
     * @return list of matches
     */
    @Override
    public List<MatchEntity> getAllByUid(Long uid) {
        return createsDao.findAllById(uid);
    }


}
