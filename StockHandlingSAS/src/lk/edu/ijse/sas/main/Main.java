/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Vidura
 */
public class Main extends Application {
    
    public static boolean isSplashLoad=false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root=FXMLLoader.load(getClass().getResource("/lk/edu/ijse/sas/view/Login.fxml"));
        
        Scene myScene=new Scene(root);
        primaryStage.setScene(myScene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/lk/edu/ijse/sas/resource/icon/We_take_security_seriously-b4d46d3e0f1c4a70c9f1f22af7e38849.png")));
        primaryStage.setTitle("Login");
        primaryStage.show();
    
    }
    
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    
    
}
