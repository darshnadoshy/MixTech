package com.example.cs564.dao.Impl;

import com.example.cs564.dao.StoredProcedureDao;
import com.example.cs564.entity.PlaylistEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class StoredProcedureDaoImpl implements StoredProcedureDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void createPlaylist(Long uid, PlaylistEntity playlistEntity) {
        StoredProcedureQuery  storedProcedureQuery = em.createStoredProcedureQuery("create_playlist");
        storedProcedureQuery.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

        storedProcedureQuery.setParameter(1, uid);
        storedProcedureQuery.setParameter(2, playlistEntity.getPname());
        storedProcedureQuery.setParameter(3, playlistEntity.getPrivacy());
        storedProcedureQuery.setParameter(4, playlistEntity.getDescription());

        storedProcedureQuery.execute();
    }
}
