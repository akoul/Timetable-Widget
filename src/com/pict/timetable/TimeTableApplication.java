package com.pict.timetable;

public class TimeTableApplication {
    private static SE mSe;

    private static TimeTableApplication TIME_TABLE_APPLICATION = new TimeTableApplication();

    private TimeTableApplication() {
    }

    public static TimeTableApplication getInstance() {
        return TIME_TABLE_APPLICATION;
    }

    public static SE getSeInstanse() {
        return mSe;
    }
    
    public void setSEinstanse(SE se) {
      mSe = se;
  }
}
