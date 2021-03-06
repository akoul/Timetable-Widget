package com.pict.timetable;

import java.util.HashMap;

public class SE2 extends SE {
	
	public void addLecturesTimings(){
		LECTURE_TIMINGS[0]="8:30-9:30";
		LECTURE_TIMINGS[1]="9:30-10:30";
		LECTURE_TIMINGS[2]="10:30-10:45";
		LECTURE_TIMINGS[3]="10:45-11:45";
		LECTURE_TIMINGS[4]="11:45-12:45";
		LECTURE_TIMINGS[5]="12:45-13:30";
		LECTURE_TIMINGS[6]="13:30-14:30";
		LECTURE_TIMINGS[7]="14:30-15:30";
		LECTURE_TIMINGS[8]="15:30-16:30";
	}

    public void initialise() {
        TIME_TABLE = new HashMap<String, String>();
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[0], "DS(E1)\nDS(E2)\nDS(E3)\nDS(E4)");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[1], "DS1");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[3], "DS3");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[4], "DS4");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[6], "DS6");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[7], "DS7");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[8], "DS8");

        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[0], "DS");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[1], "DS1");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[3], "DS3");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[4], "DS4");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[6], "DS6");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[7], "DS7");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[8], "DS8");

        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[0], "No Lecture");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[1], "OSD");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[3], "PL-1(K2)\nPL-1(L2)\nPL-2(M2)\nPL-2(N2)");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[4], "PL-1(K2)\nPL-1(L2)\nPL-2(M2)\nPL-2(N2)");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[6], "DCWSN");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[7], "CFCA");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[8], "DMSA*");

        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[0], "DS");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[1], "DS1");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[3], "DS3");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[4], "DS4");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[6], "DS6");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[7], "DS7");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[8], "DS8");

        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[0], "DS");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[1], "DS1");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[3], "DS3");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[4], "DS4");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[6], "DS6");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[7], "DS7");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[8], "DS8");

        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[0], "DS");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[1], "DS1");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[3], "DS3");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[4], "DS4");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[6], "DS6");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[7], "DS7");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[8], "DS8");

    }

}
