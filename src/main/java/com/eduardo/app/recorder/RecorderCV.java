package com.eduardo.app.recorder;

import com.eduardo.app.provider.AppProvider;
import com.eduardo.app.util.TimeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bytedeco.javacv.FFmpegFrameRecorder;

import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RecorderCV implements Recorder {
    private static final Logger logger = LogManager.getLogger(RecorderCV.class);
    private final FFmpegFrameRecorder recorder;
    private final Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    private RecorderScreen recorderScreen;
    private boolean isRecording;
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public RecorderCV() {
        this.recorder = AppProvider.providerFFmpegFrameRecorder();
        this.recorderScreen = new RecorderScreen(recorder, rectangle);
    }

    @Override
    public void start() {
        new Thread(() -> {
            logger.info("Start Recording...");
            startRecorder();
            isRecording = true;
            double deltaTime = TimeUtil.getDeltaTime();
            long currentTime;
            long elapsedTime;
            long lastFrameTime = System.nanoTime();
            while (isRecording) {
                currentTime = System.nanoTime();
                elapsedTime = currentTime - lastFrameTime;
                if (elapsedTime >= deltaTime) {
                    executor.execute(() -> recorderScreen.capture());
                    lastFrameTime = currentTime;
                }
            }
            stopExecutor();
            stopRecorder();
        }).start();
    }

    @Override
    public void stop() {
        logger.info("Stop Recording...");
        isRecording = false;
    }

    private void startRecorder() {
        try {
            recorder.start();
        } catch (FFmpegFrameRecorder.Exception e) {
            logger.info(e.getCause().getMessage());
        }
    }

    private void stopRecorder() {
        try {
            recorder.stop();
        } catch (FFmpegFrameRecorder.Exception e) {
            logger.info(e.getCause().getMessage());
        }
    }

    private void stopExecutor() {
        executor.shutdown();
        while (!executor.isTerminated()) ;
    }

    public static void main(String[] args) {
        Recorder recorder = new RecorderCV();
        recorder.start();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input something command!!!");
            if (scanner.next().equals("stop")) {
                recorder.stop();
                break;
            }
        }
    }
}
