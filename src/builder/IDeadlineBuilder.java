package builder;

import model.Deadline;

public interface IDeadlineBuilder {
	public void reset();
	public void addDays(int d);
	public void addMonths(int m);
	public void tommorrow();
	public void nextWeek();
	public void nextMonth();
	public Deadline getResult();
}
