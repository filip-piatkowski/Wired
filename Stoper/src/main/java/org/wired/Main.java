package org.wired;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.printf("Stoper uruchomiony. Dostępne komedy: start, stop, reset, exit. ");

        while (true) {
            System.out.printf("Wpisz komendę:  ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "start":
                    stopwatch.start();
                    System.out.printf("Stoper uruchomiony");
                    break;
                case "stop":
                    stopwatch.stop();
                    System.out.printf("Stoper zatrzymany. Czas: " + stopwatch.getElapsedTime() + " ms ");
                    break;
                case "reset":
                    stopwatch.reset();
                    System.out.printf("Stoper zresetowany");
                    break;
                case "exit":
                    System.out.printf("Zamykanie programu.");
                    scanner.close();
                    return;
                default:
                    System.out.printf("Nieznana komenda. Spróbuj ponownie.");
            }
        }
    }
}
//TODO
// 1.Dodanie wyniku na żywo.
// 2. Czas pokazany w odpowieniej formie (czyli odpowiednio sekundy, minuty itd.).
// 3. Stworzenie jakiegoś popup'u zamiast pracy w terminalu.