package com.mycompany.fds.View;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;



public class FoodCard {

    public static AnchorPane creat(String titre,String img){
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(240);
        anchorPane.setPrefWidth(250);
        Image img2 = new Image(img);
        ImageView image = new ImageView();
        image.setFitHeight(250);
        image.setFitWidth(150);
        image.setImage(img2);
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
