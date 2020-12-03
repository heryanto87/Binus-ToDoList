package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * this class is wrapping java.util.Date
 * seconds and milliseconds is not used (always zero)
 * 
 * @author mrp130
 */
public class Deadline {
	private Date date;
	
	public Deadline() {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    
	    this.date = calendar.getTime();
	}
	
	/**
	 * extends n days to current date
	 * 
	 * @param days
	 */
	public void addDays(int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		c.add(Calendar.DATE, days);
		this.date = c.getTime();
	}

	/**
	 * extends n months to current date
	 * 
	 * @param days
	 */
	public void addMonths(int months) {
		addDays(30*months);
	}
	
	public void tommorrow() {
		addDays(1);
	}

	public void nextWeek() {
		addDays(7);
	}
	
	public void nextMonth() {
		addMonths(1);
	}
	
	@Override
	public String toString() {
		String pattern = "yyyy-MM-dd hh:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}
