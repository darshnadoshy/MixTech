package com.example.cs564.dao.Impl;

import com.example.cs564.dao.MatchDao;
import com.example.cs564.entity.MatchEntity;
import com.example.cs564.response.DisplayMatchResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    @Transactional
    public void addSongTwo(String spotifyUri2, Long mid) {
        em.createNativeQuery("update matches set spotify_uri2 = ?1 where mid = ?2")
                .setParameter(1, spotifyUri2)
                .setParameter(2, mid).executeUpdate();
    }

    public List<DisplayMatchResponse> displayCompleteMatch(Long uid) {
        return em.createQuery("select New com.example.cs564.response.DisplayMatchResponse(s1.sname, s2.sname)" +
                " from MatchEntity m, SongEntity s1, SongEntity s2, CreatesEntity c " +
                "where m.spotifyUri1 = s1.spotifyID and m.spotifyUri2 = s2.spotifyID " +
                "and m.mid = c.mid and c.uid = ?1", DisplayMatchResponse.class)
                .setParameter(1, uid).getResultList();
    }

    @Override
    public List<DisplayMatchResponse> displayIncompleteMatch(Long uid) {
        return em.createQuery("select New com.example.cs564.response.DisplayMatchResponse(s.sname)" +
                " from MatchEntity m, SongEntity s, CreatesEntity c " +
                "where m.spotifyUri1 = s.spotifyID and m.spotifyUri2 IS NULL " +
                "and m.mid = c.mid and c.uid = ?1", DisplayMatchResponse.class)
                .setParameter(1, uid).getResultList();
    }

    @Override
    public List<DisplayMatchResponse> displayAllMatchBySname(String sname) {
        return em.createQuery("select distinct New com.example.cs564.response.DisplayMatchResponse(s1.sname, s2.sname)" +
                " from MatchEntity m, SongEntity s1, SongEntity s2 " +
                "where (s1.sname like ?1 or s2.sname like ?1) " +
                "and m.spotifyUri1 = s1.spotifyID and m.spotifyUri2 = s2.spotifyID ", DisplayMatchResponse.class)
                .setParameter(1, sname).getResultList();
    }

    @Override
    public MatchEntity getMatchBySongs(String spotifyUri1, String sporifyUri2, Long uid) {
        Query query = em.createNativeQuery("select m.* from matches m, creates c " +
                "where c.mid = m.mid and m.spotify_uri1 = ?1 and m.spotify_uri2 = ?2 " +
                "and c.uid = ?3", MatchEntity.class)
                .setParameter(1, spotifyUri1)
                .setParameter(2, sporifyUri2)
                .setParameter(3, uid);
        try {
            MatchEntity matchEntity = (MatchEntity) query.getSingleResult();
            return matchEntity;
        } catch (NoResultException e) {
            return null;
        }

    }
}
