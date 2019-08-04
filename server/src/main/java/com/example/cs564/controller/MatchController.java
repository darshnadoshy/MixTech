package com.example.cs564.controller;

import com.example.cs564.entity.MatchEntity;
import com.example.cs564.entity.key.CreatesKey;
import com.example.cs564.service.CreatesService;
import com.example.cs564.entity.CreatesEntity;
import com.example.cs564.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/match")
public class MatchController {
    @Autowired
    private MatchService matchService;
    @Autowired
    private CreatesService createsService;

    @ResponseBody
    @RequestMapping(value = "/all/{uid}", method = RequestMethod.GET)
    public List<MatchEntity> getAll(@PathVariable Long uid) {
        return createsService.getAllByUid(uid);
    }

    @ResponseBody
    @RequestMapping(value = "/follow/{uid}", method = RequestMethod.POST)
    public void create(@RequestBody MatchEntity matchEntity, @PathVariable Long uid) {
        matchService.create(matchEntity);
        CreatesEntity createsEntity = new CreatesEntity();
        createsEntity.setMid(matchEntity.getMid());
        createsEntity.setUid(uid);
        createsService.create(createsEntity);

    }

    //Delete a match by ID
    @RequestMapping(value = "/delete/{mid}/{uid}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Long mid, @PathVariable long uid) {
        matchService.remove(mid);
        CreatesKey key = new CreatesKey(uid, mid);
        createsService.remove(key);
    }
}
