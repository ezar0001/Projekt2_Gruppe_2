package org.projekt2_gruppe_2.model;

public class Onskeseddel {
    int id;
    int brugerId;
    String navn;
    String dato;

    public Onskeseddel(String dato, String navn, int id, int brugerId) {
        this.dato = dato;
        this.navn = navn;
        this.id = id;
        this.brugerId = brugerId;
    }

    public Onskeseddel(String dato, String navn, int id) {
        this.dato = dato;
        this.navn = navn;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
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
