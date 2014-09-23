package com.pict.Timetable;

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
	public static String NO_LECTURE = "No Lecture";
	public static int LECTURE_INTERVAL = 0;
	public static String[] LECTURE_TIMINGS = new String[9];
	private static Boolean IS_NO_LECTURE = false;

	public static final String[] DAYS = { "MON", "TUE", "WED", "THU", "FRI",
			"SAT" };

	public static final String COLON = ":";
	public static final String SEMI_COLON = ";";

	public String getPrevLecture() {
		LECTURE_INTERVAL = LECTURE_INTERVAL - 1;
		String lecture = null;
		try {
			lecture = TIME_TABLE.get(getDayName().toUpperCase() + SEMI_COLON
					+ LECTURE_TIMINGS[LECTURE_INTERVAL]);
		} catch (ArrayIndexOutOfBoundsException e) {
			LECTURE_INTERVAL = LECTURE_INTERVAL + 1;
			lecture = TIME_TABLE.get(getDayName().toUpperCase() + SEMI_COLON
					+ LECTURE_TIMINGS[LECTURE_INTERVAL]);
		}
		if (lecture != null) {
			IS_NO_LECTURE = false;
			return lecture;
		} else {
			IS_NO_LECTURE = true;
			return NO_LECTURE;
		}
	}

	public String getNextLecture() {
		LECTURE_INTERVAL = LECTURE_INTERVAL + 1;
		String lecture = null;
		try {
			lecture = TIME_TABLE.get(getDayName().toUpperCase() + SEMI_COLON
					+ LECTURE_TIMINGS[LECTURE_INTERVAL]);
		} catch (ArrayIndexOutOfBoundsException e) {
			LECTURE_INTERVAL = LECTURE_INTERVAL - 1;
			lecture = TIME_TABLE.get(getDayName().toUpperCase() + SEMI_COLON
					+ LECTURE_TIMINGS[LECTURE_INTERVAL]);
		}
		if (lecture != null) {
			IS_NO_LECTURE = false;
			return lecture;
		} else {
			IS_NO_LECTURE = true;
			return NO_LECTURE;
		}
	}

	public String getCurrentLecture() {
		CURRENT_CALENDAR = Calendar.getInstance();
		Date date = CURRENT_CALENDAR.getTime();
		String lecture = TIME_TABLE.get(getDayName().toUpperCase() + SEMI_COLON
				+ getTimeInterval(date));
		if (lecture != null) {
			IS_NO_LECTURE = false;
			return lecture;
		} else {
			IS_NO_LECTURE = true;
			return NO_LECTURE;
		}
	}

	public String getTimeInterval(Date date) {
		String returnValue = "";
		for (int i = 0; i < LECTURE_TIMINGS.length; i++) {
			String timeInterval = LECTURE_TIMINGS[i];
			String[] intervals = timeInterval.split("-");
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			Date startTime = new Date();
			Date endTime = new Date();
			Date currentTime = new Date();
			try {
				startTime = sdf.parse(intervals[0]);
				endTime = sdf.parse(intervals[1]);
				currentTime = sdf.parse(date.getHours() + COLON
						+ date.getMinutes());
			} catch (ParseException e) {
				Log.e("EXCEPTION Class SE", e.getMessage());
				e.printStackTrace();
			}
			if (startTime.compareTo(currentTime) == -1
					&& endTime.compareTo(currentTime) == 1
					|| startTime.compareTo(currentTime) == 0
					|| endTime.compareTo(currentTime) == 0) {
				LECTURE_INTERVAL = i;
				returnValue = LECTURE_TIMINGS[i];
			}
		}
		return IS_NO_LECTURE ? "" : returnValue;
	}

	public String getNextAndPrevLectureTimeInterval() {
		return IS_NO_LECTURE ? "" : LECTURE_TIMINGS[LECTURE_INTERVAL];
	}

	public String getDayName() {
		Date date = CURRENT_CALENDAR.getTime();
		DateFormat format2 = new SimpleDateFormat("EEE");
		return format2.format(date);
	}

	public abstract void initialise();

	public abstract void addLecturesTimings();

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
			currentTime = sdf.parse(currentTime.getHours() + COLON
					+ currentTime.getMinutes());
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
