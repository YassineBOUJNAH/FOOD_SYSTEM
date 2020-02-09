package com.mycompany.fds.Controller;

import com.mycompany.fds.model.Repas;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CommandePage implements Initializable {
    public Label lab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void getFood(Repas r1){
        lab.setText(r1.getNomRepas());
    }
}
