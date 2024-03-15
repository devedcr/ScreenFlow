package com.eduardo.app.controller;

import com.eduardo.app.util.SceneBehaivor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuComponentController implements Initializable {

    @FXML
    public Button btnMin;
    @FXML
    public Button btnClose;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void onBtnMin(ActionEvent actionEvent) {
        ((Stage) btnMin.getScene().getWindow()).setIconified(true);
    }

    public void onBtnClose(ActionEvent actionEvent) {
        ((Stage) btnMin.getScene().getWindow()).close();
    }

}
