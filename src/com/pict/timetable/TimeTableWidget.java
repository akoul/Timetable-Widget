
package com.pict.timetable;

import java.util.Timer;
import java.util.TimerTask;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

public class TimeTableWidget extends AppWidgetProvider {

    private static int mAppWidgetId;
    private static Context mContext;
    private static RemoteViews mRemoteView;
    private static SE mSe;
    static private Timer mTimer = new Timer();
    static private Timer mPeriodicTimer = new Timer();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int i = 0; i < appWidgetIds.length; i++) {
            int awID = appWidgetIds[i];
            mAppWidgetId = awID;
            mContext = context;
            mRemoteView = new RemoteViews(context.getPackageName(), R.layout.activity_main);
            appWidgetManager.updateAppWidget(awID, mRemoteView);
            addAlarmManager();
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        mSe = TimeTableApplication.getSeInstanse();
        if (mSe != null) {
            if (action.equals("Prev")) {
                mRemoteView.setTextViewText(R.id.textView2, mSe.getPrevLecture());
                mRemoteView.setTextViewText(R.id.textView3, TimeTableApplication.getSeInstanse().getNextOrPrevLectureTimeInterval());
                AppWidgetManager.getInstance(mContext).updateAppWidget(mAppWidgetId, mRemoteView);
                resetWidgetToCurrentLecAfterTenSeconds();
            } else if (action.equals("Next")) {
                mRemoteView.setTextViewText(R.id.textView2, mSe.getNextLecture());
                mRemoteView.setTextViewText(R.id.textView3, TimeTableApplication.getSeInstanse().getNextOrPrevLectureTimeInterval());
                AppWidgetManager.getInstance(mContext).updateAppWidget(mAppWidgetId, mRemoteView);
                resetWidgetToCurrentLecAfterTenSeconds();
            }
        }
        super.onReceive(context, intent);
    }

    private void resetWidgetToCurrentLecAfterTenSeconds() {
        if (mTimer != null) {
            mTimer.cancel();
        }
        mTimer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                String lecture = TimeTableApplication.getSeInstanse().getCurrentLecture();
                mRemoteView.setTextViewText(R.id.textView1, TimeTableApplication.getSeInstanse().getDayName());
                mRemoteView.setTextViewText(R.id.textView2, lecture);
                mRemoteView.setTextViewText(R.id.textView3, TimeTableApplication.getSeInstanse().getNextOrPrevLectureTimeInterval());
                AppWidgetManager.getInstance(mContext).updateAppWidget(mAppWidgetId, mRemoteView);
            }
        };
        mTimer.schedule(task, 10000);
    }

    private void addAlarmManager() {

        mPeriodicTimer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                String lecture = TimeTableApplication.getSeInstanse().getCurrentLecture();
                mRemoteView.setTextViewText(R.id.textView1, TimeTableApplication.getSeInstanse().getDayName());
                mRemoteView.setTextViewText(R.id.textView2, lecture);
                mRemoteView.setTextViewText(R.id.textView3, TimeTableApplication.getSeInstanse().getNextOrPrevLectureTimeInterval());
                AppWidgetManager.getInstance(mContext).updateAppWidget(mAppWidgetId, mRemoteView);
                long interval = 0;
                if (mSe != null && interval != 0) {
                    interval = mSe.getTimeForNextLectChange();
                }
                if (interval == 0) {
                    interval = 20000;
                }
                addAlarmManager();
            }
        };
        long interval = 20000;
        if (mSe != null && interval != 0) {
            interval = mSe.getTimeForNextLectChange();
        }
        if (interval == 0) {
            interval = 20000;
        }
        mPeriodicTimer.schedule(task, interval);
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
