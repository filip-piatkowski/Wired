package org.wired;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        Task task1 = new Task("Zrobić zakupy", "Mleko, chleb, jaja", LocalDate.now().plusDays(1), false);
        Task task2 = new Task("Zakończ projekt", "Dokończ ostatni raport", LocalDate.now().plusDays(3), false);
        Task task3 = new Task("Siłka", "Idź pobiegać", LocalDate.now(), false);

        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);

        System.out.println("Wszystkie zadania:");
        toDoList.getTasks().forEach(System.out::println);

        System.out.println("\nOczekujące zadania:");
        toDoList.getPendingTasks().forEach(System.out::println);

        Task completedTask = task1.complete();
        toDoList.removeTask(task1);
        toDoList.addTask(completedTask);

        System.out.println("\nWykonane zadania:");
        toDoList.getCompletedTasks().forEach(System.out::println);
    }
}
//TODO Ztobić prawilną aplikacje z interfejsem.