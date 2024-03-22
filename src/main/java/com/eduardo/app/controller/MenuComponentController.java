package com.eduardo.app.controller;

import com.eduardo.app.container.AppContainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuComponentController implements Initializable {

    @FXML
    public Pane rootMenuComponent;
    @FXML
    public Button btnMin;
    @FXML
    public Button btnClose;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        themeRed();
    }

    public void themeRed() {
        rootMenuComponent.getStylesheets().add("/css/menu/menuRed.css");
    }

    public void onBtnMin(ActionEvent actionEvent) {
        ((Stage) btnMin.getScene().getWindow()).setIconified(true);
    }

    public void onBtnClose(ActionEvent actionEvent) {
        Stage mainStage = AppContainer.get("mainStage", Stage.class);
        Closable mainController = (Closable) mainStage.getScene().getRoot().getProperties().get("controller");
        mainController.close();
        mainStage.close();
    }

}
