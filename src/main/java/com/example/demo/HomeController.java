package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @RequestMapping("/songform")
    public String loadSongForm(Model model){
        model.addAttribute("song", new Song());
        return "songform";
    }

    @PostMapping("/confirmsongform")
    public String loadFromSong(@Valid Song song, BindingResult result){
        if (result.hasErrors()){
            return "songform";
        }
        return "confirmsong";
    }

}
