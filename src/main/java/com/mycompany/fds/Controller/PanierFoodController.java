package com.mycompany.fds.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.mycompany.fds.View.FoodCard;
import com.mycompany.fds.model.Commande;
import com.mycompany.fds.model.CurrentUser;
import com.mycompany.fds.model.Rest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Properties;
import java.util.ResourceBundle;

public class PanierFoodController implements Initializable {
    public JFXButton afficherButton;
    public JFXButton confirmerButton;
    public JFXButton trackerButton;

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        trackerButton.setVisible(false);


        String sql = "SELECT * FROM Commande Where client = ? ";
        ObservableList<Commande> data = FXCollections.observableArrayList();


        /*try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, CurrentUser.id+"");
           // resultSet = preparedStatement.executeQuery();
           // while (resultSet.next()) {
                //Commande c = new Commande(resultSet.getInt("id"),resultSet.getString("address"),resultSet.getString("date"),resultSet.getInt("prix"),resultSet.getInt("client"));
                // data.add(c);
           // }


             } catch (SQLException e) {
            e.printStackTrace();
              }
        // tablePanier2.setItems(data);*/
    }

        public void afficherAction(MouseEvent mouseEvent) {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root;
        try {
            root = loader.load(FoodCard.class.getResource("/fxml/currentList.fxml").openStream());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void confirmerAction(MouseEvent mouseEvent) {
        confirmerButton.setVisible(false);
        trackerButton.setVisible(true);
        trackerButton.toFront();
        afficherButton.setVisible(false);
    }

    public void trackerAction(MouseEvent mouseEvent) {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root;
       try {
            root = loader.load(FoodCard.class.getResource("/fxml/currentTrack.fxml").openStream());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
