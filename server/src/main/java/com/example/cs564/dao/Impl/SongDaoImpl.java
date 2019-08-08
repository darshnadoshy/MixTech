package com.example.cs564.dao.Impl;

import com.example.cs564.dao.SongDao;
import com.example.cs564.entity.SongEntity;
import com.example.cs564.request.AdvanceSearchRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class SongDaoImpl implements SongDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<SongEntity> findAllByAudioFeatures(String query) {
        return em.createNativeQuery(query, SongEntity.class).getResultList();
    }

//    @Override
//    public List<SongEntity> findAllByAudioFeatures(AdvanceSearchRequest request) {
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        CriteriaQuery<SongEntity> criteriaQuery = criteriaBuilder.createQuery(SongEntity.class);
//        Root<SongEntity> root = criteriaQuery.from(SongEntity.class);
//
//        Predicate p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12;
//
//        Path danceability = root.get("danceability");
//        Path energy = root.get("energy");
//        Path skey = root.get("skey");
//        Path loudness = root.get("loudness");
//        Path smode = root.get("smode");
//        Path speechiness = root.get("speechiness");
//        Path acousticness = root.get("acousticness");
//        Path instrumentalness = root.get("instrumentalness");
//        Path liveness = root.get("liveness");
//        Path valence = root.get("valence");
//        Path tempo = root.get("tempo");
//        Path duration_ms = root.get("duration_ms");
//
//        p1 = criteriaBuilder.between(danceability, request.getDanceability0(), request.getDanceability1());
//        p2 = criteriaBuilder.between(energy, request.getEnergy0(), request.getEnergy1());
//        p3 = criteriaBuilder.between(skey, request.getSkey0(), request.getSkey1());
//        p4 = criteriaBuilder.between(loudness, request.getLoudness0(), request.getLoudness1());
//        p5 = criteriaBuilder.between(smode, request.getSmode0(), request.getSmode1());
//        p6 = criteriaBuilder.between(speechiness, request.getSpeechiness0(), request.getSpeechiness1());
//        p7 = criteriaBuilder.between(acousticness, request.getAcousticness0(), request.getAcousticness1());
//        p8 = criteriaBuilder.between(instrumentalness, request.getInstrumentalness0(), request.getInstrumentalness1());
//        p9 = criteriaBuilder.between(liveness, request.getLiveness0(), request.getLiveness1());
//        p10 = criteriaBuilder.between(valence, request.getValence0(), request.getValence1());
//        p11 = criteriaBuilder.between(tempo, request.getTempo0(), request.getTempo1());
//        p12 = criteriaBuilder.between(duration_ms, request.getDuration_ms0(), request.getDuration_ms1());
//
//        criteriaQuery.where(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
////        criteriaQuery.where(p1);
//
//        TypedQuery<SongEntity> query = em.createQuery(criteriaQuery);
//        return query.getResultList();
//    }
}
