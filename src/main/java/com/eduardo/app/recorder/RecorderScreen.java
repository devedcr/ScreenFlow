package com.eduardo.app.recorder;

import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Java2DFrameUtils;

import java.awt.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RecorderScreen {
    private static final Logger logger = LogManager.getLogger(RecorderScreen.class);
    private FFmpegFrameRecorder recorder;
    private Rectangle dimension;

    public RecorderScreen(FFmpegFrameRecorder recorder, Rectangle dimension) {
        this.recorder = recorder;
        this.dimension = dimension;
    }

    public void capture() {
        try {
            var bufferedImage = new Robot().createScreenCapture(dimension);
            recorder.record(Java2DFrameUtils.toFrame(bufferedImage), avutil.AV_PIX_FMT_0RGB);
        } catch (AWTException | FFmpegFrameRecorder.Exception e) {
            logger.info(e.getCause().getMessage());
        }
    }
}
