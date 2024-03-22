package com.eduardo.app.controller;

import com.eduardo.app.util.SceneBehaivorUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable, Closable {
    @FXML
    public Pane rootMainScene;
    @FXML
    public Pane rootTabScreenComponent;
    @FXML
    public Pane rootButtonRecordComponent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootMainScene.getProperties().put("controller", this);
        SceneBehaivorUtil.behaviorMove(rootMainScene);
    }

    @Override
    public void close() {
        Closable tabScreenController = (Closable) rootTabScreenComponent.getProperties().get("controller");
        Closable buttonRecordController = (Closable) rootButtonRecordComponent.getProperties().get("controller");
        tabScreenController.close();
        buttonRecordController.close();
    }
}
