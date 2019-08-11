package com.example.cs564.service.impl;

import com.example.cs564.dao.MatchDao;
import com.example.cs564.dao.MatchRepo;
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

@Service("MatchService")
public class MatchServiceImpl implements MatchService{
    @Autowired
    private MatchRepo matchRepo;
    @Autowired
    private MatchDao matchDao;

    @Override
    public Page<MatchEntity> getAllByPage(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "mid");
        Pageable pageable = PageRequest.of(page, size, sort);
        return matchRepo.findAll(pageable);
    }

    @Override
    public List<MatchEntity> getAll() {
        return matchRepo.findAll();
    }

    @Override
    public void create(MatchEntity matchEntity) {
        matchRepo.save(matchEntity);
    }

    @Override
    public void create(CreateMatchRequest createMatchRequest, Long uid) {
        matchRepo.save(new MatchEntity(createMatchRequest.getMname(), createMatchRequest.getSpotifyUri1()));
    }

    @Override
    public void remove(Long mid) {
        matchRepo.deleteById(mid);
    }

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

    @Override
    public MatchEntity getByMid(Long mid) {
        return matchRepo.findByMid(mid);
    }

    @Override
    public List<DisplayMatchResponse> displayMatchByUid(Long uid) {
        return matchDao.displayMatch(uid);
    }

    @Override
    public List<DisplayMatchResponse> displayCompleteMatchByUid(Long uid) {
        return matchDao.displayCompleteMatch(uid);
    }

    @Override
    public List<DisplayMatchResponse> displayIncompleteMatchByUid(Long uid) {
        return matchDao.displayIncompleteMatch(uid);
    }


}
