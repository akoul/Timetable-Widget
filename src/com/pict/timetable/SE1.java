package com.pict.timetable;

import java.util.HashMap;

public class SE1 extends SE {
	
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
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[0], "PL-3(K1,L1)\nSTL(M1,N1)");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[1], "PL-3(K1,L1)\nSTL(M1,N1)");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[3], "EOS");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[4], "CN");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[6], "PCPDP");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[7], "DSP");
        TIME_TABLE.put(DAYS[0] + SEMI_COLON + LECTURE_TIMINGS[8], "PL-3(PRL)*");

        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[0], "PL-3(M1,N1)\nPL-4(K1,L1)");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[1], "PL-3(M1,N1)\nPL-4(K1,L1)");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[3], "EOS");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[4], "PL-4(PRL)");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[6], "SE");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[7], "CN");
        TIME_TABLE.put(DAYS[1] + SEMI_COLON + LECTURE_TIMINGS[8], "PCPDP*");

        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[0], "CN");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[1], "PCPDP");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[3], "PL-4(M1,N1)\nSTL(K1,L1)");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[4], "PL-4(M1,N1)\nSTL(K1,L1)");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[6], "SE");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[7], "EOS*");
        TIME_TABLE.put(DAYS[2] + SEMI_COLON + LECTURE_TIMINGS[8], "NO Lecture");

        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[0], "No Lecture");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[1], "SE");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[3], "PCPDP");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[4], "DSP");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[6], "PL-3(M1,N1)\nPL-4(K1,L1)");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[7], "PL-3(M1,N1)\nPL-4(K1,L1)");
        TIME_TABLE.put(DAYS[3] + SEMI_COLON + LECTURE_TIMINGS[8], "DS8");

        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[0], "No Lecture");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[1], "EOS");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[3], "CN");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[4], "DSP");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[6], "PL-3(K1,L1)\nPL-4(M1,N1)");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[7], "PL-3(K1,L1)\nPL-4(M1,N1)");
        TIME_TABLE.put(DAYS[4] + SEMI_COLON + LECTURE_TIMINGS[8], "DS8");

        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[0], "No Lecture");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[1], "PCDP");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[2], "Short Break");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[3], "EOS");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[4], "PL-3(PRL)");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[5], "Lunch Break");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[6], "No Lecture");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[7], "No Lecture");
        TIME_TABLE.put(DAYS[5] + SEMI_COLON + LECTURE_TIMINGS[8], "No Lecture");

    }

}
