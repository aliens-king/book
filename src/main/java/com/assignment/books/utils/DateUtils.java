package com.assignment.books.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static Date getDateObj(String dateAsString, String pattern) {
		Date date = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			date = formatter.parse(dateAsString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getDateAsString(Date date, String pattern) {
		String dateAsString = null;
		try {
			if (null != date) {
				SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
				dateAsString = dateFormat.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateAsString;

	}

}
