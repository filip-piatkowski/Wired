
import org.junit.jupiter.api.Test;
import org.wired.Task;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("Tytuł", "Opis", LocalDate.now(), false);
        assertEquals("Tytuł", task.title());
        assertEquals("Opis", task.description());
        assertEquals(LocalDate.now(), task.dueDate());
        assertFalse(task.isCompleted());
    }

    @Test
    public void testTaskCreationWithNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Opis", LocalDate.now(), false);
        });
    }

    @Test
    public void testTaskCreationWithBlankTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("", "Opis", LocalDate.now(), false);
        });
    }

    @Test
    public void testTaskCreationWithNullDueDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Tytuł", "Opis", null, false);
        });
    }

    @Test
    public void testCompleteTask() {
        Task task = new Task("Tytuł", "Opis", LocalDate.now(), false);
        Task completedTask = task.complete();
        assertTrue(completedTask.isCompleted());
    }

    @Test
    public void testToString() {
        Task task = new Task("Tytuł", "Opis", LocalDate.now(), false);
        String expected = "Zadanie" +
                "tytuł='Tytuł'" +
                ", opis='Opis'" +
                ", data końcowa=" + LocalDate.now() +
                ", wykonane=false" +
                '}';
        assertEquals(expected, task.toString());
    }
}