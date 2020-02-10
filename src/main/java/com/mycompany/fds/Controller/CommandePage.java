package com.mycompany.fds.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mycompany.fds.api.RepasHelper;
import com.mycompany.fds.model.CurrentUser;
import com.mycompany.fds.model.Repas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class CommandePage implements Initializable {

    private int totalQuantite;
    private int prixRepas;
    private int totalPrix;
    @FXML private Label nomRepas;
    @FXML private Label idRepas;
    @FXML private Label description;
    @FXML private Label quantite;
    @FXML private Label prix;
    @FXML private Spinner spinner;
    @FXML private Label total;
    @FXML private JFXButton addRepas;
    @FXML private JFXButton deleteRepas;
    @FXML private JFXButton valider;
    @FXML private JFXButton annuler;
    @FXML private ImageView photo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* Initialiser le spinner à la valeur 0, et minimum valuer = 0 and max 10 commandes par produit
        * */
        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10 ,0);
        this.spinner.setValueFactory(spinnerValueFactory);
        spinner.setEditable(false); //deny la modification de la valeur
        totalQuantite = (int) spinner.getValue();
        total.setText(String.valueOf(totalPrix));
    }
    public void getFood(Repas r1){
        idRepas.setText(String.valueOf(r1.getIdRepas()));
        nomRepas.setText(r1.getNomRepas());
        description.setText(r1.getDescription());
        quantite.setText(String.valueOf(r1.getRank()));
        prix.setText(String.valueOf(r1.getPrix()));
        Image image = new Image(r1.getImg());
        photo.setImage(image);
    }

    @FXML
    public void calculerPrix(){
        prixRepas = Integer.parseInt(prix.getText());
        totalPrix = totalQuantite * prixRepas;
    }

    @FXML
    public void validerCommande(javafx.event.ActionEvent actionEvent) {
        int idRepasActuel = Integer.parseInt(idRepas.getText());
        String nomRepasActuel = nomRepas.getText();
        int quantiteCommande = Integer.parseInt(quantite.getText());
        System.out.println("Vous avez commandé: "+nomRepasActuel
                            +" Quantité "+quantiteCommande);
    }



}
