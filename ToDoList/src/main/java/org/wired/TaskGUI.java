package org.wired;

public class TaskGUI {
    private String taskDescription;
    private boolean completed;

    public TaskGUI(String taskDescription) {
        this.taskDescription = taskDescription;
        this.completed = false; // Domyślnie zadanie nie jest wykonane
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        // Dodajemy znacznik (np. [x]) jeśli zadanie jest wykonane
        return (completed ? "[x] " : "[ ] ") + taskDescription;
    }
}