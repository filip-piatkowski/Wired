package org.wired;

import java.time.LocalDate;

public record Task(String title, String description, LocalDate dueDate, boolean isCompleted) {

    public Task {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Tytuł nie może być null'em");
        }
        if (dueDate == null) {
            throw new IllegalArgumentException("Data końcowa nie może być null'em");
        }
    }

    public Task complete() {
        return new Task(title, description, dueDate, true);
    }

    @Override
    public String toString() {
        return "Zadanie" +
                "tytuł='" + title + '\'' +
                ", opis='" + description + '\'' +
                ", data końcowa=" + dueDate +
                ", wykonane=" + isCompleted +
                '}';
    }
}
