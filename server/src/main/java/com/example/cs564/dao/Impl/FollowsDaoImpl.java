package com.example.cs564.dao.Impl;

import com.example.cs564.dao.FollowsDao;
import com.example.cs564.entity.PlaylistEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * curates table DAO implementation
 */

@Repository
public class FollowsDaoImpl implements FollowsDao {
    @PersistenceContext
    private EntityManager em;

    /**
     * find all playlists followed by a user
     *
     * @param uid user id
     * @return list of playlists a user follows
     */
    @Override
    public List<PlaylistEntity> getAllByUid(Long uid) {
        return em.createNativeQuery("select p.* from follows f, playlists p " +
                "where f.pid = p.pid and f.uid = ?1", PlaylistEntity.class).setParameter(1, uid).getResultList();
    }
}
