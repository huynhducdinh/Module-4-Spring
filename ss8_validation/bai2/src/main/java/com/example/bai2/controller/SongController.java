package com.example.bai2.controller;

import com.example.bai2.dto.SongDto;
import com.example.bai2.model.Song;
import com.example.bai2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.Pattern;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("/")
    public String listSong(Model model) {
        List<Song> songList = iSongService.findAll();
        model.addAttribute("songList", songList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new SongDto());
        return "create";
    }

    @PostMapping("/createSong")
    public String createSong(@Validated @ModelAttribute("song") SongDto songDto, BindingResult bindingResult , RedirectAttributes attributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            attributes.addFlashAttribute("mess",true);
            return "redirect:/";
        }
    }
    @GetMapping("update/{id}")
    private String update(@PathVariable(value = "id")Integer id,Model model){
        SongDto songDto=new SongDto();
        Song song=iSongService.findById(id);
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("songDto",songDto);
        return "update";
    }
    @PostMapping("edit")
    public  String editSong( @Validated @ModelAttribute SongDto songDto,BindingResult bindingResult, RedirectAttributes attributes ){
        new  SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "update";
        }else {
            Song song=new Song();
            BeanUtils.copyProperties(songDto,song);
            iSongService.save(song);
            attributes.addFlashAttribute("flag",true);
            return "redirect:/";
        }
    }
}
