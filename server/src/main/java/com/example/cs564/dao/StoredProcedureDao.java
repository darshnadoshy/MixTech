package com.example.cs564.dao;

import com.example.cs564.entity.PlaylistEntity;
/**
 * all stored procedure calles
 * implement by manually
 */

public interface StoredProcedureDao {
    void createPlaylist(Long uid, PlaylistEntity playlistEntity);
    void removePlaylist(Long uid, Long pid);
    void updatePlaylistPrivacy(Long pid, Integer privacy);
}
