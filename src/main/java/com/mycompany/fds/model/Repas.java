package com.mycompany.fds.model;

public class Repas {
    private String id;
    private String nomRepas;
    private float prix;
    
    public Repas(String id, String nomRepas, float prix){
        this.id = id;
        this.nomRepas = id;
        this.prix = prix;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getNomRepas() {
        return nomRepas;
    }

    public void setNomRepas(String nomRepas) {
        this.nomRepas = nomRepas;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    
}
