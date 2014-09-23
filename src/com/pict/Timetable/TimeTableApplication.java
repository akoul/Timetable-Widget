package com.pict.Timetable;

public class TimeTableApplication {
    private static SE SE;

    private static TimeTableApplication TIME_TABLE_APPLICATION = new TimeTableApplication();

    private TimeTableApplication() {
    }

    public static TimeTableApplication getInstance() {
        return TIME_TABLE_APPLICATION;
    }

    public static SE getSeInstanse() {
        return SE;
    }

    public void setSE1instanse(SE1 se1) {
        SE = se1;
    }

    public void setSE2instanse(SE2 se2) {
        SE = se2;
    }

    public void setSE3instanse(SE3 se3) {
        SE = se3;
    }

    public void setSE4instanse(SE4 se4) {
        SE = se4;
    }
}
