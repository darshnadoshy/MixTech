package com.example.cs564.dao.Impl;

import com.example.cs564.dao.IncludesDao;
import com.example.cs564.entity.SongEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * includes table DAO implementation
 */

@Repository
public class IncludesDaoImpl implements IncludesDao {
    @PersistenceContext
    private EntityManager em;

    /**
     * find all songs in a playlist
     *
     * @param pid playlist id
     * @return list of songs included in a playlist
     */
    @Override
    public List<SongEntity> findAllByPid(Long pid) {
        return em.createNativeQuery("select s.* from song s, include i " +
                "where i.pid = ?1 and i.spotify_uri = s.spotify_uri", SongEntity.class)
                .setParameter(1, pid).getResultList();
    }
}
