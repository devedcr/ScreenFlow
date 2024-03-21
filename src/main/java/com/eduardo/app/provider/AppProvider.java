package com.eduardo.app.provider;

import com.eduardo.app.setting.SettingScreen;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.bytedeco.javacv.FFmpegFrameRecorder;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppProvider {

    public static FFmpegFrameRecorder providerFFmpegFrameRecorder() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String filename = dateFormat.format(new Date()) + "." + SettingScreen.format;
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(filename, SettingScreen.resolutionWidth, SettingScreen.resolutionHeight);
        recorder.setFormat(SettingScreen.format);
        recorder.setFrameRate(SettingScreen.fps);
        recorder.setVideoQuality(SettingScreen.quality);
        recorder.setVideoBitrate(SettingScreen.bitRate);
        return recorder;
    }

    public static Stage providerStageBarTime() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(AppProvider.class.getResource("/view/scene/bartime/BarTimeScene.fxml"));
        Parent root = null;
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        try {
            root = loader.load();
            root.getStylesheets().add("/css/style.css");
            Scene scene = new Scene(root, 350, 40);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setX(screenBounds.getMaxX());
            stage.setY(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stage;
    }

}
