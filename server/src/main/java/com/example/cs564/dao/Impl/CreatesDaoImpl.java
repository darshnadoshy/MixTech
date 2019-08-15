package com.example.cs564.dao.Impl;
import com.example.cs564.dao.CreatesDao;
import com.example.cs564.entity.MatchEntity;
import com.example.cs564.response.DisplayMatchResponse;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * creates table DAO implementation
 */

@Repository
public class CreatesDaoImpl implements CreatesDao{
    @PersistenceContext EntityManager em;

    /**
     * find all matches by user id
     *
     * @param uid user id
     * @return list of matches a user has
     */
    @Override
    public List<MatchEntity> findAllById(Long uid) {
        return em.createNativeQuery("SELECT m.* FROM creates c, matches m " +
                "WHERE c.uid=?1 AND c.mid = m.mid", MatchEntity.class).setParameter(1, uid).getResultList();
    }

}
