package com.mycompany.fds;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class FoodPageController implements Initializable {

    @FXML
    private JFXButton bar2;
    @FXML
    private JFXButton bar1;
    @FXML
    private AnchorPane paneslide;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneslide.setTranslateX(-153);
        bar1.setVisible(true);
        bar2.setVisible(false);
    }

    public void run1(javafx.scene.input.MouseEvent mouseEvent) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(paneslide);
        slide.setToX(0);
        slide.play();
        paneslide.setTranslateX(-153);
        slide.setOnFinished((ActionEvent e) -> {
            bar1.setVisible(false);
            bar2.setVisible(true);
        });
    }

    public void run2(javafx.scene.input.MouseEvent mouseEvent) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(paneslide);
        slide.setToX(-153);
        slide.play();
        paneslide.setTranslateX(0);
        slide.setOnFinished((ActionEvent e) -> {
            bar1.setVisible(true);
            bar2.setVisible(false);
        });
    }
}
