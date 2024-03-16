package com.eduardo.app.util;

import com.eduardo.app.setting.SettingScreen;

public class TimeUtil {
    public static double getDeltaTime() {
        return 1e9 / SettingScreen.fps;
    }
}
