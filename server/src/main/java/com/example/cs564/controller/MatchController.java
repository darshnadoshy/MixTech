package com.example.cs564.controller;

import com.example.cs564.entity.MatchEntity;
import com.example.cs564.entity.SongEntity;
import com.example.cs564.entity.key.CreatesKey;
import com.example.cs564.request.CreateMatchRequest;
import com.example.cs564.response.DisplayMatchResponse;
import com.example.cs564.response.StandardResponse;
import com.example.cs564.service.CreatesService;
import com.example.cs564.entity.CreatesEntity;
import com.example.cs564.service.MatchService;
import com.example.cs564.service.SongService;
import com.example.cs564.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/match")
public class MatchController {
    @Autowired
    private MatchService matchService;
    @Autowired
    private CreatesService createsService;
    @Autowired
    private SongService songService;

//    @ResponseBody
//    @RequestMapping(value = "/all/{uid}", method = RequestMethod.GET)
//    public List<MatchEntity> getAll(@PathVariable Long uid) {
//        return createsService.getAllByUid(uid);
//    }

    @ResponseBody
    @RequestMapping(value = "/getsongs/{mid}", method = RequestMethod.GET)
    public List<SongEntity> getAllByMid(@PathVariable Long mid) {
        MatchEntity matchEntity = matchService.getByMid(mid);
        List<SongEntity> songs = new ArrayList<>();
        songs.add(songService.getByID(matchEntity.getSpotifyUri1()));
        songs.add(songService.getByID(matchEntity.getSpotifyUri2()));
        return songs;
    }

    @ResponseBody
    @RequestMapping(value = "/all/{uid}", method = RequestMethod.GET)
    public List<DisplayMatchResponse> displayMatchByUid(@PathVariable Long uid) {
        return matchService.displayMatchByUid(uid);
    }

    @ResponseBody
    @RequestMapping(value = "/incomplete/{uid}", method = RequestMethod.GET)
    public List<DisplayMatchResponse> displayIncompleteMatchByUid(@PathVariable Long uid) {
        return matchService.displayIncompleteMatchByUid(uid);
    }

    @ResponseBody
    @RequestMapping(value = "/complete/{uid}", method = RequestMethod.GET)
    public List<DisplayMatchResponse> displayCompleteMatchByUid(@PathVariable Long uid) {
        return matchService.displayCompleteMatchByUid(uid);
    }

    @ResponseBody
    @RequestMapping(value = "/follow/{uid}", method = RequestMethod.POST)
    public void create(@RequestBody MatchEntity matchEntity, @PathVariable Long uid) {
        matchService.create(matchEntity);
        CreatesEntity createsEntity = new CreatesEntity();
        createsEntity.setMid(matchEntity.getMid());
        createsEntity.setUid(uid);
        createsService.create(createsEntity);
    }

    @ResponseBody
    @RequestMapping(value = "/create/{uid}", method = RequestMethod.POST)
    public void create(@RequestBody CreateMatchRequest createMatchRequest, @PathVariable Long uid) {
        matchService.create(createMatchRequest, uid);
    }



    @ResponseBody
    @RequestMapping(value = "/addsong/{uid}/{mid}", method = RequestMethod.POST)
    public StandardResponse addSong(@PathVariable Long uid, @PathVariable Long mid, @RequestParam String spotifyUri2) {
        StandardResponse response = new StandardResponse();
        int ret = matchService.addSong(spotifyUri2, mid, uid);
        if (ret == SystemConstant.RET_ERR_DUPSONG) {
            response.setRet(SystemConstant.RET_ERR);
            response.setMsg(SystemConstant.MSG_MATCH_DUPSONG);
        } else if (ret == SystemConstant.RET_ERR_DUPMATCH) {
            response.setRet(SystemConstant.RET_ERR);
            response.setMsg(SystemConstant.MSG_MATCH_DUPMATCH);
        } else if (ret == SystemConstant.RET_SUC){
            response.setRet(SystemConstant.RET_SUC);
            response.setMsg(SystemConstant.MSG_SUCCESS);
        } else {
            response.setRet(SystemConstant.RET_ERR);
            response.setMsg(SystemConstant.MSG_UNKNOWN_ERR);
        }
        return response;
    }

    //Delete a match by ID
    @RequestMapping(value = "/delete/{mid}/{uid}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Long mid, @PathVariable long uid) {
        CreatesKey key = new CreatesKey(uid, mid);
        createsService.remove(key);
        matchService.remove(mid);
    }
}
