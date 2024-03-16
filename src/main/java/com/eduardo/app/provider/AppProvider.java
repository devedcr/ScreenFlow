package com.eduardo.app.provider;

import com.eduardo.app.setting.SettingScreen;
import org.bytedeco.javacv.FFmpegFrameRecorder;

public class AppProvider {

    public static FFmpegFrameRecorder providerFFmpegFrameRecorder() {
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("output.mp4", 1920, 1080);
        recorder.setFormat(SettingScreen.format);
        recorder.setFrameRate(SettingScreen.fps);
        recorder.setVideoQuality(SettingScreen.quality);
        recorder.setVideoBitrate(SettingScreen.bitRate);
        return recorder;
    }

}
