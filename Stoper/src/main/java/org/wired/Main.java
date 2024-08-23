package org.wired;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
     // Uruchomienie interfejsu
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StopwatchGUI();
            }
        });
    }
}