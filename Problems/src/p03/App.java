package p03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = null;

        app = new App();
        app.process();
    }

    public void process() {
        String quote = null;
        String who = null;
        Scanner scanner = null;

        scanner = new Scanner(System.in);
        quote = inputQuote(scanner);
        who = inputWho(scanner);
        scanner.close();

        printString(quote, who);
    }

    public String inputQuote(Scanner scanner) {
        String quote = null;
        System.out.print("What is the quote? ");
        quote = scanner.nextLine();
        return quote;
    }

    public String inputWho(Scanner scanner) {
        String who = null;
        System.out.print("Who said it? ");
        who = scanner.nextLine();
        return who;
    }

    public void printString(String quote, String who) {
        System.out.println(who + " says, \"" + quote + ".\"");
    }

}