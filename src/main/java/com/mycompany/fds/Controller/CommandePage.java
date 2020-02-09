package com.mycompany.fds.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mycompany.fds.model.CurrentUser;
import com.mycompany.fds.model.Repas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class CommandePage implements Initializable {

    private int totalQuantite = 0;
    private int totalPrix;
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


        nomRepas.setText(r1.getNomRepas());
        description.setText(r1.getDescription());
        quantite.setText(String.valueOf(r1.getRank()));
        prix.setText(String.valueOf(r1.getPrix()));
        Image image = new Image(r1.getImg());
        photo.setImage(image);
    }


}
