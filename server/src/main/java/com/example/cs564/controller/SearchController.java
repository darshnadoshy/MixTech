package com.example.cs564.controller;

import com.example.cs564.entity.SongEntity;
import com.example.cs564.request.AdvanceSearchRequest;
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

@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    private SongService songService;

    @RequestMapping(value = "/basic_page", method = RequestMethod.GET)
    public List<SongEntity> getAllSongsInPage(String name,
                                              @RequestParam(value = "page", defaultValue = "0") int page,
                                              @RequestParam(value = "size", defaultValue = "10") int size) {
        return songService.getAllByNameInPage(name, page, size);
    }

    @ResponseBody
    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public List<SongEntity> getAllByName(@RequestParam String sname) {
        return songService.getAllByName(sname);
    }

    @ResponseBody
    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(value = "/advance", method = RequestMethod.POST)
    public List<SongEntity> getAllByAudioFeatures(@RequestBody AdvanceSearchRequest request) {
        return songService.getAllByAudioFeatures(request);
    }

}
