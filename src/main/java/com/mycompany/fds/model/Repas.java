package com.mycompany.fds.model;

public class Repas {
    private int idRepas;
    private String nomRepas;
    private float prix;
    
    public Repas(int idRepas, String nomRepas, float prix){
        this.idRepas = idRepas;
        this.nomRepas = nomRepas;
        this.prix = prix;
    }
    
    public int getIdRepas() {
        return idRepas;
    }
    
    public void setIdRepas(int idRepas) {
        this.idRepas = idRepas;
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
