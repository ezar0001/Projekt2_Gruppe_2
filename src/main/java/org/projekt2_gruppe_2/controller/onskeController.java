package org.projekt2_gruppe_2.controller;

import org.projekt2_gruppe_2.model.Onske;
import org.projekt2_gruppe_2.repository.OnskeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class onskeController {

    @Autowired
    OnskeRepository onskeRepo;

    @GetMapping("/createOnske")
    public String createOnske(@RequestParam int seddelId, Model model) {
        model.addAttribute("seddelId", seddelId);
        return "createOnske";
    }

    @GetMapping("/deleteOnske/{id}")
    public String deleteOnske(@PathVariable int id, @RequestParam int seddelId) {
        onskeRepo.deleteOnske(id);
        return "redirect:/seddel?id=" + seddelId;
    }

    //ny
    @PostMapping("/savecreateOnske")
    public String addWish(@RequestParam String navn,
                          @RequestParam int pris,
                          @RequestParam String link,
                          @RequestParam int antal,
                          @RequestParam int seddelId) {
        Onske newOnske = new Onske(0, navn, pris, "gave.jpg", link, antal, seddelId);

        onskeRepo.save(newOnske);
        return "redirect:/seddel?id=" + seddelId;
    }

}
