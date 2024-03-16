package com.eduardo.app.util;

import com.eduardo.app.setting.SettingScreen;

public class TimeUtil {
    public static double getDeltaTime(int fps) {
        return 1e9 / fps;
    }
}
