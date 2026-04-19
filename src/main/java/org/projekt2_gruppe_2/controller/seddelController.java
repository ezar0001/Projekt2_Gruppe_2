package org.projekt2_gruppe_2.controller;

import org.projekt2_gruppe_2.model.Onskeseddel;
import org.projekt2_gruppe_2.repository.OnskeseddelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class seddelController {

    @Autowired
    OnskeseddelRepository seddelRepo;

    @PostMapping("/saveCreateSeddel")
    public String createSeddel (@RequestParam String navn, @RequestParam String dato){
        LocalDate localdateDato = LocalDate.parse(dato);

        Onskeseddel seddel= new Onskeseddel(navn, localdateDato);
        seddelRepo.save(seddel);

        return "redirect:/bruger";
    }

    @GetMapping("/createSeddel")
    public String createSeddel(){
        return "createSeddel";
    }


    @GetMapping("/deleteSeddel/{id}")
    public String deleteSeddel (@PathVariable int id){
        seddelRepo.deleteSeddel(id);
        return "redirect:/bruger";
    }



}
