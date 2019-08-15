package com.example.cs564.service;

import com.example.cs564.entity.CreatesEntity;
import com.example.cs564.entity.MatchEntity;
import com.example.cs564.entity.key.CreatesKey;


import java.util.List;

/**
 * services related to creation of matches
 */

public interface CreatesService {
    public void create(CreatesEntity createsEntity);
    public void remove(CreatesKey key);

    List<MatchEntity> getAllByUid(Long uid);
}
