package com.pict.Timetable;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.pict.TimeTable.R;

public class TimeTableWidget extends AppWidgetProvider {

	private static int APP_WIDGET_ID;
	private static Context CONTEXT;

	private static RemoteViews REMOTE_VIEW;
	private static SE mSe;
	private static String PREV_LEC;
	private static int COUNT = 0;
	private static long PREV_INTERVAL = -1;
	static Timer timer = new Timer();

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		for (int i = 0; i < appWidgetIds.length; i++) {
			int awID = appWidgetIds[i];
			APP_WIDGET_ID = awID;
			CONTEXT = context;
			REMOTE_VIEW = new RemoteViews(context.getPackageName(),
					R.layout.activity_main);
			appWidgetManager.updateAppWidget(awID, REMOTE_VIEW);
			addAlarmManager();
		}
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		final String action = intent.getAction();
		mSe = TimeTableApplication.getSeInstanse();
		if (mSe != null) {
			if (action.equals("Prev")) {
				REMOTE_VIEW.setTextViewText(R.id.textView2,
						mSe.getPrevLecture());
				REMOTE_VIEW.setTextViewText(R.id.textView3,
						TimeTableApplication.getSeInstanse()
								.getNextAndPrevLectureTimeInterval());
				AppWidgetManager.getInstance(CONTEXT).updateAppWidget(
						APP_WIDGET_ID, REMOTE_VIEW);
				resetAfterTenSeconds();
				// Toast.makeText(context, "Prev clicked..",
				// Toast.LENGTH_SHORT).show();
			} else if (action.equals("Next")) {
				REMOTE_VIEW.setTextViewText(R.id.textView2,
						mSe.getNextLecture());
				REMOTE_VIEW.setTextViewText(R.id.textView3,
						TimeTableApplication.getSeInstanse()
								.getNextAndPrevLectureTimeInterval());
				AppWidgetManager.getInstance(CONTEXT).updateAppWidget(
						APP_WIDGET_ID, REMOTE_VIEW);
				resetAfterTenSeconds();
				// Toast.makeText(context, "Next clicked..",
				// Toast.LENGTH_SHORT).show();
			} else if (action.equals("Update")) {
				String lecture = TimeTableApplication.getSeInstanse()
						.getCurrentLecture();
				if (COUNT == 0) {
					PREV_LEC = lecture;
				}
				REMOTE_VIEW.setTextViewText(R.id.textView1,
						TimeTableApplication.getSeInstanse().getDayName());
				REMOTE_VIEW.setTextViewText(R.id.textView2, lecture);
				Date date = Calendar.getInstance().getTime();
				REMOTE_VIEW.setTextViewText(R.id.textView3,
						TimeTableApplication.getSeInstanse()
								.getNextAndPrevLectureTimeInterval());
				AppWidgetManager.getInstance(CONTEXT).updateAppWidget(
						APP_WIDGET_ID, REMOTE_VIEW);
				//Toast.makeText(context, "Widget Updated..", Toast.LENGTH_SHORT).show();
				if (((PREV_LEC.equals(SE.NO_LECTURE) && lecture
						.equals(SE.NO_LECTURE))) && !PREV_LEC.equals(lecture)) {
					PREV_LEC = lecture;
					addAlarmManager();
				}
			}
		}
		super.onReceive(context, intent);
	}

	private void resetAfterTenSeconds() {
		if (timer != null) {
			timer.cancel();
		}
		timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				String lecture = TimeTableApplication.getSeInstanse()
						.getCurrentLecture();
				REMOTE_VIEW.setTextViewText(R.id.textView1,
						TimeTableApplication.getSeInstanse().getDayName());
				REMOTE_VIEW.setTextViewText(R.id.textView2, lecture);
				Date date = Calendar.getInstance().getTime();
				REMOTE_VIEW.setTextViewText(R.id.textView3,
						TimeTableApplication.getSeInstanse()
								.getNextAndPrevLectureTimeInterval());
				AppWidgetManager.getInstance(CONTEXT).updateAppWidget(
						APP_WIDGET_ID, REMOTE_VIEW);

			}
		};

		timer.schedule(task, 10000);
	}

	private void addAlarmManager() {
		Intent headerIntent = new Intent(CONTEXT, TimeTableWidget.class);
		headerIntent.setAction("Update");
		PendingIntent pending = PendingIntent.getBroadcast(CONTEXT, 0,
				headerIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		AlarmManager alarm = (AlarmManager) CONTEXT
				.getSystemService(Context.ALARM_SERVICE);

		long interval = 60000;
		if (mSe != null && interval != 0) {
			interval = mSe.getTimeForNextLectChange();
		}
		if (interval == 0) {
			interval = 60000;
		}
		Log.e("interval:::::::::::::::::", String.valueOf(interval));

		if (PREV_INTERVAL != interval) {
			PREV_INTERVAL = interval;
			alarm.setRepeating(AlarmManager.ELAPSED_REALTIME,
					SystemClock.elapsedRealtime(), interval, pending);
		}

	}

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		super.onDeleted(context, appWidgetIds);
		Toast.makeText(context, "Good Day", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onEnabled(Context context) {
		super.onEnabled(context);
	}
}
