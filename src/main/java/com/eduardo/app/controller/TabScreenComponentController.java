package com.eduardo.app.controller;

import com.eduardo.app.setting.SettingScreen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class TabScreenComponentController implements Initializable, Closable {
    @FXML
    public Pane rootTabScreenComponent;
    @FXML
    public ComboBox comboResolution;
    @FXML
    public ComboBox comboFormat;
    @FXML
    public ComboBox comboFrame;
    @FXML
    public ComboBox comboScreenSize;
    @FXML
    public TextField textFieldBitRate;
    @FXML
    public Slider sliderBitRate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootTabScreenComponent.getProperties().put("controller", this);
        loadSettingStart();
    }

    public void loadSettingStart() {
        comboFormat.getItems().addAll(SettingScreen.optionFormat);
        comboFormat.setValue(SettingScreen.format);

        comboFrame.getItems().addAll(SettingScreen.optionFps);
        comboFrame.setValue(SettingScreen.fps);

        comboResolution.getItems().addAll(SettingScreen.optionResolution);
        comboResolution.setValue(SettingScreen.resolution);

        comboScreenSize.getItems().addAll(SettingScreen.optionDimension);
        comboScreenSize.setValue(SettingScreen.dimension);
    }

    @Override
    public void close() {
    }
}
