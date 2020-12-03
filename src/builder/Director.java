package builder;

import model.Deadline;
import model.ToDo;

public class Director {

	private IToDoBuilder todoBuilder;
	private IDeadlineBuilder deadlineBuilder;
	
	public Director() {
		
	}
	
	public void setTodoBuilder(IToDoBuilder b) {
		this.todoBuilder = b;
	}
	
	public void setDeadlineBuilder(IDeadlineBuilder b) {
		this.deadlineBuilder = b;
	}
	
	public void constructToDo(IToDoBuilder b, String n, Deadline d) {
		b.reset();
		b.addParent();
		b.addChildren();
		b.addName(n);
		b.addDeadline(d);
	}
	
	public void constructDeadline(IDeadlineBuilder b) {
		b.reset();
	}
}
