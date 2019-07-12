/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import lk.edu.ijse.sas.main.Main;
import lk.edu.ijse.sas.other.JRViewerFX;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class DashBoardController implements Initializable {
    
    @FXML
    private JFXDrawer drawer;
    
    @FXML
    AnchorPane sidePane;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    public AnchorPane root;
    
    @FXML
    AnchorPane containPane;
    
    public static AnchorPane rootPane;
    public static AnchorPane sideP;
    public static AnchorPane backPane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        if(!Main.isSplashLoad){
            
            loadSplashScreen();
            JRViewerFX view=new JRViewerFX();
        }
        rootPane=containPane; 
        sideP=sidePane;
        
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        //HamburgerNextArrowBasicTransition transition= new HamburgerNextArrowBasicTransition(hamburger);
        try {
            AnchorPane Box = FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MainSidePane.fxml"));
            drawer.setSidePane(Box);
            drawer.open();
           

        } catch (IOException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        transition.setRate(-0.7);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isShown()) {
                drawer.close();
                
            } else {
                try {
                    AnchorPane Box = FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MainSidePane.fxml"));
                    drawer.setSidePane(Box);
                    drawer.open();
                    
                     
                } catch (IOException ex) {
                    Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SelectionPage.fxml"));
            rootPane.getChildren().setAll(box);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void loadSplashScreen() {
        
        try {
            Main.isSplashLoad = true;
            
            StackPane pane = FXMLLoader.load(getClass().getResource(("/com/sas/kem/edu/ijse/view/SplashScreen.fxml")));
            root.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);

            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/com/sas/kem/edu/ijse/view/DashBoard.fxml")));
                    root.getChildren().setAll(parentContent);

                } catch (IOException ex) {
                    // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (IOException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
