package builder;

import model.Deadline;
import model.ToDo;

public class DeadlineBuilder implements IDeadlineBuilder {
	private Deadline deadline;
	
	public DeadlineBuilder() {
		// TODO Auto-generated constructor stub
	}

	public void reset() {
		this.deadline = new Deadline();
	}
	
	public void addDays(int d) {
		deadline.addDays(d);
	}
	
	public void addMonths(int m) {
		deadline.addMonths(m);
	}
	
	public void tommorrow() {
		deadline.tommorrow();
	}

	public void nextWeek() {
		deadline.nextWeek();
	}
	
	public void nextMonth() {
		deadline.nextMonth();
	}
	
	public Deadline getResult() {
		return this.deadline;
	}
}
