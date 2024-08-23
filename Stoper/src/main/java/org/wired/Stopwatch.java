package org.wired;

public class Stopwatch {
    private long startTime;
    private long endTime;
    public boolean running;

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
        this.running = false;
    }

    public long getElapsedTime() {
        if (running) {
            return System.currentTimeMillis() - startTime;
        } else {
            return endTime - startTime;
        }
    }

    public void reset () {
        this.startTime = 0;
        this.endTime = 0;
        this.running = false;
    }

    public boolean isRunning() {
        return false;
    }
}