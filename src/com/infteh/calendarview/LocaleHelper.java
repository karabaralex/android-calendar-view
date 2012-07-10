package com.infteh.calendarview;

import android.content.Context;

/**
 * помошник при работе с локализациями.
 * @author Sazonov-adm
 *
 */
public class LocaleHelper {
	/**
	 * is current locale - russian.
	 * @param context context.
	 * @return is russian.
	 */
	public static boolean isRussianLocale(Context context) {
		return context.getResources().getConfiguration().locale.getLanguage().equals("ru");
	}
}
