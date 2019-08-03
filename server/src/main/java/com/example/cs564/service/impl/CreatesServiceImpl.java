package com.example.cs564.service.impl;

import com.example.cs564.dao.CreatesRepo;
import com.example.cs564.entity.CreatesEntity;
import com.example.cs564.entity.key.CreatesKey;
import com.example.cs564.service.CreatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CreatesService")
public class CreatesServiceImpl implements CreatesService {
    @Autowired
    private CreatesRepo createsRepo;

    @Override
    public void create(CreatesEntity createsEntity) {
        createsRepo.save(createsEntity);
    }

    @Override
    public void remove(CreatesKey key) {
        createsRepo.deleteById(key);
    }


}
