package main;

import java.util.Vector;

import builder.DeadlineBuilder;
import builder.Director;
import builder.ToDoBuilder;
import model.Deadline;
import model.ToDo;

public class Main {
	Vector<ToDo> todos = new Vector<>();
	public Main() {
		seed();
		int i=1;
		
		for(ToDo t : todos) {
			System.out.println("Current ToDo Case: "+i++);
			t.print();
		}
	}
	
	private void seed() {
		//TODO: replace with builder
		
		Director director = new Director();
		ToDoBuilder todoBuilder = new ToDoBuilder();
		DeadlineBuilder deadlineBuilder = new DeadlineBuilder();
		
		director.constructDeadline(deadlineBuilder);
		deadlineBuilder.addMonths(5);
		Deadline deadline = deadlineBuilder.getResult();
		
		
		//TODO 1 Membuat list ToDo biasa
		director.constructToDo(todoBuilder, "a", deadline);
		ToDo todo = todoBuilder.getResult();
		
		director.constructToDo(todoBuilder, "b", deadline);
		todo.add(todoBuilder.getResult());
		
		director.constructToDo(todoBuilder, "c", deadline);
		todo.add(todoBuilder.getResult());

		director.constructDeadline(deadlineBuilder);
		deadlineBuilder.nextMonth();
		deadline = deadlineBuilder.getResult();
		
		//TODO 2 Copy ToDo ke ToDo2 (test ini menguji deepclone apakah berhasil mengcopy datanya)
		director.constructToDo(todoBuilder, "d", deadline);
		ToDo todo2 = todoBuilder.getResult();
		
		todo.copyTo(todo2);

		//TODO 3 Menambahkan ToDo ke ToDo3 (test ini untuk menguji deepclone adress dari ToDo3, karena jika struktur ToDo berubah maka 
		//		function add() masih ada defect/address ToDo3 masih nyambung dengan ToDo)
		director.constructToDo(todoBuilder, "e", deadline);
		ToDo todo3 = todoBuilder.getResult();
		
		todo3.add(todo);
		director.constructToDo(todoBuilder, "f", deadline);
		todo3.add(todoBuilder.getResult());
		
		//TODO 4 Copy ToDo3 ke ToDo4 (test ini untuk menguji Perfect DeepClone() sampai ke hierarchy yang detail)
		director.constructToDo(todoBuilder, "g", deadline);
		ToDo todo4 = todoBuilder.getResult();
		
		todo3.copyTo(todo4);

		todos.add(todo);
		todos.add(todo2);
		todos.add(todo3);
		todos.add(todo4);
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
