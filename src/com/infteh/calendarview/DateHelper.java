package com.infteh.calendarview;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import android.text.format.DateUtils;

/**
 * РљР»Р°СЃСЃ РґР»СЏ СЂР°Р±РѕС‚С‹ СЃ СЌРєР·РµРјРїР»СЏСЂР°РјРё РєР»Р°СЃСЃР° Date.
 */
final class DateHelper {
	/**
	 * Р’СЂРµРјРµРЅРЅР°СЏ Р·РѕРЅР° UTC.
	 */
	public static final String UTC_TIME_ZONE = "UTC";

	/**
	 * 1900 РіРѕРґ.
	 */
	public static final int YEAR1900 = 1900;

	/**
	 * РљРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ.
	 */
	private DateHelper() {
	}

	/**
	 * РЎРѕР·РґР°РЅРёРµ РёРЅРёС†РёРёСЂРѕРІР°РЅРЅРѕРіРѕ СЌРєР·РµРјРїР»СЏСЂР° РєР»Р°СЃСЃР° Date (Р»РѕРєР°Р»СЊРЅР°СЏ Р·РѕРЅР°).
	 * @param year РіРѕРґ.
	 * @param month РјРµСЃСЏС† (РЅРµРѕР±С…РѕРґРёРјРѕ РёСЃРїРѕР»СЊР·РѕРІР°С‚СЊ РєРѕРЅСЃС‚Р°РЅС‚С‹ РєР»Р°СЃСЃР° Calendar).
	 * @param day РґРµРЅСЊ.
	 * @param hour С‡Р°СЃ.
	 * @param minute РјРёРЅСѓС‚Р°.
	 * @return РёРЅРёС†РёРёСЂРѕРІР°РЅРЅС‹Р№ СЌРєР·РµРјРїР»СЏСЂ РєР»Р°СЃСЃР° Date.
	 */
	public static Date createDate(final int year, final int month, final int day, final int hour, final int minute) {

		Calendar calendar = new GregorianCalendar(year, month, day, hour, minute);
		return calendar.getTime();
	}

	/**
	 * РЎРѕР·РґР°РЅРёРµ РёРЅРёС†РёРёСЂРѕРІР°РЅРЅРѕРіРѕ СЌРєР·РµРјРїР»СЏСЂР° РєР»Р°СЃСЃР° Date (Р»РѕРєР°Р»СЊРЅР°СЏ Р·РѕРЅР°).
	 * @param year РіРѕРґ.
	 * @param month РјРµСЃСЏС† (РЅРµРѕР±С…РѕРґРёРјРѕ РёСЃРїРѕР»СЊР·РѕРІР°С‚СЊ РєРѕРЅСЃС‚Р°РЅС‚С‹ РєР»Р°СЃСЃР° Calendar).
	 * @param day РґРµРЅСЊ.
	 * @return РёРЅРёС†РёРёСЂРѕРІР°РЅРЅС‹Р№ СЌРєР·РµРјРїР»СЏСЂ РєР»Р°СЃСЃР° Date.
	 */
	public static Date createDate(final int year, final int month, final int day) {
		return createDate(year, month, day, 0, 0);
	}

	/**
	 * РЎРѕР·РґР°РЅРёРµ РёРЅРёС†РёРёСЂРѕРІР°РЅРЅРѕРіРѕ СЌРєР·РµРјРїР»СЏСЂР° РєР»Р°СЃСЃР° Date СЃ РІСЂРµРјРµРЅРµРј, СѓСЃС‚Р°РЅРѕРІР»РµРЅРЅС‹Рј
	 * РІ РЅР°С‡Р°Р»Рѕ СЃСѓС‚РѕРє (Р·РѕРЅР° GMT).
	 * @param year РіРѕРґ.
	 * @param month РјРµСЃСЏС† (РЅРµРѕР±С…РѕРґРёРјРѕ РёСЃРїРѕР»СЊР·РѕРІР°С‚СЊ РєРѕРЅСЃС‚Р°РЅС‚С‹ РєР»Р°СЃСЃР° Calendar).
	 * @param day РґРµРЅСЊ.
	 * @return РёРЅРёС†РёРёСЂРѕРІР°РЅРЅС‹Р№ СЌРєР·РµРјРїР»СЏСЂ РєР»Р°СЃСЃР° Date.
	 */
	public static Date createDateGMT(final int year, final int month, final int day) {
		return convertToUTC(DateHelper.createDate(year, month, day, 0, 0));
	}

