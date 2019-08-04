package com.example.cs564.dao;

import com.example.cs564.entity.CuratesEntity;
import com.example.cs564.entity.key.CuratesKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratesRepo extends JpaRepository<CuratesEntity, CuratesKey> {
    CuratesEntity findOneByUidAndPid(Long uid, Long pid);
}
