import org.junit.Test;
import org.wired.Stopwatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StopwatchTest {

    @Test
    public void testStartStop() throws InterruptedException {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        Thread.sleep(1000); // symulacja jednej sekundy
        stopwatch.stop();
        long elapsedTime = stopwatch.getElapsedTime();
        assertTrue(elapsedTime >= 1000 && elapsedTime < 1100);
    }

    @Test
    public void testReset() {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        stopwatch.stop();
        stopwatch.reset();
        assertEquals(0, stopwatch.getElapsedTime());
    }
}