	/**
	 * РЎСЂР°РІРЅРµРЅРёРµ РґРІСѓС… РґР°С‚ СЃ СѓС‡С‘С‚РѕРј РІСЂРµРјРµРЅРё.
	 * @param date1 РїРµСЂРІР°СЏ РґР°С‚Р°.
	 * @param date2 РІС‚РѕСЂР°СЏ РґР°С‚Р°.
	 * @return true, РµСЃР»Рё РїРµСЂРІР°СЏ РґР°С‚Р° Р±РѕР»СЊС€Рµ РёР»Рё СЂР°РІРЅР° РІС‚РѕСЂРѕР№.
	 */
	public static boolean dateMoreOrEqual(final Date date1, final Date date2) {
		return date1.compareTo(date2) >= 0;
	}

	/**
	 * РЎСЂР°РІРЅРµРЅРёРµ РґРІСѓС… РґР°С‚ СЃ СѓС‡С‘С‚РѕРј РІСЂРµРјРµРЅРё.
	 * @param date1 РїРµСЂРІР°СЏ РґР°С‚Р°.
	 * @param date2 РІС‚РѕСЂР°СЏ РґР°С‚Р°.
	 * @return true, РµСЃР»Рё РїРµСЂРІР°СЏ РґР°С‚Р° РјРµРЅСЊС€Рµ РІС‚РѕСЂРѕР№.
	 */
	public static boolean dateLess(final Date date1, final Date date2) {
		return date1.compareTo(date2) < 0;
	}

