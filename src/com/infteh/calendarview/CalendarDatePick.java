package com.infteh.calendarview;

import com.infteh.calendarview.CalendarAdapter.DayCell;

/**
 * listener.
 * @author Sazonov-adm
 *
 */
public interface CalendarDatePick {
	/**
	 * @param dayCell cell.
	 */
	void onDatePicked(DayCell dayCell);
}
