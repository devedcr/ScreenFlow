package com.eduardo.app.controller;

import com.eduardo.app.library.PlayTime;
import com.eduardo.app.provider.AppProvider;
import com.eduardo.app.recorder.Recorder;
import com.eduardo.app.recorder.RecorderCV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;


public class ButtonRecordController {
    @FXML
    public Button btnRecord;
    @FXML
    public Text textTime;
    private boolean isRecording;
    private ImageView iconStop;
    private Recorder recorder;
    private Stage stageBarTime;
    private PlayTime playTime;

    public ButtonRecordController() {
        recorder = new RecorderCV();
        stageBarTime = AppProvider.providerStageBarTime();
        playTime = new PlayTime();
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

    private void stopRecording() {
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
}
