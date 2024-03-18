package com.eduardo.app.controller;

import com.eduardo.app.recorder.Recorder;
import com.eduardo.app.recorder.RecorderCV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.Objects;


public class ButtonRecordController {
    @FXML
    public Button btnRecord;
    private boolean isRecording;
    private ImageView iconStop;
    private Recorder recorder;

    public ButtonRecordController() {
        recorder = new RecorderCV();
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
        recorder.start();
        isRecording = true;
    }

    private void stopRecording() {
        setBtnIconRec();
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

}
