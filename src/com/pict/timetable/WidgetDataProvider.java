
package com.pict.timetable;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RemoteViews;
import android.widget.TextView;

public class WidgetDataProvider extends Activity implements OnClickListener {
    public static RemoteViews mRemoteView;
    private RadioButton rb1, rb2, rb3, rb4;
    private AppWidgetManager mAppWidgetManager;
    private Context mContext;
    private int mAppWidgetId;
    private TimeTableApplication mTimeTableApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widgetconfig);
        Button b = (Button)findViewById(R.id.bt_select);
        TextView tv_sel = (TextView)findViewById(R.id.tv_sel);
        b.setOnClickListener(this);
        rb1 = (RadioButton)findViewById(R.id.radio0);
        rb2 = (RadioButton)findViewById(R.id.radio1);
        rb3 = (RadioButton)findViewById(R.id.radio2);
        rb4 = (RadioButton)findViewById(R.id.radio3);
        mContext = WidgetDataProvider.this;

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/trench.otf");
        tv_sel.setTypeface(tf);

        Typeface tf1 = Typeface.createFromAsset(getAssets(), "fonts/Kirvy-Bold.otf");
        rb1.setTypeface(tf1);
        rb2.setTypeface(tf1);
        rb3.setTypeface(tf1);
        rb4.setTypeface(tf1);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        } else {
            finish();
        }
        mAppWidgetManager = AppWidgetManager.getInstance(mContext);

    }

    @Override
    public void onClick(View arg0) {
        mRemoteView = new RemoteViews(mContext.getPackageName(), R.layout.activity_main);
        mTimeTableApplication = TimeTableApplication.getInstance();
        if (rb1.isChecked()) {
            mTimeTableApplication.setSEinstanse(new SE1());
        }
        if (rb2.isChecked()) {
            mTimeTableApplication.setSEinstanse(new SE2());
        }
        if (rb3.isChecked()) {
            mTimeTableApplication.setSEinstanse(new SE3());
        }
        if (rb4.isChecked()) {
            mTimeTableApplication.setSEinstanse(new SE4());
        }
        TimeTableApplication.getSeInstanse().addLecturesTimings();
        TimeTableApplication.getSeInstanse().initialise();

        mRemoteView.setTextViewText(R.id.textView1, TimeTableApplication.getSeInstanse().getDayName());
        mRemoteView.setTextViewText(R.id.textView2, TimeTableApplication.getSeInstanse().getCurrentLecture());
        Date date = Calendar.getInstance().getTime();
        mRemoteView.setTextViewText(R.id.textView3, TimeTableApplication.getSeInstanse().getTimeInterval(date));

        Intent in = new Intent(mContext, TimeTableWidget.class);
        PendingIntent pi = PendingIntent.getActivity(mContext, 0, in, 0);
        mRemoteView.setOnClickPendingIntent(R.id.bt_select, pi);

        setNextAndPrevButtonClickListeners();

        mAppWidgetManager.updateAppWidget(mAppWidgetId, mRemoteView);
        Intent result = new Intent();
        result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        setResult(RESULT_OK, result);
        finish();
    }

    private void setNextAndPrevButtonClickListeners() {
        Intent in = new Intent(mContext, TimeTableWidget.class);
        in.setAction("Prev");
        in.setData(Uri.parse("tel:/" + (int)System.currentTimeMillis()));
        in.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        PendingIntent mPendingIntent = PendingIntent.getBroadcast(mContext, 0, in, PendingIntent.FLAG_UPDATE_CURRENT);
        mRemoteView.setOnClickPendingIntent(R.id.button_prev, mPendingIntent);

        in = new Intent(mContext, TimeTableWidget.class);
        in.setAction("Next");
        in.setData(Uri.parse("tel:/" + (int)System.currentTimeMillis()));
        in.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        mPendingIntent = PendingIntent.getBroadcast(mContext, 0, in, PendingIntent.FLAG_UPDATE_CURRENT);
        mRemoteView.setOnClickPendingIntent(R.id.button_next, mPendingIntent);
    }

}
