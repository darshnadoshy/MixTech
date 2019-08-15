package com.example.cs564.service.impl;

import com.example.cs564.dao.CreatesRepo;
import com.example.cs564.dao.MatchDao;
import com.example.cs564.dao.MatchRepo;
import com.example.cs564.entity.CreatesEntity;
import com.example.cs564.entity.MatchEntity;
import com.example.cs564.entity.SongEntity;
import com.example.cs564.request.CreateMatchRequest;
import com.example.cs564.response.DisplayMatchResponse;
import com.example.cs564.service.MatchService;
import com.example.cs564.utils.SystemConstant;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service related to matches
 */
@Service("MatchService")
public class MatchServiceImpl implements MatchService{
    @Autowired
    private MatchRepo matchRepo;
    @Autowired
    private MatchDao matchDao;
    @Autowired
    private CreatesRepo createsRepo;

    /**
     * display a page of matches
     *
     * @param page page number
     * @param size number of entries in a page
     * @return a page of match info
     */
    @Override
    public Page<MatchEntity> getAllByPage(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "mid");
        Pageable pageable = PageRequest.of(page, size, sort);
        return matchRepo.findAll(pageable);
    }

    /**
     * similar to getAllByPage(), but returns a list
     * @return a list of all matches
     */
    @Override
    public List<MatchEntity> getAll() {
        return matchRepo.findAll();
    }

    /**
     * create by a complete entity of match info
     * @param matchEntity match info
     */
    @Override
    public void create(MatchEntity matchEntity) {
        matchRepo.save(matchEntity);
    }

    /**
     * create an incomplete match
     * @param spotifyUri1 song id
     * @param uid user id
     */
    @Override
    public void create(String spotifyUri1, Long uid) {
        Long mid = matchRepo.save(new MatchEntity(spotifyUri1)).getMid();
        createsRepo.save(new CreatesEntity(uid, mid));
    }

    /**
     * remove a match from user library
     * @param mid match id
     */
    @Override
    public void remove(Long mid) {
        matchRepo.deleteById(mid);
    }

    /**
     * add a song to incomplete match
     * @param spotifyUri2 song id
     * @param mid match id
     * @param uid user id
     * @return ret code
     */
    @Override
    public int addSong(String spotifyUri2, Long mid, Long uid)
    {
        String spotifyUri1 = matchRepo.findByMid(mid).getSpotifyUri1();
        if (spotifyUri1.equals(spotifyUri2)) { return SystemConstant.RET_ERR_DUPSONG; }
        if (matchDao.getMatchBySongs(spotifyUri1, spotifyUri2, uid)!=null
                || matchDao.getMatchBySongs(spotifyUri2, spotifyUri1, uid)!=null ) {
            return SystemConstant.RET_ERR_DUPMATCH;
        }
        matchDao.addSongTwo(spotifyUri2, mid);
        return SystemConstant.RET_SUC;
    }

    /**
     * display all match info based on mid
     * @param mid match id
     * @return match info
     */
    @Override
    public MatchEntity getByMid(Long mid) {
        return matchRepo.findByMid(mid);
    }

    /**
     * find all matches a user has
     * @param uid user id
     * @return list of match-name pairs
     */
    @Override
    public List<DisplayMatchResponse> displayMatchByUid(Long uid) {
        return matchDao.displayMatch(uid);
    }

    /**
     * find all complete matches a user has
     * @param uid user id
     * @return list of match-name pairs
     */
    @Override
    public List<DisplayMatchResponse> displayCompleteMatchByUid(Long uid) {
        return matchDao.displayCompleteMatch(uid);
    }

    /**
     * find all incomplete matches a user has
     * @param uid user id
     * @return list of match-name pairs
     */
    @Override
    public List<DisplayMatchResponse> displayIncompleteMatchByUid(Long uid) {
        return matchDao.displayIncompleteMatch(uid);
    }

    /**
     * basic search: find all matches with sname
     * @param sname search key word
     * @return list of match-name pairs
     */
    @Override
    public List<DisplayMatchResponse> displayMatchBySnmae(String sname) {
        return matchDao.displayAllMatchBySname("%" + sname + "%");
    }


}
