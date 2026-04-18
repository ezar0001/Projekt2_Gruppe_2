package org.projekt2_gruppe_2.model;

import java.time.LocalDate;

public class Onskeseddel {
    int id;
    int brugerId;
    String navn;
    LocalDate dato;



    public Onskeseddel(int id, String navn,LocalDate dato, int brugerId) {
        this.dato = dato;
        this.navn = navn;
        this.id = id;
        this.brugerId = brugerId;
    }

    public Onskeseddel(int id, String navn,LocalDate dato) {
        this.dato = dato;
        this.navn = navn;
        this.id = id;
    }

    public Onskeseddel (String navn, LocalDate dato){
        this.navn=navn;
        this.dato=dato;

    }
    public Onskeseddel (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getBrugerId() {
        return brugerId;
    }

    public void setBrugerId(int brugerId) {
        this.brugerId = brugerId;
    }
}
