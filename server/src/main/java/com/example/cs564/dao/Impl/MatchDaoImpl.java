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
//        return em.createNativeQuery("select s1.sname AS sname1, s2.sname AS sname2 from match m, song s1, song s2" +
//                "where m.spotifyUri1 = s1.sname and m.spotifyUri2 = s2.sname and m.uid = ?1", DisplayMatchResponse.class)
//                .setParameter(1, uid).getResultList();
        return em.createQuery("select New com.example.cs564.response.DisplayMatchResponse(s1.sname, s2.sname)" +
                " from MatchEntity m, SongEntity s1, SongEntity s2, CreatesEntity c " +
                "where m.spotifyUri1 = s1.spotifyID and m.spotifyUri2 = s2.spotifyID " +
                "and m.mid = c.mid and c.uid = ?1", DisplayMatchResponse.class)
                .setParameter(1, uid).getResultList();
    }
}
