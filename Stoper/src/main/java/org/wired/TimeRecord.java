package org.wired;

public class TimeRecord {
    private long timeMillis;
    private String formattedTime;

    public TimeRecord(long timeMillis, String formattedTime) {
        this.timeMillis = timeMillis;
        this.formattedTime = formattedTime;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    @Override
    public String toString() {
        return formattedTime;
    }
}