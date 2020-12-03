package builder;

import java.util.Vector;

import model.Deadline;
import model.ToDo;

public interface IToDoBuilder {
	public void reset();
	public void addParent();
	public void addChildren();
	public void addName(String n);
	public void addDeadline(Deadline d);
	public ToDo getResult();
}
