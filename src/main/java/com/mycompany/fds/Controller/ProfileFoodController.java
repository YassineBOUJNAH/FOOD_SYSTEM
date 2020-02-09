package com.mycompany.fds.Controller;
//package com.mycompany.fds.*;

import com.mycompany.fds.model.Client;
import com.mycompany.fds.model.CurrentUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileFoodController implements Initializable {
    @FXML
    private Label id;
    @FXML
    private Label username;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label email;
    @FXML
    private Label password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setText(String.valueOf(CurrentUser.id));
        username.setText(String.valueOf(CurrentUser.username));
        nom.setText(String.valueOf(CurrentUser.name));
        //prenom.setText(String.valueOf(CurrentUser.prenom));
        email.setText(String.valueOf(CurrentUser.email));
        password.setText(String.valueOf(CurrentUser.password));
    }


    /*
    public void getUserInfo(Client client){
        username.setText(client.getUsername());
        password.setText(client.getName());
    }

     */


}
