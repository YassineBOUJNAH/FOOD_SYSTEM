package com.mycompany.fds.Controller;
//package com.mycompany.fds.*;

import com.jfoenix.controls.JFXButton;
import com.mycompany.fds.model.Client;
import com.mycompany.fds.model.CurrentUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileFoodController implements Initializable {
    @FXML private Label id;
    @FXML private Label username;
    @FXML private Label nom;
    @FXML private Label prenom;
    @FXML private Label email;
    @FXML private Label password;
    @FXML private ImageView photo;
    @FXML private JFXButton update;
    @FXML private JFXButton delete;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setText(String.valueOf(CurrentUser.id));
        username.setText(String.valueOf(CurrentUser.username));
        nom.setText(String.valueOf(CurrentUser.name));
        //prenom.setText(String.valueOf(CurrentUser.prenom));
        email.setText(String.valueOf(CurrentUser.email));
        password.setText(String.valueOf(CurrentUser.password));
        Image image = new Image(CurrentUser.photo);
        photo.setImage(image);
    }


    /*
    public void getUserInfo(Client client){
        username.setText(client.getUsername());
        password.setText(client.getName());
    }

     */


}
