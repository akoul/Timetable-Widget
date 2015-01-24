
package com.pict.timetable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import android.util.Log;

public abstract class SE {

    private Calendar CURRENT_CALENDAR = Calendar.getInstance();
    public static Map<String, String> TIME_TABLE;
    public static int LECTURE_INTERVAL = 0;
    public static String[] LECTURE_TIMINGS = new String[9];

    public static final String[] DAYS = { "MON", "TUE", "WED", "THU", "FRI", "SAT" };

    public static final String COLON = ":";
    public static final String SEMI_COLON = ";";

    /**
     * Returns the name of previous lec
     */
    public String getPrevLecture() {
        LECTURE_INTERVAL = LECTURE_INTERVAL - 1;
        String lecture = null;
        try {
            lecture = TIME_TABLE.get(getDayName().toUpperCase() + SEMI_COLON + LECTURE_TIMINGS[LECTURE_INTERVAL]);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (LECTURE_INTERVAL < 0) {
                LECTURE_INTERVAL = 0;
            } else {
                LECTURE_INTERVAL = LECTURE_TIMINGS.length - 1;
            }
            lecture = TIME_TABLE.get(getDayName().toUpperCase() + SEMI_COLON + LECTURE_TIMINGS[LECTURE_INTERVAL]);
        }
        return lecture;
    }

    /**
     * Returns the name of next lec
     */
    public String getNextLecture() {
        LECTURE_INTERVAL = LECTURE_INTERVAL + 1;
        String lecture = null;
        try {
            lecture = TIME_TABLE.get(getDayName().toUpperCase() + SEMI_COLON + LECTURE_TIMINGS[LECTURE_INTERVAL]);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (LECTURE_INTERVAL < 0) {
                LECTURE_INTERVAL = 0;
            } else {
                LECTURE_INTERVAL = LECTURE_TIMINGS.length - 1;
            }
            lecture = TIME_TABLE.get(getDayName().toUpperCase() + SEMI_COLON + LECTURE_TIMINGS[LECTURE_INTERVAL]);
        }
        return lecture;
    }

    /**
     * Returns the name of current lec
     */
    public String getCurrentLecture() {
        CURRENT_CALENDAR = Calendar.getInstance();
        Date date = CURRENT_CALENDAR.getTime();
        return TIME_TABLE.get(getDayName().toUpperCase() + SEMI_COLON + getTimeInterval(date));

    }

    /**
     * Returns the time to be used to get the lecture name
     */
    public String getTimeInterval(Date date) {
        String returnValue = "";
        Date currentTime = new Date();
        for (int i = 0; i < LECTURE_TIMINGS.length; i++) {
            String timeInterval = LECTURE_TIMINGS[i];
            String[] intervals = timeInterval.split("-");
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date lecStartTime = new Date();
            Date lecEndTime = new Date();
            try {
                lecStartTime = sdf.parse(intervals[0]);
                lecEndTime = sdf.parse(intervals[1]);
                currentTime = sdf.parse(date.getHours() + COLON + date.getMinutes());
            } catch (ParseException e) {
                Log.e("EXCEPTION Class SE", e.getMessage());
                e.printStackTrace();
            }
            if (lecStartTime.compareTo(currentTime) == -1 && lecEndTime.compareTo(currentTime) == 1 || lecStartTime.compareTo(currentTime) == 0
                    || lecEndTime.compareTo(currentTime) == 0) {
                LECTURE_INTERVAL = i;
                returnValue = LECTURE_TIMINGS[i];
            }
        }
        if (returnValue == "") {
            String timeInterval1 = LECTURE_TIMINGS[0];
            String timeInterval2 = LECTURE_TIMINGS[LECTURE_TIMINGS.length - 1];
            String[] intervals1 = timeInterval1.split("-");
            String[] intervals2 = timeInterval2.split("-");
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date firstLecTime = new Date();
            Date lastLecTime = new Date();
            try {
                firstLecTime = sdf.parse(intervals1[0]);
                lastLecTime = sdf.parse(intervals2[1]);
                currentTime = sdf.parse(date.getHours() + COLON + date.getMinutes());
            } catch (ParseException e) {
                Log.e("EXCEPTION Class SE", e.getMessage());
                e.printStackTrace();
            }
            if (currentTime.compareTo(firstLecTime) == -1) {
                LECTURE_INTERVAL = 0;
                returnValue = LECTURE_TIMINGS[LECTURE_INTERVAL];
            } else if (currentTime.compareTo(lastLecTime) == 1) {
                LECTURE_INTERVAL = LECTURE_TIMINGS.length - 1;
                returnValue = LECTURE_TIMINGS[LECTURE_INTERVAL];
            }
        }
        return returnValue;
    }

    /**
     * Returns the time of next lec or prev lec
     */
    public String getNextOrPrevLectureTimeInterval() {
        return LECTURE_TIMINGS[LECTURE_INTERVAL];
    }

    /**
     * Returns the name of the current day i.e. Monday, Tuesday etc
     */
    public String getDayName() {
        Date date = CURRENT_CALENDAR.getTime();
        DateFormat format2 = new SimpleDateFormat("EEE");
        return format2.format(date);
    }

    public abstract void initialise();

    public abstract void addLecturesTimings();

    /**
     * Returns the time interval after which the widget will be updated
     */
    public long getTimeForNextLectChange() {
        String lec;
        try {
            lec = LECTURE_TIMINGS[LECTURE_INTERVAL + 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            lec = LECTURE_TIMINGS[LECTURE_INTERVAL];
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date currentTime = new Date();
        Date futureTime = new Date();
        try {
            futureTime = sdf.parse(lec);
            currentTime = sdf.parse(currentTime.getHours() + COLON + currentTime.getMinutes());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (futureTime.compareTo(currentTime) == -1) {
            try {
                futureTime = sdf.parse("24:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return futureTime.getTime() - currentTime.getTime();
    }
}
