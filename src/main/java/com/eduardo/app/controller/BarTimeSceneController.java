package com.eduardo.app.controller;

import com.eduardo.app.util.SceneBehaivorUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class BarTimeSceneController implements Initializable {

    @FXML
    public HBox rootBarTime;
    @FXML
    public Text textTime;

    @Setter
    private ButtonRecordComponentController buttonRecordComponentController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootBarTime.getProperties().put("controller", this);
        SceneBehaivorUtil.behaviorMove(rootBarTime);
    }

    public void onActionPause(ActionEvent actionEvent) {
    }

    public void onActionStop(ActionEvent actionEvent) {
        buttonRecordComponentController.stopRecording();
    }

    public void onActionMin(ActionEvent actionEvent) {
        Stage stageBarTime = (Stage) rootBarTime.getScene().getWindow();
        stageBarTime.setIconified(true);
    }
}