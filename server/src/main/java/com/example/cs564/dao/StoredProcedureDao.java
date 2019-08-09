package com.example.cs564.dao;

import com.example.cs564.entity.PlaylistEntity;

public interface StoredProcedureDao {
    void createPlaylist(Long uid, PlaylistEntity playlistEntity);
}
