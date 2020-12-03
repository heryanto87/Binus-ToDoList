package model;

import java.util.Vector;

public class ToDo implements Cloneable{
	private ToDo parent;
	private Vector<ToDo> children;

	private String name;
	private Deadline deadline;
	
	public ToDo(String name, Deadline deadline) {
		super();
		this.name = name;
		this.deadline = deadline;
		parent = null;
		children = new Vector<ToDo>();
	}
	
	/**
	 * Constructor
	 * 
	 * @Added by 2201759142
	 */
	public ToDo() {
		
	}
	
	/**
	 * This function's(deepClone) clone all the parents and children class in recursive 
	 * This function's(moveFrom) move the children from the ToDo parameters below to the current ToDo
	 * This function's(getDeadline) getting Deadline attribute since it's privates
	 * Setter Getter
	 * 
	 * @Added by 2201759142
	 */
	public ToDo deepClone() {
		ToDo todo = new ToDo(this.name, this.deadline);
		
		for(ToDo t : this.children) {
			todo.add(t.deepClone());
		}
		
		return todo;
	}
	
	public void moveFrom(ToDo from) {		
		ToDo todo = from.deepClone();
		this.children = todo.children;
	}
	
	public Vector<ToDo> getChildren() {
		return children;
	}

	public void setChildren(Vector<ToDo> children) {
		this.children = children;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}
	
	/**
	 * copy this ToDos structures (including the children) to new parent.
	 * 
	 * @param parent
	 */
	public void copyTo(ToDo parent) {
		parent.children.clear();
		ToDo t = this.deepClone();
		parent.moveFrom(t);
	}

	//i changed this function because it's not safe to straight add from the current address
	public void add(ToDo c) {
		ToDo todo = c.deepClone();
		this.children.add(todo);
		todo.setParent(this);
		
		/*before
			this.children.add(c);
			c.setParent(this);
		*/
	}

	public void print() {
		System.out.println(this);
		for(ToDo todo : children) {
			todo.print();
		}
	}

	@Override
	public String toString() {
		String indent = "";
		for(int i = 0; i < getLevel(); i++) {
			indent += "--";
		}
		
		return indent + name + " | deadline: " + deadline;
	}
	
	public void setParent(ToDo parent) {
		this.parent = parent;
	}
	
	public ToDo getParent() {
		return parent;
	}
	
	private int getLevel() {
		int level = 0;
		ToDo curr = parent;
		while(curr != null) {
			curr = curr.getParent();
			++level;
		}
		return level;
	}
}
