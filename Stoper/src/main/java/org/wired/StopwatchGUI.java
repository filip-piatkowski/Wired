package org.wired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopwatchGUI {
    private final Stopwatch stopwatch;
    private final JLabel timeLabel;
    private final Timer timer;

    public StopwatchGUI() {
        stopwatch = new Stopwatch();
        JFrame frame = new JFrame("Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLayout(new BorderLayout());

        timeLabel = new JLabel("00:00:00.000", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(timeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton resetButton = new JButton("Reset");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startStopwatch();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopStopwatch();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetStopwatch();
            }
        });

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateElapsedTime();
            }
        });

        frame.setVisible(true);
    }
    private void startStopwatch() {
        stopwatch.start();
        timer.start();
    }

    private void stopStopwatch() {
        stopwatch.stop();
        timer.stop();
    }

    private void resetStopwatch() {
        stopwatch.reset();
        timer.stop();
        timeLabel.setText("00:00:00.000");
    }

    private void updateElapsedTime() {
        long elapsedTime = stopwatch.getElapsedTime();
        timeLabel.setText(formatTime(elapsedTime));
    }

    private String formatTime(long elapsedTime) {
        long hours = elapsedTime / 3600000;
        long minutes = (elapsedTime % 3600000) / 60000;
        long seconds = (elapsedTime % 60000) / 1000;
        long milliseconds = elapsedTime % 1000;
        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
    }
}
