package com.example.cs564.controller;

import com.example.cs564.entity.SongEntity;
import com.example.cs564.service.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * This class handles all requests related to playlist SONGS. Each method takes some
 * form of input and passes it to a corresponding service class which
 * performs the necessary actions. This class handles the actions on songs inside
 * a playlist rather than the overall playlist operations, which are handle in the
 * PlayListController Class
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/playlist_song")
public class PlaylistSongController {
    @Autowired
    private PlaylistSongService playlistSongService;


    /** Get all the songs from a playlist
     *
     * @param pid Playlist ID to retrieve songs from
     * @return List of song entities in the playlist
     */
    @ResponseBody
    @RequestMapping(value = "/all/{pid}", method = RequestMethod.GET)
    public List<SongEntity> getAllByPid(@PathVariable Long pid) {
        return playlistSongService.getAllByPid(pid);
    }

    /** Add a song to a playlist.
     *
     * @param spotify_uri ID of song to add
     * @param pid Playlist add song to
     */
    @ResponseBody
    @RequestMapping(value = "/add/{pid}", method = RequestMethod.PUT)
    public void add(@RequestParam String spotify_uri, @PathVariable Long pid) {
        playlistSongService.add(spotify_uri, pid);
    }

    /** Remove a specific song from a specific playlist
     *
     * @param spotify_uri ID of song to remove from playlist
     * @param pid ID of playlist to remove song from
     */
    @ResponseBody
    @RequestMapping(value = "/remove/{pid}", method = RequestMethod.DELETE)
    public void remove(@RequestParam String spotify_uri, @PathVariable Long pid) {
        playlistSongService.remove(spotify_uri, pid);
    }

}
