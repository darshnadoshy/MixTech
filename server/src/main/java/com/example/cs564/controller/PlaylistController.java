package com.example.cs564.controller;

import com.example.cs564.entity.PlaylistEntity;
import com.example.cs564.response.StandardResponse;
import com.example.cs564.service.CuratesService;
import com.example.cs564.service.FollowsService;
import com.example.cs564.service.PlaylistService;
import com.example.cs564.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private CuratesService curatesService;
    @Autowired
    private FollowsService followsService;

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public Page<SongEntity> getAllSongsByPage(@RequestParam(value = "page", defaultValue = "0") int page,
//                                         @RequestParam(value = "size", defaultValue = "10") int size) {
//        return null;
//    }


    // get all songs from a playlist
    @ResponseBody
    @RequestMapping(value = "/all/{uid}", method = RequestMethod.GET)
    public List<PlaylistEntity> getAllPlaylists(@PathVariable Long uid) {
        return curatesService.getAllByUid(uid);
    }

    @ResponseBody
    @RequestMapping(value = "/all/following/{uid}", method = RequestMethod.GET)
    public List<PlaylistEntity> getAllFollowingPlaylists(@PathVariable Long uid) {
        return followsService.getAllByUid(uid);
    }

    @RequestMapping(value = "/create/{uid}", method = RequestMethod.POST)
    public void create (@PathVariable Long uid, @RequestBody PlaylistEntity playlistEntity) {
        playlistService.create(uid, playlistEntity);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{uid}/{pid}", method = RequestMethod.DELETE)
    public StandardResponse remove(@PathVariable Long uid, @PathVariable Long pid) {
        StandardResponse response = new StandardResponse();
        if ( !playlistService.remove(uid, pid) ) {
            response.setRet(SystemConstant.RET_ERR);
            response.setMsg(SystemConstant.MSG_UNAUTH_ACCESS);
        } else {
            response.setRet(SystemConstant.RET_SUC);
            response.setMsg(SystemConstant.MSG_SUCCESS);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/privacy/{uid}/{pid}", method = RequestMethod.PUT)
    public StandardResponse privacy(@PathVariable Long uid, @PathVariable Long pid, @RequestParam int privacy) {
        StandardResponse response = new StandardResponse();
        if ( !playlistService.privacy(uid, pid, privacy) ) {
            response.setRet(SystemConstant.RET_ERR);
            response.setMsg(SystemConstant.MSG_UNAUTH_ACCESS);
        } else {
            response.setRet(SystemConstant.RET_SUC);
            response.setMsg(SystemConstant.MSG_SUCCESS);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/follow/{uid}/{pid}", method = RequestMethod.POST)
    public StandardResponse follow(@PathVariable Long uid, @PathVariable Long pid) {
        StandardResponse response = new StandardResponse();
        if ( !followsService.follow(pid, uid)) {
            response.setRet(SystemConstant.RET_ERR);
            response.setMsg(SystemConstant.MSG_UNAUTH_ACCESS);
        } else {
            response.setRet(SystemConstant.RET_SUC);
            response.setMsg(SystemConstant.MSG_SUCCESS);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/unfollow/{uid}/{pid}", method = RequestMethod.DELETE)
    public StandardResponse unfollow(@PathVariable Long uid, @PathVariable Long pid) {
        StandardResponse response = new StandardResponse();
        followsService.unfollow(pid, uid);
        response.setRet(SystemConstant.RET_SUC);
        response.setMsg(SystemConstant.MSG_SUCCESS);
        return response;
    }
}
