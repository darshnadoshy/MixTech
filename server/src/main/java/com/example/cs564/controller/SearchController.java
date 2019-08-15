package com.example.cs564.controller;

import com.example.cs564.entity.SongEntity;
import com.example.cs564.request.AdvanceSearchRequest;
import com.example.cs564.response.DisplayMatchResponse;
import com.example.cs564.service.MatchService;
import com.example.cs564.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


/**
 *  This class sets up and handles all requests related to searching songs. Requests pass
 *  parameters to service classes which implement the needed work.
 */
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    private SongService songService;
    @Autowired
    private MatchService matchService;

    /** Basic search on song name that returns pages of song results.
     *
     * @param name Song name to query
     * @param page The page to return
     * @param size Size of page to return
     * @return List of song entities matching the query
     */
    @ResponseBody
    @RequestMapping(value = "/basic_page", method = RequestMethod.GET)
    public List<SongEntity> getAllSongsInPage(String name,
                                              @RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "size", defaultValue = "10") int size) {
        return songService.getAllByNameInPage(name, page, size);
    }

    /** Search for the matches that contain a particular song
     *
     * @param sname name of song to be in the matches
     * @return list of matches with corresponding song queried in them
     */
    @ResponseBody
    @RequestMapping(value = "/basic_matches", method = RequestMethod.GET)
    public List<DisplayMatchResponse> getAllMatchByName(@RequestParam String sname) {
        return matchService.displayMatchBySnmae(sname);
    }


    /** Search the songs by songname
     *
     * @param sname Song name
     * @return List of songs with song name in the title
     */
    @ResponseBody
    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public List<SongEntity> getAllByName(@RequestParam String sname) {
        return songService.getAllByName(sname);
    }

    /** Query songs based on a certain audio features.
     *
     * @param request Request entailing the details of the audio features to search on.
     * @return List of songs with song name in the title.
     */
    @ResponseBody
    @RequestMapping(value = "/advance", method = RequestMethod.POST)
    public List<SongEntity> getAllByAudioFeatures(@RequestBody AdvanceSearchRequest request) {
        return songService.getAllByAudioFeatures(request);
    }

}
