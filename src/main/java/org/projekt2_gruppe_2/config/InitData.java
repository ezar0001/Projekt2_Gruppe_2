package org.projekt2_gruppe_2.config;

import org.projekt2_gruppe_2.model.Bruger;
import org.projekt2_gruppe_2.model.Onske;
import org.projekt2_gruppe_2.model.Onskeseddel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class InitData {
    private ArrayList<Onske> onskeList= new ArrayList<>();

    private ArrayList<Onskeseddel>onskeseddelList = new ArrayList();

    private ArrayList<Bruger>brugerList= new ArrayList<>();

public InitData(){
    onskeList.add(new Onske(1,"OPtto", 1000, "Gave.jpg", "link", 2,1));
    onskeList.add(new Onske(2,"Lotto", 3000, "Gave.jpg", "link", 2,1));
    onskeList.add(new Onske(3,"toilet", 5000, "Gave.jpg", "link", 2,2));
    onskeList.add(new Onske(4,"badekar", 6000, "Gave.jpg", "link", 2,2));
    onskeseddelList.add(new Onskeseddel(1, "Julegaveonsker", LocalDate.of(2026,12,24)));
    onskeseddelList.add(new Onskeseddel(2, "FødselsdagsØnsker", LocalDate.of(2026,12,24)));

}

public ArrayList<Onske> getOnskeList(){return onskeList;}
public ArrayList<Onskeseddel> getOnskeseddelList(){return onskeseddelList;}
public ArrayList<Bruger> getBrugerList(){return brugerList;}

}
