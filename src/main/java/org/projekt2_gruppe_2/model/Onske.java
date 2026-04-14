package org.projekt2_gruppe_2.model;

public class Onske {
    int id;
    int onskeSeddelId;
    String navn;
    int pris;
    String img;
    String link;
    int antal;

    public Onske(int id, String navn, int pris, String img, String link, int antal, int onskeSeddelId) {
        this.id = id;
        this.antal = antal;
        this.link = link;
        this.img = img;
        this.pris = pris;
        this.navn = navn;
        this.onskeSeddelId = onskeSeddelId;
    }

    public Onske(int id, String navn, int pris, String img, String link, int antal) {
        this.id = id;
        this.navn = navn;
        this.pris = pris;
        this.img = img;
        this.link = link;
        this.antal = antal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
