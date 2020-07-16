package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<Song> allSongs = new ArrayList<Song>();

    @RequestMapping("/songform")
    public String loadSongForm(Model model){
        model.addAttribute("song", new Song());
        return "songform";
    }

    @PostMapping("/confirmsongform")
    public String loadFromSong(@Valid Song song, BindingResult result, Model model){
        if (result.hasErrors()){
            return "songform";
        }
        allSongs.add(song);
        model.addAttribute("allSongs", allSongs);
        return "confirmsong";
    }

    @RequestMapping("/listAllSongs")
    public String listAllSongs(Model model){
        model.addAttribute("allSongs", allSongs);
        return "confirmsong";
    }

}
