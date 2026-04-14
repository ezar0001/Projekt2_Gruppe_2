package org.projekt2_gruppe_2.model;

public class Bruger {
int id;
String username;
String kodeord;

public Bruger(int id, String username, String kodeord){
    this.id=id;
    this.username=username;
    this.kodeord=kodeord;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKodeord() {
        return kodeord;
    }

    public void setKodeord(String kodeord) {
        this.kodeord = kodeord;
    }
}
