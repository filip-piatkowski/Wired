package org.wired;

import java.util.ArrayList;
import java.util.List;

public class TimeRecordManager {
    private final List<TimeRecord> records;

    public TimeRecordManager() {
        this.records = new ArrayList<>();
    }

    public void addRecord(long timeMillis, String formattedTime) {
        records.add(new TimeRecord(timeMillis, formattedTime));
    }

    public List<TimeRecord> getRecords() {
        return new ArrayList<>(records); // Zwracamy kopię listy, aby zachować enkapsulację.
    }

    public void cleanRecords() {
        records.clear();
    }
}
