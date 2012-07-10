package com.infteh.calendarview;

import java.util.Calendar;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * calendar view.
 * @author Sazonov-adm
 *
 */
public class CalendarView extends LinearLayout {
	
	/**
	 * pager.
	 */
	private ViewPager pager;
	
	/**
	 * adapter.
	 */
	private MonthPagerAdapter adapter;
	
	/**
	 * РљРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ.
	 * 
	 * @param context РєРѕРЅС‚РµРєСЃС‚
	 */
	public CalendarView(final Context context) {
		this(context, null);
	}

	/**
	 * РљРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ.
	 * 
	 * @param context РєРѕРЅС‚РµРєСЃС‚
	 * @param attrs Р°С‚СЂРёР±СѓС‚С‹
	 */
	public CalendarView(final Context context, final AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.calendar_view, this, true);
		pager = ((ViewPager) findViewById(R.id.calendar_view_pager));
		adapter = new MonthPagerAdapter(inflater, pager);
		pager.setAdapter(adapter);
		pager.setCurrentItem(MonthPagerAdapter.INFINITE / 2);
	}
	
	/**
	 * Р—Р°СЂРµРіРёСЃС‚СЂРёСЂРѕРІР°С‚СЊ РЅРѕРІС‹Р№ РЅР°Р±Р»СЋРґР°С‚РµР»СЊ.
	 * 
	 * @param observer РќР°Р±Р»СЋРґР°С‚РµР»СЊ.
	 */
	public final void registerCalendarDatePickObserver(final CalendarDatePick observer) {
		((MonthPagerAdapter) pager.getAdapter()).setPickObserver(observer);
	}
	
	/**
	 * set current.
	 * @param month month.
	 */
	public final void setMonth(Calendar month) {
		adapter.setMonth(month);
	}

	/**
	 * get current.
	 * @return month month.
	 */
	public final Calendar getMonth() {
		return adapter.getMonth();
	}
}
