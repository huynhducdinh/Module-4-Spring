package com.example.bai2.service;

import com.example.bai2.dto.SongDto;
import com.example.bai2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void  save(Song song);
    Song findById(Integer id);

}
