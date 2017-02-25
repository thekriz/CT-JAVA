package p02;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = null;

        app = new App();
        app.process();
    }

    public void process() {
        String string = null;
        int length = 0;

        string = inputString();
        length = calculateLength(string);
        printResult(string, length);
    }

    public String inputString() {
        String name = null;
        Scanner scanner = null;

        scanner = new Scanner(System.in);

        System.out.print("What is the input string? ");

        name = scanner.nextLine();

        // Challenge
        while (name.isEmpty()) {
            System.out.println("Input text");
            System.out.print("What is the input string? ");
            name = scanner.nextLine();
        }

        scanner.close();
        return name;
    }

    public int calculateLength(String string) {
        return (string != null) ? string.length() : 0;
    }

    public void printResult(String string, int length) {
        System.out.println(string + " has " + String.valueOf(length) + " characters.");
    }
}