	/**
	 * Р�Р·РјРµРЅСЏРµС‚ Р·РЅР°С‡РµРЅРёРµ РґР°С‚С‹.
	 * @param date РёСЃС…РѕРґРЅРѕРµ Р·РЅР°С‡РµРЅРёРµ.
	 * @param field РёР·РјРµРЅСЏРµРјРѕРµ РїРѕР»Рµ (СЃРј. РєРѕРЅСЃС‚Р°РЅС‚С‹ РєР»Р°СЃСЃР° Calendar).
	 * @param value РЅР° СЃРєРѕР»СЊРєРѕ РёР·РјРµРЅРёС‚СЊ Р·РЅР°С‡РµРЅРёРµ.
	 * @return РЅРѕРІРѕРµ Р·РЅР°С‡РµРЅРёРµ РґР°С‚С‹.
	 */
	public static Date add(final Date date, final int field, final int value) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(field, value);
		return calendar.getTime();
	}

	/**
	 * РџСЂРёРІРѕРґРёС‚ РґР°С‚Сѓ СЃ РІСЂРµРјРµРЅРµРј Рє РґР°С‚Рµ СЃ РІСЂРµРјРµРЅРµРј, СЃРѕРѕС‚РІРµС‚СЃС‚РІСѓСЋС‰РёРј РЅР°С‡Р°Р»Сѓ СЃСѓС‚РѕРє.
	 * @param date Р”Р°С‚Р° СЃ РІСЂРµРјРµРЅРµРј.
	 * @return РґР°С‚Р° СЃ РІСЂРµРјРµРЅРµРј РЅР° РЅР°С‡Р°Р»Рѕ СЃСѓС‚РѕРє.
	 */
	public static Date clearTime(final Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
		calendar.set(GregorianCalendar.MINUTE, 0);
		calendar.set(GregorianCalendar.SECOND, 0);
		calendar.set(GregorianCalendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * РЎСЂР°РІРЅРµРЅРёРµ РЅР° СЂР°РІРµРЅСЃС‚РІРѕ РґРІСѓС… РґР°С‚, Р±РµР· СѓС‡С‘С‚Р° СЃРѕСЃС‚Р°РІР»СЏСЋС‰РёС… РІСЂРµРјРµРЅРё.
	 * @param date1 РїРµСЂРІР°СЏ РґР°С‚Р°.
	 * @param date2 РІС‚РѕСЂР°СЏ РґР°С‚Р°.
	 * @return true, РµСЃР»Рё РґР°С‚С‹ СЂР°РІРЅС‹.
	 */
	public static boolean equalsIgnoreTime(final Date date1, final Date date2) {
		Date clearedDate1 = DateHelper.clearTime(date1);
		Date clearedDate2 = DateHelper.clearTime(date2);
		return clearedDate1.equals(clearedDate2);
	}

	/**
	 * Р—Р°РјРµРЅРёС‚СЊ РґР°С‚Сѓ.
	 * @param sourceDate Р�СЃС…РѕРґРЅР°СЏ РґР°С‚Р°/РІСЂРµРјСЏ.
	 * @param year Р“РѕРґ.
	 * @param monthOfYear РњРµСЃСЏС†.
	 * @param dayOfMonth Р”РµРЅСЊ РјРµСЃСЏС†Р°.
	 * @return РќРѕРІР°СЏ РґР°С‚Р°.
	 */
	public static Date replaceDate(final Date sourceDate, final int year, final int monthOfYear, final int dayOfMonth) {
		java.util.Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(sourceDate);

		calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, monthOfYear);
		calendar.set(GregorianCalendar.DAY_OF_MONTH, dayOfMonth);

		return calendar.getTime();
	}

	/**
	 * Р—Р°РјРµРЅРёС‚СЊ РґР°С‚Сѓ РІ РєР°Р»РµРЅРґР°СЂРµ.
	 * @param calendar РљР°Р»РµРЅРґР°СЂСЊ.
	 * @param year Р“РѕРґ.
	 * @param monthOfYear РњРµСЃСЏС†.
	 * @param dayOfMonth Р”РµРЅСЊ РјРµСЃСЏС†Р°.
	 */
	public static void changeDate(final java.util.Calendar calendar, final int year, final int monthOfYear, final int dayOfMonth) {
		calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, monthOfYear);
		calendar.set(GregorianCalendar.DAY_OF_MONTH, dayOfMonth);
	}

	/**
	 * Р—Р°РјРµРЅРёС‚СЊ РІСЂРµРјСЏ.
	 * @param sourceDate Р�СЃС…РѕРґРЅР°СЏ РґР°С‚Р°/РІСЂРµРјСЏ.
	 * @param hourOfDay Р§Р°СЃ.
	 * @param minute РњРёРЅСѓС‚Р°.
	 * @param second РЎРµРєСѓРЅРґР°.
	 * @return РќРѕРІР°СЏ РґР°С‚Р°.
	 */
	public static Date replaceTime(final Date sourceDate, final int hourOfDay, final int minute, final int second) {
		java.util.Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(sourceDate);

		calendar.set(GregorianCalendar.HOUR_OF_DAY, hourOfDay);
		calendar.set(GregorianCalendar.MINUTE, minute);
		calendar.set(GregorianCalendar.SECOND, second);

		return calendar.getTime();
	}

	/**
	 * Р—Р°РјРµРЅРёС‚СЊ РІСЂРµРјСЏ.
	 * @param calendar РљР°Р»РµРЅРґР°СЂСЊ.
	 * @param hourOfDay Р§Р°СЃ.
	 * @param minute РњРёРЅСѓС‚Р°.
	 * @param second РЎРµРєСѓРЅРґР°.
	 */
	public static void changeTime(final java.util.Calendar calendar, final int hourOfDay, final int minute, final int second) {
		calendar.set(GregorianCalendar.HOUR_OF_DAY, hourOfDay);
		calendar.set(GregorianCalendar.MINUTE, minute);
		calendar.set(GregorianCalendar.SECOND, second);
	}

	/**
	 * РџСЂРµРѕР±СЂР°Р·РѕРІР°С‚СЊ РёР· РіСѓРіР»РѕРІСЃРєРѕРіРѕ С‚РёРїР° РґР°С‚С‹ РІ СЏРІРѕРІСЃРєРёР№.
	 * @param date РґР°С‚Р°
	 * @return РґР°С‚Р° РІ СЏРІР° С„РѕСЂРјР°С‚Рµ
	 */
	public static GregorianCalendar fromDateToCalendar(final Date date) {
		GregorianCalendar calendar = new GregorianCalendar(0, 0, 0, 0, 0);
		calendar.setTimeInMillis(date.getTime());
		return calendar;
	}

	/**
	 * Р¤РѕСЂРјР°С‚РёСЂРѕРІР°С‚СЊ РґР°С‚Сѓ.
	 * @param format Р¤РѕСЂРјР°С‚ РґР°С‚С‹ (СЃС‚Р°РЅРґР°СЂС‚РЅС‹Р№, РѕС‚ SimpleDateFormat).
	 * @param date РґР°С‚Р°.
	 * @return Р РµР·СѓР»СЊС‚Р°С‚.
	 */
	public static String dateFormat(final String format, final Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	/**
	 * РџСЂРµРѕР±СЂР°Р·РѕРІР°С‚СЊ РґР°С‚Сѓ РІ РґР°С‚Сѓ РїРѕ РіСЂРёРЅРІРёС‡Сѓ. РќР°РїСЂРёРјРµСЂ, 01.04.2012 00:00:00
	 * GMT+04:00 -> 01.04.2012 00:00:00 GMT.
	 * @param date Р”Р°С‚Р°, РєРѕС‚РѕСЂСѓСЋ РЅРµРѕР±С…РѕРґРёРјРѕ РїСЂРµРѕР±СЂР°Р·РѕРІР°С‚СЊ.
	 * @return Р”Р°С‚Р° РїРѕ РіСЂРёРЅРІРёС‡РµСЃРєРѕРјСѓ РІСЂРµРјРµРЅРё.
	 */
	public static Date convertToUTC(final Date date) {
		GregorianCalendar calendar = new GregorianCalendar(date.getYear() + YEAR1900, date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(),
				date.getSeconds());
		calendar.setTimeZone(TimeZone.getTimeZone(UTC_TIME_ZONE));

		return calendar.getTime();
	}

	/**
	 * Р�Р·РјРµРЅРёС‚СЊ Р·РЅР°С‡РµРЅРёРµ РєР°Р»РµРЅРґР°СЂСЏ РЅР° РЅР°С‡Р°Р»Рѕ СЃСѓС‚РѕРє Рё РёР·РјРµРЅРёС‚СЊ РІСЂРµРјРµРЅРЅСѓСЋ Р·РѕРЅСѓ
	 * UTC.
	 * @param calendar РљР°Р»РµРЅРґР°СЂСЊ.
	 */
	public static void changeToBeginDayUTC(final java.util.Calendar calendar) {
		int year = calendar.get(GregorianCalendar.YEAR);
		int month = calendar.get(GregorianCalendar.MONTH);
		int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);

		calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
		calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, month);
		calendar.set(GregorianCalendar.DAY_OF_MONTH, day);
		calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
		calendar.set(GregorianCalendar.MINUTE, 0);
		calendar.set(GregorianCalendar.SECOND, 0);
		calendar.set(GregorianCalendar.MILLISECOND, 0);
	}

	/**
	 * РЈСЃС‚Р°РЅРѕРІРёС‚СЊ РІ РєР°Р»РµРЅРґР°СЂРµ СѓРєР°Р·Р°РЅРЅРѕРµ РІСЂРµРјСЏ Рё С‡Р°СЃРѕРІРѕР№ РїРѕСЏСЃ.
	 * @param calendar РљР°Р»РµРґР°СЂСЊ.
	 * @param hours Р§Р°СЃС‹.
	 * @param minutes РњРёРЅСѓС‚С‹.
	 * @param timeZone Р’СЂРµРјРµРЅРЅР°СЏ Р·РѕРЅР°.
	 */
	public static void changeTimeAndTimeZone(final java.util.Calendar calendar, final int hours, final int minutes, final String timeZone) {
		int year = calendar.get(GregorianCalendar.YEAR);
		int month = calendar.get(GregorianCalendar.MONTH);
		int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);

		calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
		calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, month);
		calendar.set(GregorianCalendar.DAY_OF_MONTH, day);
		calendar.set(GregorianCalendar.HOUR_OF_DAY, hours);
		calendar.set(GregorianCalendar.MINUTE, minutes);
	}

	/**
	 * РџСЂРµРѕР±СЂР°Р·РѕРІР°РЅРёРµ РёР· РіСЂРёРЅРІРёС‡Р° РІ С‚РµРєСѓС‰РµРµ РІСЂРµРјСЏ.
	 * @param dateGMT Р”Р°С‚Р° РІ GMT.
	 * @return РґР°С‚Р° РІ Р»РѕРєР°Р»СЊРЅРѕР№ Р·РѕРЅРµ.
	 */
	public static Date convertToCurrentTimeZone(final Date dateGMT) {
		long date = dateGMT.getTime() + dateGMT.getTimezoneOffset() * DateUtils.MINUTE_IN_MILLIS;
		return new Date(date);
	}

	/**
	 * @param date date.
	 * @return sql date format string.
	 */
	public static String dateToSqlFormat(Date date) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder now = new StringBuilder(dateformat.format(date));
		return now.toString();
	}

	/**
	 * РЎРѕР·РґР°С‚СЊ РєР°Р»РµРЅРґР°СЂСЊ.
	 * @param year Р“РѕРґ.
	 * @param month РњРµСЃСЏС†.
	 * @param day Р”РµРЅСЊ.
	 * @param timezone Р’СЂРµРјРµРЅРЅР°СЏ Р·РѕРЅР°.
	 * @return РєР°Р»РµРЅРґР°СЂСЊ.
	 */
	public static Calendar createCalendar(final int year, final int month, final int day, final String timezone) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timezone));

		calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, month);
		calendar.set(GregorianCalendar.DAY_OF_MONTH, day);
		calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
		calendar.set(GregorianCalendar.MINUTE, 0);
		calendar.set(GregorianCalendar.SECOND, 0);
		calendar.set(GregorianCalendar.MILLISECOND, 0);

		return calendar;
	}

	/**
	 * РЎРѕР·РґР°С‚СЊ РєР°Р»РµРЅРґР°СЂСЊ.
	 * @return РєР°Р»РµРЅРґР°СЂСЊ.
	 */
	public static Calendar createCurrentBeginDayCalendar() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar;
	}

	/**
	 * РЎРѕР·РґР°С‚СЊ РєР°Р»РµРЅРґР°СЂСЊ.
	 * @param year Р“РѕРґ.
	 * @param month РњРµСЃСЏС†.
	 * @param day Р”РµРЅСЊ.
	 * @param hour С‡Р°СЃ.
	 * @param minute РјРёРЅСѓС‚Р°.
	 * @param timezone Р·РѕРЅР°.
	 * @return РєР°Р»РµРЅРґР°СЂСЊ.
	 */
	public static Calendar createCalendar(final int year, final int month, final int day, final int hour, final int minute, final String timezone) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timezone));

		calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, month);
		calendar.set(GregorianCalendar.DAY_OF_MONTH, day);
		calendar.set(GregorianCalendar.HOUR_OF_DAY, hour);
		calendar.set(GregorianCalendar.MINUTE, minute);
		calendar.set(GregorianCalendar.SECOND, 0);
		calendar.set(GregorianCalendar.MILLISECOND, 0);

		return calendar;
	}

	/**
	 * increment by 1 day.
	 * @param currentDate date.
	 */
	public static void increment(Calendar currentDate) {
		currentDate.add(Calendar.DATE, 1);
	}

	/**
	 * @param day day.
	 * @return is day weekend.
	 */
	public static boolean isWeekendDay(Calendar day) {
		if (isMondayFirst()) {
			return (day.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (day.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
		} else {
			return (day.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
		}
	}

	/**
	 * @param day day.
	 * @return is last day of week.
	 */
	public static boolean isLastDayOfWeek(Calendar day) {
		if (isMondayFirst()) {
			return (day.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
		} else {
			return (day.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY);
		}
	}

	/**
	 * @return is week starts from monday.
	 */
	public static boolean isMondayFirst() {
		return Calendar.getInstance().getFirstDayOfWeek() == Calendar.MONDAY;
	}

	/**
	 * РЎРѕР·РґР°С‚СЊ С‚РµРєСѓС‰РёРµ СЃСѓС‚РєРё РІ UTC timezone. Р‘РµСЂС‘С‚СЃСЏ С‚РµРєСѓС‰Р°СЏ РґР°С‚Р° РёР· С‚Р°Р№РјР·РѕРЅС‹ РїРѕ
	 * СѓРјРѕР»С‡Р°РЅРёСЋ, Рё РґРµР»Р°РµС‚СЃСЏ С‚Р°РєР°СЏ Р¶Рµ РґР°С‚Р°, РЅРѕ РІ UTC.
	 * @return С‚РµРєСѓС‰РёРµ СЃСѓС‚РєРё РІ UTC timezone.
	 */
	public static Calendar createCurrentBeginDayInUTC() {
		Calendar now = new GregorianCalendar();

		Calendar result = Calendar.getInstance(TimeZone.getTimeZone(UTC_TIME_ZONE));
		result.set(Calendar.YEAR, now.get(Calendar.YEAR));
		result.set(Calendar.MONTH, now.get(Calendar.MONTH));
		result.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH));
		result.set(Calendar.HOUR_OF_DAY, 0);
		result.set(Calendar.MINUTE, 0);
		result.set(Calendar.SECOND, 0);
		result.set(Calendar.MILLISECOND, 0);

		return result;
	}
}
