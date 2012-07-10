package com.infteh.calendarview;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

import java.util.Calendar;

/**
 * A simple dialog containing an {@link android.widget.DatePicker}.
 */
public class CalendarDatePickerDialog extends AlertDialog implements OnDateChangedListener {
	/**
	 * callback.
	 */
	private final OnDateSetListener mCallBack;
	/**
	 * current date.
	 */
	private final Calendar mCalendar;
	/**
	 * title format.
	 */
	private final java.text.DateFormat mTitleDateFormat;
	/**
	 * calendar view.
	 */
	private final CalendarView mCalendarMonthView;

	/**
	 * The callback used to indicate the user is done filling in the date.
	 */
	public interface OnDateSetListener {

		/**
		 * @param view The view associated with this listener.
		 * @param year The year that was set.
		 * @param monthOfYear The month that was set (0-11) for compatibility
		 *            with {@link java.util.Calendar}.
		 * @param dayOfMonth The day of the month that was set.
		 */
		void onDateSet(CalendarView view, int year, int monthOfYear, int dayOfMonth);
	}

	/**
	 * @param context The context the dialog is to run in.
	 * @param callBack How the parent is notified that the date is set.
	 * @param year The initial year of the dialog.
	 * @param monthOfYear The initial month of the dialog.
	 * @param dayOfMonth The initial day of the dialog.
	 */
	public CalendarDatePickerDialog(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
		super(context);

		mCalendarMonthView = new CalendarView(context);

		setView(mCalendarMonthView);

		mCallBack = callBack;
		mTitleDateFormat = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL);
		mCalendar = Calendar.getInstance();

		updateDate(year, monthOfYear, dayOfMonth);

		setButton2(context.getText(R.string.cancel), (OnClickListener) null);
		mCalendarMonthView.registerCalendarDatePickObserver(new CalendarDatePick() {

			@Override
			public void onDatePicked(CalendarAdapter.DayCell dayCell) {
				Calendar picked = dayCell.getDate();
				mCallBack.onDateSet(mCalendarMonthView, picked.get(Calendar.YEAR), picked.get(Calendar.MONTH), picked.get(Calendar.DAY_OF_MONTH));
				dismiss();
			}
		});
	}

	/**
	 * @param view view.
	 * @param year y.
	 * @param month m.
	 * @param day d. 
	 */
	public final void onDateChanged(DatePicker view, int year, int month, int day) {
		updateDate(year, month, day);
	}

	/**
	 * @param year y.
	 * @param monthOfYear m.
	 * @param dayOfMonth d.
	 */
	public final void updateDate(int year, int monthOfYear, int dayOfMonth) {
		mCalendar.set(Calendar.YEAR, year);
		mCalendar.set(Calendar.MONTH, monthOfYear);
		mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		updateTitle();
		mCalendarMonthView.setMonth(mCalendar);
	}

	/**
	 * update title.
	 */
	private void updateTitle() {
		setTitle(mTitleDateFormat.format(mCalendar.getTime()));
	}
}
