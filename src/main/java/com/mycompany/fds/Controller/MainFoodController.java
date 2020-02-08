package com.mycompany.fds.Controller;

import com.mycompany.fds.FoodController;
import com.mycompany.fds.View.FoodCard;
import com.mycompany.fds.api.ClientHelper;
import com.mycompany.fds.api.DbConnection;
import com.mycompany.fds.api.ProfHelper;
import com.mycompany.fds.api.RepasHelper;
import com.mycompany.fds.model.Client;
import com.mycompany.fds.model.Prof;
import com.mycompany.fds.model.Repas;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
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
            //repasList.forEach((repasItem) -> System.out.println(repasItem));
            Repas r1= (Repas) repasList.get(0);
            Repas r2= (Repas) repasList.get(1);

            AnchorPane Card1 = FoodCard.creat(r1.getNomRepas() , r1.getImg());
            //AnchorPane Card2 = FoodCard.creat(r2.getNomRepas(), r2.getImg());
            System.out.println(r2.getImg());
            //Card2.setLayoutY(120);

           paneA.getChildren().add(Card1);
            //paneA.getChildren().add(Card2);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
