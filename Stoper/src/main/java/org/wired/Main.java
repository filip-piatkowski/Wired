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
//TODO
// 1. Dodać możliwość kontynuowania pomiaru i zapisania miedzyczasów.