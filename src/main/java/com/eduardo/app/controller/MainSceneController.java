package com.eduardo.app.controller;

import com.eduardo.app.util.SceneBehaivor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    public Pane rootMainScene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SceneBehaivor.behaviorMove(rootMainScene);
    }

}
