package com.example.cs564.controller;

import com.example.cs564.entity.PlaylistEntity;
import com.example.cs564.response.StandardResponse;
import com.example.cs564.service.CuratesService;
import com.example.cs564.service.FollowsService;
import com.example.cs564.service.PlaylistService;
import com.example.cs564.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * This class handles all requests related to playlists. Each method takes some
 * form of input and passes it to a corresponding service class which
 * performs the necessary actions. This class handles the general creation/deletion
 * of playlists and following/un methods while the playListSongController handles
 * operations on the actual songs belonging to a playlist.
 */
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

    /** Get all the playlists belonging to a user
     *
     * @param uid User ID to get playlists from
     * @return List of playlist entities belonging to the UID
     */
    @ResponseBody
    @RequestMapping(value = "/all/{uid}", method = RequestMethod.GET)
    public List<PlaylistEntity> getAllPlaylists(@PathVariable Long uid) {
        return curatesService.getAllByUid(uid);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @ResponseBody
//    @RequestMapping(value = "/all_page/{uid}")
//    public List<PlaylistEntity> getAllPlaylistsInPage(@PathVariable Long uid,
//                                                      @RequestParam(value = "page", defaultValue = "0") int page,
//                                                      @RequestParam(value = "size", defaultValue = "10") int size) {
//        return playlistService.getAllByPage(uid, page, size);
//    }

    /** Get a playlist by its ID
     *
     * @param pid ID of the playlist to retrieve
     * @return PlaylistEntity
     */
    @ResponseBody
    @RequestMapping(value = "/display/{pid}", method = RequestMethod.GET)
    public PlaylistEntity getPlaylistByPid(@PathVariable Long pid) {
        return playlistService.getByPid(pid);
    }

    /** Get all the playlists a user is following
     *
     * @param uid User ID to retrieve following playlists from
     * @return List of playList Entities a user follows
     */
    @ResponseBody
    @RequestMapping(value = "/all/following/{uid}", method = RequestMethod.GET)
    public List<PlaylistEntity> getAllFollowingPlaylists(@PathVariable Long uid) {
        return followsService.getAllByUid(uid);
    }

    /** Create a new playlist
     *
     * @param uid UserID the playlist will belong to
     * @param playlistEntity Info to create playlist from
     */
    @RequestMapping(value = "/create/{uid}", method = RequestMethod.POST)
    public void create (@PathVariable Long uid, @RequestBody PlaylistEntity playlistEntity) {
        playlistService.create(uid, playlistEntity);
    }

    /** Delete a playlist
     *
     * @param uid User the playlist to delete belongs to
     * @param pid playlist ID to delete
     * @return A response detailing success or failure
     */
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

    /** Set a playlist's privacy
     *
     * @param uid UserId to which the playlist belongs
     * @param pid Playlist ID of which to adjust privacy
     * @param privacy
     * @return Response detailing method success/failure
     */
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

    /** Follow a playlist
     *
     * @param uid UserID to follow a playlist
     * @param pid ID of playlist to follow
     * @return Info on method success/failure
     */
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

    /** Unfollow a playlist
     *
     * @param uid ID of user to stop following playlist
     * @param pid ID of playlist to stop following.
     * @return Response detailing method success/failure
     */
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
