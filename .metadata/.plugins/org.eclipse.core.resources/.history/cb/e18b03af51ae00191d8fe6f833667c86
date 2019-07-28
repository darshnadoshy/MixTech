package com.example.cs564.controller;

import com.example.cs564.entity.SongEntity;
import com.example.cs564.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public Page<SongEntity> getAllSongsByPage(@RequestParam(value = "page", defaultValue = "0") int page,
//                                         @RequestParam(value = "size", defaultValue = "10") int size) {
//        return null;
//    }

    // get all songs from a playlist
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<SongEntity> getAll() {
        return null;
    }

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public SongEntity getSongById(String spotify_uri) {
        return null;
    }

    // delete a song by id
    @RequestMapping(value = "/delete/{pid}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Long sid) {

    }
}
