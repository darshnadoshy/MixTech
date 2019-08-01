package com.example.cs564.service;

import com.example.cs564.entity.MatchEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MatchService {
    Page<MatchEntity> getAllByPage(int page, int size);
    List<MatchEntity> getAll();
    void create(MatchEntity matchEntity);
    void remove(Long pid);

}
