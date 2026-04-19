package org.projekt2_gruppe_2.controller;

import org.projekt2_gruppe_2.config.InitData;
import org.projekt2_gruppe_2.model.Bruger;
import org.projekt2_gruppe_2.model.Onske;
import org.projekt2_gruppe_2.model.Onskeseddel;
import org.projekt2_gruppe_2.repository.OnskeRepository;
import org.projekt2_gruppe_2.repository.OnskeseddelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class pageController {

    @Autowired
    InitData initdata;

    @Autowired
    OnskeseddelRepository seddelRepo;

    @Autowired
    OnskeRepository onskeRepo;

    @GetMapping("/")
    public String mainPage() {
        return "forside";
    }


    @GetMapping("/bruger")
    public String brugerPage(Model model) {
        ArrayList<Onskeseddel> seddelList = new ArrayList<>();

        seddelList.addAll(seddelRepo.getAllSeddel());

        model.addAttribute("seddelList", seddelList);

        return "brugerForside";
    }

    // skal nok også ind i seddelController
    @GetMapping("/seddel")
    public String seddelPage(@RequestParam int id, Model model) {

        ArrayList<Onske> onskeList = new ArrayList<>();
        for (Onske o : onskeRepo.getAllOnske()) {
            if (o.getOnskeSeddelId() == id) {
                onskeList.add(o);
            }
        }

        model.addAttribute("onskeList", onskeList);

        return "onskeseddel";
    }

    

    //ny


//    @PostMapping ("/login")
//    public String login (@RequestParam String username,@RequestParam String kodeord, Model model ){
//        for (Bruger b : initdata.getBrugerList()){
//            if (b.getUsername().equals(username) && b.getKodeord().equals(kodeord)){
//                return "redirect:/bruger";
//
//
//            }
//        }
//        model.addAttribute("error", "Forkert login");
//        return "forside";
//    }

    //skal ind i onskeController
//    @PostMapping("/addWish")
//    public String addWish (@RequestParam String navn, @RequestParam int pris,@RequestParam String link){
//        int newId = initdata.getOnskeList().size()+1;
//
//        initdata.getOnskeList().add(new Onske(newId,navn,pris, "gave.jpg",link,1,1));
//
//        return "redirect:/seddel?id=1";
//    }
//skal ind i seddelController
}
