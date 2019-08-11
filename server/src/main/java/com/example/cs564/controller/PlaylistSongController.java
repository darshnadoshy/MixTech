package com.example.cs564.controller;

import com.example.cs564.entity.SongEntity;
import com.example.cs564.service.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/playlist_song")
public class PlaylistSongController {
    @Autowired
    private PlaylistSongService playlistSongService;

    @ResponseBody
    @RequestMapping(value = "/all/{pid}", method = RequestMethod.GET)
    public List<SongEntity> getAllByPid(@PathVariable Long pid) {
        return playlistSongService.getAllByPid(pid);
    }

    @ResponseBody
    @RequestMapping(value = "/add/{pid}", method = RequestMethod.PUT)
    public void add(@RequestParam String spotify_uri, @PathVariable Long pid) {
        playlistSongService.add(spotify_uri, pid);
    }

    @ResponseBody
    @RequestMapping(value = "/remove/{pid}", method = RequestMethod.DELETE)
    public void remove(@RequestParam String spotify_uri, @PathVariable Long pid) {
        playlistSongService.remove(spotify_uri, pid);
    }

}
