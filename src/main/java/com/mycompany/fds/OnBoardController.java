
package com.mycompany.fds;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.*;

public class OnBoardController {
    @FXML private JFXButton menuTab;
    @FXML private JFXButton myOrdersTab;
    @FXML private JFXButton myDeliveryTab;
    @FXML private JFXButton logoutTab;

    public void myAccountButton(ActionEvent event){
        System.out.println("Redirecting to my account scene tab...");
        //add you loading or delays - ;-)
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        //stage.setMaximized(true);
        stage.close();
        //Open the application home Onboard.fxml
        Scene scene = null;
        try {
            scene = new Scene((load(getClass().getResource("/fxml/MyAccount.fxml"))));
            System.out.println(scene+"this is the client informations scene");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
