package com.mycompany.fds.model;

public class Commande {
    
    private String id;
    private String etat;

    public Commande(String id, String etat) {
        this.id = id;
        this.etat = etat;
    }

    public String getId() {
        return id;
    }

    public String getEtat() {
        return etat;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    
}
