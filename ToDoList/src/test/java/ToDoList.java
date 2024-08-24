import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoList {

    private ToDoList toDoList;

    @BeforeEach
    void setUp() {
        toDoList = new ToDoList();
    }

    @Test
    void addTaskSuccessfully() {
        Task task = new Task("Kup w sklepie", "Mleko, Chleb, Jajka", LocalDate.now().plusDays(1), false);
        toDoList.addTask(task);
        assertEquals(1, toDoList.getTask().size());
        assertTrue(toDoList.getTasks().contains(task));
    }

    @Test
    void removeTaskSuccessfully() {
        Task task = new Task("Kup w sklepie", "Mleko, Chleb, Jajka", LocalDate.now().plusDays(1), false);
        toDoList.addTask(task);
        toDoList.removeTask(task);
        assertEquals(0, toDoList.getTasks().size());
    }

    @Test
    void getPendingTaskSuccessfully() {
        Task task1 = new Task("Kup w sklepie", "Mleko, Chleb, Jajka", LocalDate.now().plusDays(1), false);
        Task task2 = new Task("Zakończ projekt", "Wykonaj ostateczny raport", LocalDate.now().plusDays(3), false);
        Task task3 = new Task("Bieganie", "Idź pobiegać przez godzinę", LocalDate.now(), true);

        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);

        List<Task> pendingTask = toDoList.getPendingTasks();
        assertEquals(2, pendingTask.size());
        assertTrue(pendingTask.contains(task1));
        assertTrue(pendingTask.contains(task2));
        assertFalse(pendingTask.contains(task3));
    }

    @Test
    void getCompletedTaskSuccessfully() {
        Task task1 = new Task("Kup w sklepie", "Mleko, Chleb, Jajka", LocalDate.now().plusDays(1), false);
        Task task2 = new Task("Zakończ projekt", "Wykonaj ostateczny raport", LocalDate.now().plusDays(3), false);
        Task task3 = new Task("Bieganie", "Idź pobiegać przez godzinę", LocalDate.now(), true);

        toDoList.add(task1);
        toDoList.addTask(task2);
        toDoList.addTask(taks3);

        List<Task> completedTasks = toDoList.getCompletedTasks();
        assertEquals(1, completedTasks.size());
        assertTrue(completedTasks.contains(task3));
        assertFalse(completedTasks.contains(task1));
        assertFalse(completedTasks.contains(task2));
    }
}
