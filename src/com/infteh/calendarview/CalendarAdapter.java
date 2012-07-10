package com.infteh.calendarview;

import java.util.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * calendar adapter.
 * @author Sazonov-adm
 * 
 */
public class CalendarAdapter extends BaseAdapter {

	/**
	 * references to our items.
	 */
	private DayCell[] days;

	/**
	 * context.
	 */
	private Context mContext;

	/**
	 * init month.
	 */
	private java.util.Calendar mCurrentMonth;
	/**
	 * today.
	 */
	private Calendar mToday;

	/**
	 * @param context context.
	 * @param monthCalendar current month.
	 */
	public CalendarAdapter(Context context, Calendar monthCalendar) {
		mToday = DateHelper.createCurrentBeginDayCalendar();
		mCurrentMonth = (Calendar) monthCalendar.clone();
		mContext = context;
		mCurrentMonth.set(Calendar.DAY_OF_MONTH, 1);
		refreshDays();
	}

	/**
	 * @param month current month.
	 */
	public final void setMonth(Calendar month) {
		mCurrentMonth = (Calendar) month.clone();
	}

	public int getCount() {
		return days.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View currentView = convertView;
		TextView dayViewTextView;
		DayCell dayCell = days[position];
		if (convertView == null) { 
			LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			currentView = vi.inflate(R.layout.calendar_item, null);
		}
		dayViewTextView = (TextView) currentView.findViewById(R.id.date);
		boolean isCurrentMonth = dayCell.mDate.get(Calendar.MONTH) == mCurrentMonth.get(Calendar.MONTH);
		if (!isCurrentMonth) {
			dayViewTextView.setTextColor(mContext.getResources().getColor(R.color.calendar_secondary_font_color));
		} else {
			dayViewTextView.setTextColor(mContext.getResources().getColor(R.color.calendar_font_color));
		}

		if (DateHelper.isWeekendDay(dayCell.mDate)) {
			if (isCurrentMonth) {
				dayViewTextView.setTextColor(mContext.getResources().getColor(R.color.calendar_weekend_font_color));
			} else {
				dayViewTextView.setTextColor(mContext.getResources().getColor(R.color.calendar_secondary_weekend_font_color));
			}
		}

		if (mToday.equals(dayCell.mDate)) {
			currentView.setBackgroundResource(R.drawable.calendar_item_background_today);
		} else {
			if (isCurrentMonth) {
				currentView.setBackgroundResource(R.drawable.list_item_background);
			} else {
				currentView.setBackgroundResource(R.drawable.calendar_notcurrentmonth_item_selector);
			}
		}
		dayViewTextView.setText(dayCell.getDescr());

		// create date string for comparison
		String date = dayCell.getDescr();

		if (date.length() == 1) {
			date = "0" + date;
		}

		String monthStr = "" + (mCurrentMonth.get(Calendar.MONTH) + 1);
		if (monthStr.length() == 1) {
			monthStr = "0" + monthStr;
		}
		currentView.setTag(dayCell);
		return currentView;
	}

	/**
	 * refresh.
	 */
	public final void refreshDays() {
		Calendar currentDate = DateHelper.fromDateToCalendar(DateHelper.clearTime(((Calendar) mCurrentMonth.clone()).getTime()));
		currentDate.set(Calendar.DAY_OF_MONTH, 1);

		int firstDay = currentDate.get(Calendar.DAY_OF_WEEK);
		int dayShift;
		if (DateHelper.isMondayFirst()) {
			if (firstDay == Calendar.SUNDAY) {
				dayShift = 6;
			} else {
				dayShift = firstDay - 2;
			}
		} else {
			dayShift = firstDay - 1;
		}
		currentDate.add(Calendar.DATE, -dayShift);
		days = new DayCell[42];
		for (int i = 0; i < days.length; i++) {
			days[i] = new DayCell(currentDate, "" + currentDate.get(Calendar.DAY_OF_MONTH));
			DateHelper.increment(currentDate);
		}
	}

	/**
	 * @author Sazonov-adm
	 * 
	 */
	public class DayCell {
		/**
		 * descr.
		 */
		private String mDescription;
		/**
		 * date.
		 */
		private Calendar mDate;

		/**
		 * @param currentDate date.
		 * @param text descr.
		 */
		public DayCell(Calendar currentDate, String text) {
			mDescription = text;
			mDate = (Calendar) currentDate.clone();
		}

		/**
		 * @return descr.
		 */
		public final String getDescr() {
			return mDescription;
		}

		/**
		 * @return date.
		 */
		public final Calendar getDate() {
			return mDate;
		}

		@Override
		public final int hashCode() {
			return super.hashCode();
		}

		@Override
		public final boolean equals(Object other) {
			// Not strictly necessary, but often a good optimization
			if (this == other) {
				return true;
			}
			if (!(other instanceof DayCell)) {
				return false;
			}
			DayCell otherA = (DayCell) other;
			return (mDate.equals(otherA.mDate)) && ((mDate == null) ? otherA.mDate == null : mDate.equals(otherA.mDate));
		}
	}
}