package com.eduardo.app.controller;

import com.eduardo.app.library.PlayTime;
import com.eduardo.app.provider.AppProvider;
import com.eduardo.app.recorder.Recorder;
import com.eduardo.app.recorder.RecorderCV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class ButtonRecordComponentController implements Initializable, Closable {
    @FXML
    public Pane rootButtonRecordComponent;
    @FXML
    public Button btnRecord;
    @FXML
    public Text textTime;
    private boolean isRecording;
    private ImageView iconStop;
    private Recorder recorder;
    private Stage stageBarTime;
    private PlayTime playTime;

    public ButtonRecordComponentController() {
        recorder = new RecorderCV();
        stageBarTime = AppProvider.providerStageBarTime();
        playTime = new PlayTime();
        BarTimeSceneController barTimeSceneController = (BarTimeSceneController) stageBarTime.getScene().getRoot().getProperties().get("controller");
        barTimeSceneController.setButtonRecordComponentController(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootButtonRecordComponent.getProperties().put("controller", this);
    }

    public void onActionBtnRecord(ActionEvent actionEvent) {
        if (isRecording) {
            stopRecording();
            return;
        }
        startRecording();
    }

    private void startRecording() {
        setBtnIconStop();
        openStageSceneBarTime();
        startTimer();
        recorder.start();
        isRecording = true;
    }

    private void startTimer() {
        Text textTimeBar = (Text) stageBarTime.getScene().lookup("#textTime");
        playTime.setShowTime(PlayTime.SHOW_TIME.SHOW_TO_HOUR);
        playTime.start((str) -> {
            textTime.setText(str.toString());
            textTimeBar.setText(str.toString());
        });
    }

    private void stopTimer() {
        playTime.stop();
    }

    public void stopRecording() {
        setBtnIconRec();
        closeStageSceneBarTime();
        stopTimer();
        recorder.stop();
        isRecording = false;
    }

    private void setBtnIconStop() {
        if (Objects.isNull(iconStop)) {
            iconStop = new ImageView(String.valueOf(getClass().getResource("/image/stop.png")));
            iconStop.setFitWidth(40);
            iconStop.setFitHeight(40);
        }
        btnRecord.setGraphic(iconStop);
        btnRecord.setText(null);
    }

    private void setBtnIconRec() {
        btnRecord.setGraphic(null);
        btnRecord.setText("REC");
    }

    private void openStageSceneBarTime() {
        stageBarTime.show();
    }

    private void closeStageSceneBarTime() {
        stageBarTime.close();
    }

    @Override
    public void close() {
        if (isRecording) stopRecording();
    }
}
