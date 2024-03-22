package com.eduardo.app.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class TabScreenComponentController implements Initializable, Closable {
    @FXML
    public Pane rootTabScreenComponent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootTabScreenComponent.getProperties().put("controller", this);
    }

    @Override
    public void close() {
    }
}
