package com.eduardo.app.controller;

import com.eduardo.app.util.SceneBehaivorUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class BarTimeSceneController implements Initializable {

    @FXML
    public HBox rootBarTime;
    @FXML
    public Text textTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SceneBehaivorUtil.behaviorMove(rootBarTime);
    }
}