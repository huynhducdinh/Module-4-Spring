package com.example.bai2.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;

public class SongDto implements Validator {

    private Integer id;
    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800,message = "Tên bài hát không được 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên bài hát không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String nameSong;

    @NotBlank(message = "Tên nghệ sĩ không được để trống")
    @Size(max = 300,message = "Tên nghệ sĩ không được 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên nghệ sũ không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String artistName;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 1000,message = "Tên bài hát không được 1000 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9, ]+$", message = "Tên nghệ sũ không chứa các kí tự đặc biệt như @;,.=-+,....Nhưng cho dấu ','")
    private String musicType;

    public SongDto() {
    }

    public SongDto(Integer id, String nameSong, String artistName, String musicType) {
        this.id = id;
        this.nameSong = nameSong;
        this.artistName = artistName;
        this.musicType = musicType;
    }

    public SongDto(String nameSong, String artistName, String musicType) {
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


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
