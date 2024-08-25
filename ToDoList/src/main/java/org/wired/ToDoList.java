package org.wired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDoList {
    private final List<Task> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public List<Task> getPendingTasks() {
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .toList();
    }

    public List<Task> getCompletedTasks() {
        return tasks.stream()
                .filter(Task::isCompleted)
                .toList();
    }

    @Override
    public String toString() {
        return "ZadaniaDoZrobienia{" +
                "zadania=" + tasks +
                '}';
    }
}
