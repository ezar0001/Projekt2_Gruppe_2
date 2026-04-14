package org.projekt2_gruppe_2.controller;

import org.projekt2_gruppe_2.config.initdata;
import org.projekt2_gruppe_2.model.Onskeseddel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class pageController {

    @Autowired
    initdata initdata;

    @GetMapping("/")
    public String mainPage(){
        return "Forside";
    }

    @GetMapping("/bruger")
    public String brugerPage(Model model){
        ArrayList<Onskeseddel> onskeseddelList = new ArrayList<>();

        onskeseddelList.addAll(initdata.getOnskeseddelList());

        model.addAttribute("onskeseddelList",onskeseddelList);

        return "brugerForside";
    }
}
