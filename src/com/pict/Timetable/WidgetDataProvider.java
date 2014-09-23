package com.pict.Timetable;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RemoteViews;

import com.pict.TimeTable.R;

public class WidgetDataProvider extends Activity implements OnClickListener {
	public static RemoteViews REMOTE_VIEW;
	private RadioButton rb1, rb2, rb3, rb4;
	AppWidgetManager mAppWidgetManager;
	Context mContext;
	int mAppWidgetId;
	Button mPrev;
	Button mNext;
	TimeTableApplication mTimeTableApplication;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widgetconfig);
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(this);
		rb1 = (RadioButton) findViewById(R.id.radio0);
		rb2 = (RadioButton) findViewById(R.id.radio1);
		rb3 = (RadioButton) findViewById(R.id.radio2);
		rb4 = (RadioButton) findViewById(R.id.radio3);
		mContext = WidgetDataProvider.this;
		Intent i = getIntent();
		Bundle extras = i.getExtras();
		if (extras != null) {
			mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
					AppWidgetManager.INVALID_APPWIDGET_ID);
		} else {
			finish();
		}
		mAppWidgetManager = AppWidgetManager.getInstance(mContext);
	}

	@Override
	public void onClick(View arg0) {
		REMOTE_VIEW = new RemoteViews(mContext.getPackageName(),
				R.layout.activity_main);
		mTimeTableApplication = TimeTableApplication.getInstance();
		if (rb1.isChecked()) {
			mTimeTableApplication.setSE1instanse(new SE1());
		}
		if (rb2.isChecked()) {
			mTimeTableApplication.setSE2instanse(new SE2());
		}
		if (rb3.isChecked()) {
			mTimeTableApplication.setSE3instanse(new SE3());
		}
		if (rb4.isChecked()) {
			mTimeTableApplication.setSE4instanse(new SE4());
		}
		TimeTableApplication.getSeInstanse().addLecturesTimings();
		TimeTableApplication.getSeInstanse().initialise();

		REMOTE_VIEW.setTextViewText(R.id.textView1, TimeTableApplication
				.getSeInstanse().getDayName());
		REMOTE_VIEW.setTextViewText(R.id.textView2, TimeTableApplication
				.getSeInstanse().getCurrentLecture());
		Date date = Calendar.getInstance().getTime();
		REMOTE_VIEW.setTextViewText(R.id.textView3, TimeTableApplication
				.getSeInstanse().getTimeInterval(date));

		Intent in = new Intent(mContext, TimeTableWidget.class);
		PendingIntent pi = PendingIntent.getActivity(mContext, 0, in, 0);
		REMOTE_VIEW.setOnClickPendingIntent(R.id.button1, pi);

		setNextAndPrevButtonClickListeners();

		mAppWidgetManager.updateAppWidget(mAppWidgetId, REMOTE_VIEW);
		Intent result = new Intent();
		result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
		setResult(RESULT_OK, result);
		finish();
	}

	private void setNextAndPrevButtonClickListeners() {
		Intent in = new Intent(mContext, TimeTableWidget.class);
		in.setAction("Prev");
		in.setData(Uri.parse("tel:/" + (int) System.currentTimeMillis()));
		in.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
		PendingIntent mPendingIntent = PendingIntent.getBroadcast(mContext, 0,
				in, PendingIntent.FLAG_UPDATE_CURRENT);
		REMOTE_VIEW.setOnClickPendingIntent(R.id.button_prev, mPendingIntent);

		in = new Intent(mContext, TimeTableWidget.class);
		in.setAction("Next");
		in.setData(Uri.parse("tel:/" + (int) System.currentTimeMillis()));
		in.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
		mPendingIntent = PendingIntent.getBroadcast(mContext, 0, in,
				PendingIntent.FLAG_UPDATE_CURRENT);
		REMOTE_VIEW.setOnClickPendingIntent(R.id.button_next, mPendingIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.help, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {

		case R.id.abt_us:
			Intent i = new Intent("com.pict.Timetable.Test");
			startActivity(i);
			//startActivity(new Intent(WidgetDataProvider.this,Test.class));
			break;

		case R.id.exit:
			finish();
			break;
		}
		return true;
	}
}
