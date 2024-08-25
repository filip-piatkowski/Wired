import org.junit.jupiter.api.Test;
import org.wired.Task;
import org.wired.ToDoList;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    @Test
    public void testAddTask() {
        ToDoList toDoList = new ToDoList();
        Task task = new Task("Tytuł", "Opis", LocalDate.now(), false);
        toDoList.addTask(task);
        assertEquals(1, toDoList.getTasks().size());
        assertTrue(toDoList.getTasks().contains(task));
    }

    @Test
    public void testRemoveTask() {
        ToDoList toDoList = new ToDoList();
        Task task = new Task("Tytuł", "Opis", LocalDate.now(), false);
        toDoList.addTask(task);
        toDoList.removeTask(task);
        assertEquals(0, toDoList.getTasks().size());
    }

    @Test
    public void testGetPendingTasks() {
        ToDoList toDoList = new ToDoList();
        Task task1 = new Task("Tytuł1", "Opis1", LocalDate.now(), false);
        Task task2 = new Task("Tytuł2", "Opis2", LocalDate.now(), true);
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        List<Task> pendingTasks = toDoList.getPendingTasks();
        assertEquals(1, pendingTasks.size());
        assertTrue(pendingTasks.contains(task1));
        assertFalse(pendingTasks.contains(task2));
    }

    @Test
    public void testGetCompletedTasks() {
        ToDoList toDoList = new ToDoList();
        Task task1 = new Task("Tytuł1", "Opis1", LocalDate.now(), false);
        Task task2 = new Task("Tytuł2", "Opis2", LocalDate.now(), true);
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        List<Task> completedTasks = toDoList.getCompletedTasks();
        assertEquals(1, completedTasks.size());
        assertTrue(completedTasks.contains(task2));
        assertFalse(completedTasks.contains(task1));
    }

    @Test
    public void testToString() {
        ToDoList toDoList = new ToDoList();
        Task task = new Task("Tytuł", "Opis", LocalDate.now(), false);
        toDoList.addTask(task);
        String expected = "ZadaniaDoZrobienia{zadania=[" + task.toString() + "]}";
        assertEquals(expected, toDoList.toString());
    }
}