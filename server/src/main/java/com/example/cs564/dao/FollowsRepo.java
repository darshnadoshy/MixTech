package com.example.cs564.dao;

import com.example.cs564.entity.FollowsEntity;
import com.example.cs564.entity.key.FollowsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Direct Access Object to follows table
 * utilize Spring JPA's built-in functionalities
 */

public interface FollowsRepo extends JpaRepository<FollowsEntity, FollowsKey> {
    FollowsEntity findByPidAndUid(Long pid, Long uid);
    List<FollowsEntity> findAllByPid(Long pid);

    @Transactional
    @Modifying
    @Query(value = "Update FollowsEntity f set f.access = :access where f.pid = :pid and f.uid = :uid")
    void updateAccessByPidAndUid(@Param("pid") Long pid, @Param("uid") Long uid, @Param("access") int access);
}
