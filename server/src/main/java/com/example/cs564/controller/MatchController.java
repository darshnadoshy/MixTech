package com.example.cs564.controller;

import com.example.cs564.dao.MatchRepo;
import com.example.cs564.entity.MatchEntity;
import com.example.cs564.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/match")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<MatchEntity> getAll() {
        return matchService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody MatchEntity matchEntity) {
        matchService.create(matchEntity);
    }

    //Delete a match by ID
    @RequestMapping(value = "/delete/{pid}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Long mid) {
        matchService.remove(mid);
    }
}
