package com.mycompany.fds.Controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CommandePage implements Initializable {
    public Label lab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void getFood(String titre){
        lab.setText(titre);
    }
}
