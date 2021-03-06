/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vkmanager.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import vkmanager.model.User;

/**
 * FXML Controller class
 *
 * @author i-mad_000
 */
public class RootVKController implements Initializable{
    private BorderPane rootPane;
    @FXML
    private MenuItem photoItem;
    @FXML
    private BorderPane mainPane;    
    @FXML 
    private Label userFirstname;    
    @FXML 
    private Label userLastname;
    @FXML
    private Button userPhoto;

    public void initRootPane(BorderPane mainPane){
    }
   
    public void onPhotosSelect(ActionEvent event){
        try {
            Parent photosPane = FXMLLoader.load(getClass().getResource("/vkmanager/view/photos/Photos.fxml"));
            mainPane.setCenter(photosPane);
        } catch (IOException ex) {
            Logger.getLogger(RootVKController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onMusicSelect(ActionEvent event){
        try {
            Parent musicPane = FXMLLoader.load(getClass().getResource("/vkmanager/view/music/AudioPlayer.fxml"));
            mainPane.setCenter(musicPane);
            musicPane.autosize();
        } catch (IOException ex) {
            Logger.getLogger(RootVKController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = User.getCurrentUser();
        Image userPhotoLink = new Image(user.getPhoto());
        System.out.println(userPhotoLink);
        ImageView userPhotoImg = new ImageView(userPhotoLink);
        userPhoto.setGraphic(userPhotoImg);
        
        userFirstname.setText(user.getName());
        userLastname.setText(user.getLastname());
    }    

    
}
