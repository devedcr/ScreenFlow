package com.eduardo.app.library;

import lombok.Getter;
import lombok.Setter;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class PlayTime {

    public enum SHOW_TIME {
        SHOW_ALL,
        SHOW_TO_HOUR,
        SHOW_TO_MINUTES
    }

    @Getter
    @Setter
    private String separator = ":";
    @Getter
    @Setter
    private int day;
    @Getter
    @Setter
    private int hour;
    @Getter
    @Setter
    private int minute;
    @Getter
    @Setter
    private int second;
    @Getter
    @Setter
    private SHOW_TIME showTime;
    private Timer timer;
    private StringBuilder time;

    public PlayTime() {
        this.day = this.hour = this.minute = this.second = 0;
        this.timer = new Timer();
        this.time = new StringBuilder(day + separator + hour + separator + minute + separator + second);
        this.showTime = SHOW_TIME.SHOW_ALL;
    }

    public void start(Consumer<StringBuilder> consumer) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateTime();
                consumer.accept(showTime());
            }
        }, 0, 1000);
    }

    private void updateTime() {
        this.second++;
        if (this.second < 60) return;
        if (this.second == 60) {
            this.second = 0;
            this.minute++;
        }

        if (this.minute < 60) return;
        if (this.minute == 60) {
            this.minute = 0;
            this.hour++;
        }

        if (this.hour < 24) return;
        if (this.hour == 24) {
            this.hour = 0;
            this.day++;
        }
    }

    public void stop() {
        this.timer.cancel();
    }

    public StringBuilder showTime() {
        if (showTime.equals(SHOW_TIME.SHOW_ALL)) {
            time.replace(0, time.length(), formatValue(day) + separator +
                    formatValue(hour) + separator +
                    formatValue(minute) + separator +
                    formatValue(second)
            );
            return time;
        }
        if (showTime.equals(SHOW_TIME.SHOW_TO_HOUR)) {
            time.replace(0, time.length(), formatValue(hour) + separator +
                    formatValue(minute) + separator +
                    formatValue(second)
            );
            return time;
        }
        time.replace(0, time.length(), formatValue(minute) + separator +
                formatValue(second)
        );
        return time;
    }

    private String formatValue(int value) {
        if (value < 10)
            return "0" + value;
        return "" + value;
    }

}