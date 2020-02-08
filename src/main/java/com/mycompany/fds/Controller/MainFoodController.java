package com.mycompany.fds.Controller;

import com.dukescript.layouts.flexbox.FlexboxLayout;
import com.dukescript.layouts.jfxflexbox.FlexBoxPane;
import com.jfoenix.controls.JFXListView;
import com.mycompany.fds.FoodController;
import com.mycompany.fds.View.FoodCard;
import com.mycompany.fds.View.RestaurantCard;
import com.mycompany.fds.api.*;
import com.mycompany.fds.model.Client;
import com.mycompany.fds.model.Prof;
import com.mycompany.fds.model.Repas;
import com.mycompany.fds.model.Rest;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class MainFoodController implements Initializable {

    public AnchorPane paneA;
    public JFXListView listeRepas;
    public FlexBoxPane restPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneA.getStylesheets().add("/styles/Styles.css");
        try (
                Connection con = DbConnection.getConnection();
        )
        {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            //Query to show disponible foods
            ResultSet repasDatabase = stmt.executeQuery("select * from repas ");
            ArrayList repasList = RepasHelper.getRepas(repasDatabase);
            repasList.forEach((repasItem) ->
            {
                Repas r1 = (Repas) repasItem;
                try {
                    AnchorPane Card1 = FoodCard.creat(r1.getNomRepas(), r1.getImg(), r1.getPrix(), r1.getDescription());
                    listeRepas.getItems().add(Card1);
                } catch (Exception e) {
                    e.printStackTrace();
            }});

            listeRepas.setOrientation(Orientation.HORIZONTAL);
            listeRepas.setFocusTraversable(false);
            listeRepas.getStylesheets().add("/styles/Styles.css");
            listeRepas.getStyleClass().add("listeRepas");

//restaurant
            ResultSet restDatabase = stmt.executeQuery("select * from restaurant");
            ArrayList restList = RestHelper.getRest(restDatabase);
            restPane.setAlignContent(FlexboxLayout.AlignContent.SPACE_AROUND);
            restPane.setFlexDirection(FlexboxLayout.FlexDirection.ROW);
            restList.forEach((restItem) ->
            {
                Rest r2 = (Rest) restItem;
                try {
                    AnchorPane Card1 = RestaurantCard.creat(r2.getNom(),r2.getImages(),r2.getDescription());
                    FlexBoxPane.setGrow(Card1, 1.0f);
                    FlexBoxPane.setMargin(Card1, new Insets(5));
                    FlexBoxPane.setFlexBasisPercent(Card1, 10f);
                    restPane.getChildren().add(Card1);


                } catch (Exception e) {
                    e.printStackTrace();
                }});


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
