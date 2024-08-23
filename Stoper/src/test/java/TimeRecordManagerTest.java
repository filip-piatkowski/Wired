import org.junit.Before;
import org.junit.Test;
import org.wired.TimeRecord;
import org.wired.TimeRecordManager;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TimeRecordManagerTest {
    private TimeRecordManager recordManager;

    @Before
    public void setUp() {
        recordManager = new TimeRecordManager();
    }

    @Test
    public void testAddRecord() {
        recordManager.addRecord(1000, "00:00:01.000");
        List<TimeRecord> records = recordManager.getRecords();
        assertEquals(String.valueOf(1), records.size(), 1);
        assertEquals("00:00:01.000", records.get(0).getFormattedTime());
    }

    @Test
    public void testClearRecords() {
        recordManager.addRecord(1000, "00:00:01.000");
        recordManager.cleanRecords();
        List<TimeRecord> records = recordManager.getRecords();
        assertEquals(String.valueOf(0), records.size(), 0);
    }
}