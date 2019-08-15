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

/**
 * This class handles all requests related to matches. Each method takes some
 * form of input and passes it to a corresponding service class which
 * performs the necessary actions.
 */
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

    /**
     * Get the actual song objects (Not just SpotifyIDs) in a match
     * @param mid The Match ID to retrieve songs from
     * @return The songs entities of the match (JSON objects to request)
     */
    @ResponseBody
    @RequestMapping(value = "/getsongs/{mid}", method = RequestMethod.GET)
    public List<SongEntity> getAllByMid(@PathVariable Long mid) {
        MatchEntity matchEntity = matchService.getByMid(mid);
        List<SongEntity> songs = new ArrayList<>();
        songs.add(songService.getByID(matchEntity.getSpotifyUri1()));
        songs.add(songService.getByID(matchEntity.getSpotifyUri2()));
        return songs;
    }

    /** Get all the matches from a user
     *
     * @param uid ID of the user to retrieve all matches from
     * @return List of match responses
     */
    @ResponseBody
    @RequestMapping(value = "/all/{uid}", method = RequestMethod.GET)
    public List<DisplayMatchResponse> displayMatchByUid(@PathVariable Long uid) {
        return matchService.displayMatchByUid(uid);
    }

    /** Get all the incomplete matches from a user
     *
     * @param uid ID of the user to retrieve all incomplete matches from
     * @return List of only incomplete match responses
     */
    @ResponseBody
    @RequestMapping(value = "/incomplete/{uid}", method = RequestMethod.GET)
    public List<DisplayMatchResponse> displayIncompleteMatchByUid(@PathVariable Long uid) {
        return matchService.displayIncompleteMatchByUid(uid);
    }

    /** Get all of the COMPLETE matches from a user
     *
     * @param uid ID of the user to retrieve from
     * @return List of only complete matches belonging to a user
     */
    @ResponseBody
    @RequestMapping(value = "/complete/{uid}", method = RequestMethod.GET)
    public List<DisplayMatchResponse> displayCompleteMatchByUid(@PathVariable Long uid) {
        return matchService.displayCompleteMatchByUid(uid);
    }

//    @ResponseBody
//    @RequestMapping(value = "/follow/{uid}", method = RequestMethod.POST)
//    public void create(@RequestBody MatchEntity matchEntity, @PathVariable Long uid) {
//        matchService.create(matchEntity);
//        CreatesEntity createsEntity = new CreatesEntity();
//        createsEntity.setMid(matchEntity.getMid());
//        createsEntity.setUid(uid);
//        createsService.create(createsEntity);
//    }

    /** Create a new match and optionally set the first song
     *
     * @param spotifyUri1 URI of the FIRST song in a match
     * @param uid User that the match will belong to.
     */
    @ResponseBody
    @RequestMapping(value = "/create/{uid}", method = RequestMethod.POST)
    public void create(@RequestParam String spotifyUri1, @PathVariable Long uid) {
        matchService.create(spotifyUri1, uid);
    }

    /** Add a song to an incomplete match
     *
     * @param uid The user ID of the match creator
     * @param mid The Match ID to add the song too
     * @param spotifyUri2 The spotify ID of the SECOND song in the matches
     * @return The response to the request stating success or failure
     */
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

    /** Remove a match from the matches and creates tables.
     *
     * @param mid ID of the match to delete
     * @param uid ID of match creator
     */
    @RequestMapping(value = "/delete/{mid}/{uid}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Long mid, @PathVariable long uid) {
        CreatesKey key = new CreatesKey(uid, mid);
        createsService.remove(key);
        matchService.remove(mid);
    }
}
