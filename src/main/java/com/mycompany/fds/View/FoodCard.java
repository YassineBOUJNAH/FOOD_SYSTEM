package com.mycompany.fds.View;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


public class FoodCard {

    public static AnchorPane creat(String titre,String img) throws MalformedURLException, URISyntaxException, FileNotFoundException {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(240);
        anchorPane.setPrefWidth(250);
        Image img2 = new Image(img);
        ImageView image = new ImageView(img2);

       // image.setImage(img2);
      //  image.setFitHeight(250);
        //image.setFitWidth(150);

        Label lab = new Label();
        lab.setLayoutX(14);
        lab.setLayoutX(150);
        lab.setPrefHeight(44);
        lab.setPrefWidth(207);
        lab.setText(titre);

        anchorPane.getChildren().add(image);
        anchorPane.getChildren().add(lab);
        return anchorPane;
    }
}
