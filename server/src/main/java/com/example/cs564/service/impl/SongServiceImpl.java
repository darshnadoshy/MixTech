package com.example.cs564.service.impl;

import com.example.cs564.dao.SongDao;
import com.example.cs564.dao.SongRepo;
import com.example.cs564.entity.SongEntity;
import com.example.cs564.request.AdvanceSearchRequest;
import com.example.cs564.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * song service implementation
 */
@Service("SongService")
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepo songRepo;
    @Autowired
    private SongDao songDao;

    /**
     * get a single song by its id
     * @param spotifyID song id
     * @return the song info
     */
    @Override
    public SongEntity getByID(String spotifyID) {
        return songRepo.findBySpotifyID(spotifyID);
    }

    /**
     * basic search;: get songs with name like sname
     * @param sname search key word
     * @return lists of basic search results
     */
    @Override
    public List<SongEntity> getAllByName(String sname) {
        Sort sort = new Sort(Sort.Direction.DESC, "popularity");
        return songRepo.findBySnameLike("%" + sname + "%",sort);
    }

    /**
     * similar to getAllByName(), but return a page
     * @param name search key word
     * @param page page number
     * @param size size of a page
     * @return lists of basic search results in that page
     */
    @Override
    public List<SongEntity> getAllByNameInPage(String name, int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "popularity");
        Pageable pageable = PageRequest.of(page, size, sort);
        return songRepo.findBySnameLike("%" + name + "%", pageable);
    }

    /**
     * advance search
     * @param request advance search criterion
     * @return advance search results
     */
    @Override
    public List<SongEntity> getAllByAudioFeatures(AdvanceSearchRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from song where");
        stringBuilder.append(" skey = ").append(request.getSkey().toString());
        stringBuilder.append(" AND smode = ").append(request.getSmode().toString());
        if (request.getDanceability0() != 0) {
            stringBuilder.append(" AND danceability >= ").append(request.getDanceability0().toString());
        }
        if (request.getDanceability1() != 1) {
            stringBuilder.append(" AND danceability <= ").append(request.getDanceability1().toString());
        }
        if (request.getEnergy0() != 0) {
            stringBuilder.append(" AND energy >= ").append(request.getEnergy0().toString());
        }
        if (request.getEnergy1() != 1) {
            stringBuilder.append(" AND energy <= ").append(request.getEnergy1().toString());
        }
        if (request.getLoudness0() != -60) {
            stringBuilder.append(" AND loudness >= ").append(request.getLoudness0().toString());
        }
        if (request.getLoudness1() != 0) {
            stringBuilder.append(" AND loudness <= ").append(request.getLoudness1().toString());
        }
        if (request.getSpeechiness0() != 0) {
            stringBuilder.append(" AND speechiness >= ").append(request.getSpeechiness0().toString());
        }
        if (request.getSpeechiness1() != 1) {
            stringBuilder.append(" AND speechiness <= ").append(request.getSpeechiness1().toString());
        }
        if (request.getAcousticness0() != 0) {
            stringBuilder.append(" AND acousticness >= ").append(request.getAcousticness0().toString());
        }
        if (request.getAcousticness1() != 1) {
            stringBuilder.append(" AND acousticness <= ").append(request.getAcousticness1().toString());
        }
        if (request.getInstrumentalness0() != 0) {
            stringBuilder.append(" AND instrumentalness >= ").append(request.getInstrumentalness0().toString());
        }
        if (request.getInstrumentalness1() != 1) {
            stringBuilder.append(" AND instrumentalness <= ").append(request.getInstrumentalness1().toString());
        }
        if (request.getLiveness0() != 0) {
            stringBuilder.append(" AND liveness >= ").append(request.getLiveness0().toString());
        }
        if (request.getLiveness1() != 1) {
            stringBuilder.append(" AND liveness <= ").append(request.getLiveness1().toString());
        }
        if (request.getValence0() != 0) {
            stringBuilder.append(" AND valence >= ").append(request.getValence0().toString());
        }
        if (request.getValence1() != 1) {
            stringBuilder.append(" AND valence <= ").append(request.getValence1().toString());
        }
        if (request.getTempo0() != 0) {
            stringBuilder.append(" AND tempo >= ").append(request.getTempo0().toString());
        }
        if (request.getTempo1() != 250) {
            stringBuilder.append(" AND tempo <= ").append(request.getTempo1().toString());
        }
        stringBuilder.append(" order by popularity desc;");
        System.out.println(stringBuilder.toString());
        return songDao.findAllByAudioFeatures(stringBuilder.toString());
    }



//    @Override
//    public List<SongEntity> getAllByAudioFeatures(AdvanceSearchRequest request) {
//
//        return songDao.findAllByAudioFeatures(request);
//    }


}
