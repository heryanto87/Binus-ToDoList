package builder;

import java.util.Vector;

import model.Deadline;
import model.ToDo;

public class ToDoBuilder implements IToDoBuilder{
	private ToDo todo;
	
	public ToDoBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	public void reset() {
		this.todo = new ToDo();
	}

	@Override
	public void addParent() {
		this.todo.setParent(null);
	}

	@Override
	public void addChildren() {
		this.todo.setChildren(new Vector<ToDo>());
	}

	@Override
	public void addName(String n) {
		this.todo.setName(n);
	}

	@Override
	public void addDeadline(Deadline d) {
		this.todo.setDeadline(d);
	}

	@Override
	public ToDo getResult() {
		return this.todo;
	}

}
