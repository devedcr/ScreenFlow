package com.eduardo.app.setting;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SettingScreen {
    public static List<Setting<String>> optionFormat = Arrays.asList(
            new Setting<String>("mp4", "mp4"),
            new Setting<String>("mov", "mov"),
            new Setting<String>("flv", "flv")
    );
    public static Setting<String> format = optionFormat.get(0);

    public static List<Setting<Integer>> optionFps = Arrays.asList(
            new Setting<Integer>("30 fps", 30),
            new Setting<Integer>("60 fps", 60)
    );
    public static Setting<Integer> fps = optionFps.get(0);


    public static List<Setting<Rectangle>> optionDimension = Arrays.asList(
            new Setting<Rectangle>("full screen", new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())),
            new Setting<Rectangle>("define size", null)
    );
    public static Setting<Rectangle> dimension = optionDimension.get(0);

    public static List<Setting<Dimension>> optionResolution = Arrays.asList(
            new Setting<Dimension>("640x480", new Dimension(640, 480)),
            new Setting<Dimension>("1280x720", new Dimension(1280, 720)),
            new Setting<Dimension>("1920x1080", new Dimension(1920, 1080)),
            new Setting<Dimension>("2560x1440", new Dimension(2560, 1440))
    );
    public static Setting<Dimension> resolution = optionResolution.get(1);

    public static double quality = 0;
    public static int bitRate = 800000;
}
