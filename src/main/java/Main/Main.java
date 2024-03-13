package Main;

import BusinessLogic.Controller;
import BusinessLogic.Simulare;
import GUI.ViewDate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caz = scanner.nextInt();
        scanner.close();
        switch (caz) {
            case 1 -> {
                Simulare s = new Simulare(4, 2, 60, 2, 30, 2, 4);
                Thread t = new Thread(s);
                t.start();
                break;
            }
            case 2 -> {
                Simulare s = new Simulare(50, 5, 60, 2, 40, 1, 7);
                Thread t = new Thread(s);
                t.start();
                break;
            }
            case 3 -> {
                Simulare s = new Simulare(1000, 20, 200, 10, 100, 3, 9);
                Thread t = new Thread(s);
                t.start();
                break;
            }
            default -> {
                ViewDate viewDate = new ViewDate();
                Controller c = new Controller(viewDate);
            }
        }
    }

}
