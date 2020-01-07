package com.mycompany.fds;

import java.sql.DriverManager;
import com.mycompany.fds.api.DbConnection;
import com.mycompany.fds.api.ProfHelper;
import com.mycompany.fds.model.Prof;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

 
    public static void main(String[] args) {
        
        System.out.println("hello");

        try (
                Connection con =DbConnection.getConnection();
                )
        {
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs=stmt.executeQuery("select * from prof where id = '1'");
            ArrayList proflist = ProfHelper.getProf(rs);
            Prof p1= (Prof) proflist.get(0);
            System.out.println(p1.getUsername());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        launch(args);
    

}
}

