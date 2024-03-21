package com.eduardo.app.controller;

import com.eduardo.app.util.SceneBehaivorUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class BarTimeSceneController implements Initializable {

    @FXML
    public HBox rootBarTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SceneBehaivorUtil.behaviorMove(rootBarTime);
    }
}