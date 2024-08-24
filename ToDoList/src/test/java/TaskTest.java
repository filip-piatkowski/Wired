import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void createTaskSuccessfully() {
        Task task = new Task("Kup w sklepie", "Mleko, Chleb, Jajka", LocalDate.now().plusDays(1), false);
        assertNotNull(task);
        assertEquals("Kup w sklepie", task.title());
        assertEquals("Mleko, Chleb, Jajka", task.description());
        assertFalse(task.isCompleted());
    }

    @Test
    void throwExceptionWhenTitleIsBlank() {
        Exception exception = assertThrows(IllegalArgumentException.class, () new Task(" ", "Opis", LocalDate.now(), false));
        assertEquals("Tytuł nie może być pusty", exception.getMessage());
    }

    @Test
    void throwExceptionDueDateIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () new Task("Tytuł", "Opis", null, false));
        assertEquals("Data końcowa nie może być null'em", exception.getMessage());
    }

    @Test
    void completeTaskSuccessfully() {
        Task task = new Task("Kup w sklepie", "Mleko, Chleb, Jajka", LocalDate.now().plusDays(1), false);
        Task completedTask= task.complete();
        assertTrue(completedTask.isCompleted());
        assertEquals(task.title(), completedTask.title());
        assertEquals(task.description(), completedTask.description());
        assertEquals(task.dueDate(), completedTask.dueDate());
    }
}