package com.example.cs564.dao.Impl;

import com.example.cs564.dao.MatchDao;
import com.example.cs564.response.DisplayMatchResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MatchDaoImpl implements MatchDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<DisplayMatchResponse> displayMatch(Long uid) {
        return em.createNativeQuery("select s1.sname, s2.sname from match m, song s1, song s2" +
                "where m.spotify_uri1 = s1.sname and m.spotify_uri2 = s2.sname", DisplayMatchResponse.class)
                .getResultList();
    }
}
