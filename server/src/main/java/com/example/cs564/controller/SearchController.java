package com.example.cs564.controller;

import com.example.cs564.entity.SongEntity;
import com.example.cs564.request.AdvanceSearchRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public List<SongEntity> getAllByName(String name) {
        return null;
    }

    @RequestMapping(value = "/advance", method = RequestMethod.GET)
    public List<SongEntity> getAllByAudioFeatures(@RequestBody AdvanceSearchRequest request) {
        return null;
    }

}
