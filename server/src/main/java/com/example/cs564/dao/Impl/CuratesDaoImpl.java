package com.example.cs564.dao.Impl;

import com.example.cs564.dao.CuratesDao;
import com.example.cs564.entity.PlaylistEntity;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CuratesDaoImpl implements CuratesDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PlaylistEntity> findAllByUid(Long uid) {
        return em.createNativeQuery("SELECT p.* FROM curates c, playlists p " +
                "WHERE c.uid=?1 AND c.pid = p.pid", PlaylistEntity.class).setParameter(1, uid).getResultList();
    }
}
