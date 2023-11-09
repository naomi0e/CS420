package com.example.group_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
//code for functionality goes here
//scenebuilder goes in hello-view.fxml
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}