package com.example.cs564.controller;

import com.example.cs564.entity.PlaylistEntity;
import com.example.cs564.entity.SongEntity;
import com.example.cs564.entity.key.CuratesKey;
import com.example.cs564.service.CuratesService;
import com.example.cs564.service.PlaylistService;
import com.example.cs564.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private CuratesService curatesService;

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public Page<SongEntity> getAllSongsByPage(@RequestParam(value = "page", defaultValue = "0") int page,
//                                         @RequestParam(value = "size", defaultValue = "10") int size) {
//        return null;
//    }

    // get all songs from a playlist
    @ResponseBody
    @RequestMapping(value = "/all/{uid}", method = RequestMethod.GET)
    public List<PlaylistEntity> getAll(@PathVariable Long uid) {
        return curatesService.getAllByUid(uid);
    }

    @RequestMapping(value = "/create/{uid}", method = RequestMethod.POST)
    public void create (@PathVariable Long uid, @RequestBody PlaylistEntity playlistEntity) {
        playlistService.create(uid, playlistEntity);
    }

    // delete a song by id
    @RequestMapping(value = "/delete/{uid}/{pid}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Long uid, @PathVariable Long pid) {
        curatesService.remove(uid, pid);
        playlistService.remove(pid);
    }
}
