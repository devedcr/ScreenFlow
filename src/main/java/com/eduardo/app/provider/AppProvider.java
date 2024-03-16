package com.eduardo.app.provider;

import com.eduardo.app.setting.SettingScreen;
import org.bytedeco.javacv.FFmpegFrameRecorder;

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

}
