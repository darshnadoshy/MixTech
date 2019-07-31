package com.example.cs564.controller;

import com.example.cs564.entity.SongEntity;
import com.example.cs564.request.AdvanceSearchRequest;
import com.example.cs564.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    private SongService songService;

    @ResponseBody
    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public List<SongEntity> getAllByName(String sname) {
        return songService.getAllByName(sname);
    }

    @ResponseBody
    @RequestMapping(value = "/advance", method = RequestMethod.GET)
    public List<SongEntity> getAllByAudioFeatures(@RequestBody AdvanceSearchRequest request) {
        return songService.getAllByAudioFeatures(request);
    }

}
