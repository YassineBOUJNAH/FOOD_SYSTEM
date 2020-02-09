package com.mycompany.fds.Controller;

import com.mycompany.fds.model.Rest;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantPageController implements Initializable {
    public Label lab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void getRest(Rest r){
        lab.setText(r.getNom());
    }
}
