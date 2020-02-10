package com.mycompany.fds.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mycompany.fds.model.CurrentPanier;
import com.mycompany.fds.model.CurrentUser;
import com.mycompany.fds.model.Repas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.sound.midi.SysexMessage;
import java.net.URL;
import java.util.ResourceBundle;

public class CommandePage implements Initializable {

    private int totalQuantite = 0;
    private int totalPrix;
    @FXML private Label idRepas;
    @FXML private Label nomRepas;
    @FXML private Label description;
    @FXML private Label quantite;
    @FXML private Label prix;
    @FXML private Label total;
    @FXML private JFXButton addRepas;
    @FXML private JFXButton deleteRepas;
    @FXML private JFXButton valider;
    @FXML private JFXButton annuler;
    @FXML private ImageView photo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void getFood(Repas r1){
        //int idRepasActuel = r1.getIdRepas();
        //int qteRepasActuel = r1.getRank();
        idRepas.setText(String.valueOf(r1.getIdRepas()));
        nomRepas.setText(r1.getNomRepas());
        description.setText(r1.getDescription());
        quantite.setText(String.valueOf(r1.getRank()));
        prix.setText(String.valueOf(r1.getPrix()));
        Image image = new Image(r1.getImg());
        photo.setImage(image);
    }

    public void validerCommande(ActionEvent actionEvent){
        System.out.println("You clicke me");
        int idRepasActuel = Integer.parseInt(idRepas.getText());
        int qteRepasActuel = Integer.parseInt(quantite.getText());
        CurrentPanier.ligneCommande.put(idRepasActuel, qteRepasActuel);
        int testQ = CurrentPanier.ligneCommande.get(idRepasActuel);
        System.out.println(testQ);
        System.out.println("id repas actuel : "+idRepasActuel+" avec quantité: "+qteRepasActuel);

    }


}
