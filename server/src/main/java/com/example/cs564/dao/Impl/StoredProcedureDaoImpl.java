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

    @Override
    public void removePlaylist(Long uid, Long pid) {
        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("remove_playlist");
        storedProcedureQuery.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);

        storedProcedureQuery.setParameter(1, uid);
        storedProcedureQuery.setParameter(2, pid);

        storedProcedureQuery.execute();
    }

    @Override
    public void updatePlaylistPrivacy(Long pid, Integer privacy) {
        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("change_privacy");
        storedProcedureQuery.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);

        storedProcedureQuery.setParameter(1, pid);
        storedProcedureQuery.setParameter(2, privacy);

        storedProcedureQuery.execute();
    }


}
