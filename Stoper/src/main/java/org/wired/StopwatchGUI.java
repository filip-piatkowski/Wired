package org.wired;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopwatchGUI {
    private final Stopwatch stopwatch;
    private TimeRecordManager recordManager;
    private JFrame frame;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JButton saveButton;
    private JButton clearTableButton;
    private JTable timesTable;
    private DefaultTableModel tableModel;
    private final JLabel timeLabel;
    private final Timer timer;

    public StopwatchGUI() {
        stopwatch = new Stopwatch();
        recordManager = new TimeRecordManager();
        JFrame frame = new JFrame("Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);
        frame.setLayout(new BorderLayout());

        // Etykieta do wyświetlania czasów.
        timeLabel = new JLabel("00:00:00.000", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(timeLabel, BorderLayout.NORTH);

        // Panele przycisków
        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton resetButton = new JButton("Reset");
        JButton saveTimeButton = new JButton("Save Time");
        JButton clearTableButton = new JButton("Clean Table");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(saveTimeButton);
        buttonPanel.add(clearTableButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        //Tabela dla zapisanych czasów.
        String[] columnNames = {"Saved Times"};
        tableModel = new DefaultTableModel(columnNames, 0);
        timesTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(timesTable);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Detektory akcji dla przycisków.
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

        saveTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTime();
            }
        });

        clearTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTable();
            }
        });

        // Timer do aktualizacji wyświetlanego zcasu
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

    private void saveTime() {
        long elapsedTime = stopwatch.getElapsedTime();
        String formattedTime = formatTime(elapsedTime);
        recordManager.addRecord(elapsedTime, formattedTime);
        tableModel.addRow(new Object[]{formattedTime});
    }

    private void clearTable() {
        recordManager.cleanRecords();
        tableModel.setRowCount(0);
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