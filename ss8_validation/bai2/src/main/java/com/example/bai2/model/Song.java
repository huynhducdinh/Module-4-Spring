package com.example.bai2.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameSong;
    @Column(name = "artist_name",columnDefinition = "TEXT",nullable = false)
    private String artistName;
    private String musicType;

    public Song() {
    }

    public Song(String nameSong, String artistName, String musicType) {
        this.nameSong = nameSong;
        this.artistName = artistName;
        this.musicType = musicType;
    }

    public Song(Integer id, String nameSong, String artistName, String musicType) {
        this.id = id;
        this.nameSong = nameSong;
        this.artistName = artistName;
        this.musicType = musicType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }
}
