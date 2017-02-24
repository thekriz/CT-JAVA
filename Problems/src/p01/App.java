package p01;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = null;

        app = new App();
        app.process();
    }

    public void process() {
        // String name = null;
        // String string = null;

        // name = inputName();
        // string = concatenate(name);
        // printString(string);

        // Challenge1
        printString(concatenate(inputName()));
    }

    public String inputName() {
        String name = null;
        Scanner scanner = null;

        scanner = new Scanner(System.in);
        System.out.print("What is your name? ");
        name = scanner.nextLine();
        scanner.close();

        return name;
    }

    public String concatenate(String name) {
        return "Hello, " + name + ", nice to meet you!";
    }

    public void printString(String string) {
        System.out.println(string);
    }
}
