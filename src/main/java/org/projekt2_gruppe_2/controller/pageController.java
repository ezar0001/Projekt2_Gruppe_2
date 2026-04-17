package org.projekt2_gruppe_2.controller;

import org.projekt2_gruppe_2.config.InitData;
import org.projekt2_gruppe_2.model.Bruger;
import org.projekt2_gruppe_2.model.Onske;
import org.projekt2_gruppe_2.model.Onskeseddel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class pageController {

    @Autowired
    InitData initdata;

    @GetMapping("/")
    public String mainPage(){
        return "forside";
    }

    @GetMapping("/bruger")
    public String brugerPage(Model model){
        ArrayList<Onskeseddel> onskeseddelList = new ArrayList<>();

        onskeseddelList.addAll(initdata.getOnskeseddelList());

        model.addAttribute("onskeseddelList",onskeseddelList);

        return "brugerForside";
    }

    @GetMapping("/seddel")
    public String seddelPage(@RequestParam int id, Model model){

        ArrayList<Onske>onskeList = new ArrayList<>();
        for(Onske o: initdata.getOnskeList()){
            if (o.getOnskeSeddelId()==id){
                onskeList.add(o);
            }
        }

        model.addAttribute("onskeList",onskeList);

        return "onskeseddel";
    }


    @PostMapping ("/login")
    public String login (@RequestParam String username,@RequestParam String kodeord, Model model ){
        for (Bruger b : initdata.getBrugerList()){
            if (b.getUsername().equals(username) && b.getKodeord().equals(kodeord)){
                return "redirect:/bruger";


            }
        }
        model.addAttribute("error", "Forkert login");
        return "forside";
    }


    @PostMapping("/addWish")
    public String addWish (@RequestParam String navn, @RequestParam int pris,@RequestParam String link){
        int newId = initdata.getOnskeList().size()+1;

        initdata.getOnskeList().add(new Onske(newId,navn,pris, "gave.jpg",link,1,1));

        return "redirect:/seddel?id=1";
    }
}
