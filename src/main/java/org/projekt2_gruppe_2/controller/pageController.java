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

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class pageController {

    @Autowired
    InitData initdata;

    @GetMapping("/")
    public String mainPage(){
        return "forside";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "Login";
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
    public String addWish(@RequestParam String navn,
                          @RequestParam int pris,
                          @RequestParam String link,
                          @RequestParam int seddelId) {

        int newId = initdata.getOnskeList().size() + 1;

        initdata.getOnskeList().add(
                new Onske(newId, navn, pris, "gave.jpg", link, 1, seddelId)
        );

        return "redirect:/seddel?id=" + seddelId;
    }

    @GetMapping("/deleteWish")
    public String deleteWish(@RequestParam int id,
                             @RequestParam int seddelId){

        initdata.getOnskeList().removeIf(o -> o.getId() == id);

        return "redirect:/seddel?id=" + seddelId;}


    @GetMapping("/editWish")
    public String editWish(@RequestParam int id,
                           @RequestParam int seddelId,
                           Model model){

        for(Onske o : initdata.getOnskeList()){
            if(o.getId() == id){
                model.addAttribute("onske", o);
            }
        }

        model.addAttribute("seddelId", seddelId);

        return "editWish";
    }


    @GetMapping("/createSeddel")
    public String createSeddel(){
        return "createSeddel";
    }

    @PostMapping("/saveCreateSeddel")
    public String createSeddel (@RequestParam String navn, @RequestParam LocalDate dato){
        int newId = initdata.getOnskeseddelList().size()+1;

        initdata.getOnskeseddelList().add(new Onskeseddel(newId,navn,dato));

        return "redirect:/bruger";
    }

    @PostMapping("/updateWish")
    public String updateWish(@RequestParam int id,
                             @RequestParam String navn,
                             @RequestParam int pris,
                             @RequestParam String link,
                             @RequestParam int seddelId){

        for(Onske o : initdata.getOnskeList()){
            if(o.getId() == id){
                o.setNavn(navn);
                o.setPris(pris);
                o.setLink(link);
            }
        }

        return "redirect:/seddel?id=" + seddelId;
    }


}
