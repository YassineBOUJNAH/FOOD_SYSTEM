package com.mycompany.fds.model;

public class Commande {
    
    private Integer id;
    private String etat;
    private  String address;
    private String date;
    private  Integer prix;
    private int client;


    public Commande(Integer id, String address, String date, Integer prix, int client) {
        this.id = id;
        this.address = address;
        this.date = date;
        this.prix = prix;
        this.client = client;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    
}
