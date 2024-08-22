import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.wired.Stopwatch;

import static org.junit.jupiter.api.Assertions.*;

public class StopwatchTest {
    private Stopwatch stopwatch;

    @Test
    public void testStartStop() throws InterruptedException {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        Thread.sleep(1000); // symulacja jednej sekundy
        stopwatch.stop();
        long elapsedTime = stopwatch.getElapsedTime();
        assertTrue(elapsedTime >= 1000 && elapsedTime < 1100);
    }

    @Before
    public void setUp() {
        stopwatch = new Stopwatch();
    }

    @Test
    public void testInitialState() {
        assertFalse(stopwatch.running, "Stoper powinien być zatrzymany po inicjalizacji.");
        Assertions.assertEquals(0, stopwatch.getElapsedTime(), "Czas powinien wynosić 0 po inicjalizacji.");
    }

    @Test
    public void testStart() throws InterruptedException {
        stopwatch.start();
        Thread.sleep(100);  // Czekamy 100 ms
        assertTrue(stopwatch.getElapsedTime() >= 100, "Czas powinien wynosić co najmniej 100 ms po starcie.");
        assertTrue(stopwatch.running, "Stoper powinien być uruchomiony po starcie.");
    }

    @Test
    public void testStop() throws InterruptedException {
        stopwatch.start();
        Thread.sleep(100);  // Czekamy 100 ms
        stopwatch.stop();
        long elapsedTime = stopwatch.getElapsedTime();
        Thread.sleep(50);  // Czekamy 50 ms
        assertEquals(elapsedTime, stopwatch.getElapsedTime(), "Czas nie powinien się zmieniać po zatrzymaniu.");
        assertFalse(stopwatch.running, "Stoper powinien być zatrzymany po wywołaniu stop().");
    }

    @Test
    public void testReset() throws InterruptedException {
        stopwatch.start();
        Thread.sleep(100);  // Czekamy 100 ms
        stopwatch.stop();
        stopwatch.reset();
        assertFalse(stopwatch.running, "Stoper powinien być zatrzymany po resecie.");
        assertEquals(0, stopwatch.getElapsedTime(), "Czas powinien wynosić 0 po resecie.");
    }

    @Test
    public void testGetElapsedTimeWhileRunning() throws InterruptedException {
        stopwatch.start();
        Thread.sleep(200);  // Czekamy 200 ms
        long elapsedTime = stopwatch.getElapsedTime();
        assertTrue(elapsedTime >= 200, "Czas powinien wynosić co najmniej 200 ms podczas działania.");
    }
}
