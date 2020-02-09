package com.mycompany.fds.View;

import com.jfoenix.utils.JFXUtilities;
import com.mycompany.fds.Controller.CommandePage;
import com.mycompany.fds.Controller.FoodPageController;
import com.mycompany.fds.Controller.MainFoodController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import static javafx.scene.text.TextAlignment.CENTER;
import static javafx.scene.text.TextAlignment.LEFT;


public class FoodCard {

    public static AnchorPane creat(String titre,String img,double prix,String des) throws MalformedURLException, URISyntaxException, FileNotFoundException {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(110);
        anchorPane.setPrefWidth(140);
        Image img2 = new Image(img);
        ImageView image = new ImageView(img2);

       // image.setImage(img2);
        image.setFitHeight(110);
        image.setFitWidth(144);
        image.setPickOnBounds(true);
        image.setLayoutX(2);


        Label lab = new Label();
        lab.setLayoutX(5);
        lab.setLayoutY(100);
        lab.setPrefHeight(44);
        lab.setPrefWidth(140);
        lab.setText(" "+titre);
        lab.setStyle("-fx-font-weight: bold;" );
        lab.setTextAlignment( CENTER );
        lab.setAlignment(Pos.CENTER);

        Label lab2 = new Label();
        lab2.setLayoutX(5);
        lab2.setLayoutY(120);
        lab2.setPrefHeight(44);
        lab2.setPrefWidth(140);
        lab2.setText(prix+"DH "+des);
        anchorPane.getStylesheets().add("/styles/Styles.css");

        anchorPane.getChildren().add(image);
        anchorPane.getChildren().add(lab);
        anchorPane.getChildren().add(lab2);
        anchorPane.getStyleClass().add("h");

        anchorPane.setOnMouseClicked((e) -> {
            System.out.println(titre);
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Parent root;
            try {
                root = loader.load(FoodCard.class.getResource("/fxml/commandePage.fxml").openStream());
                System.out.println(root);
                Scene scene = new Scene(root);
                CommandePage commandePage = (CommandePage) loader.getController();
                commandePage.getFood(titre);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        return anchorPane;
    }



}
