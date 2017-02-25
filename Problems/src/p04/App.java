package p04;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = null;

        app = new App();
        app.process();
    }

    public void process() {
        String noun = null;
        String verb = null;
        String adjective = null;
        String adverb = null;
        Scanner scanner = null;

        scanner = new Scanner(System.in);

        noun = inputNoun(scanner);
        verb = inputVerb(scanner);
        adjective = inputAdjective(scanner);
        adverb = inputAdverb(scanner);

        scanner.close();
        printString(noun, verb, adjective, adverb);
    }

    public String inputNoun(Scanner scanner) {
        String noun = null;

        System.out.print("Enter a noun: ");
        noun = scanner.nextLine();

        return noun;
    }

    public String inputVerb(Scanner scanner) {
        String verb = null;

        System.out.print("Enter a verb: ");
        verb = scanner.nextLine();

        return verb;
    }

    public String inputAdjective(Scanner scanner) {
        String adjective = null;

        System.out.print("Enter an adjective: ");
        adjective = scanner.nextLine();

        return adjective;
    }

    public String inputAdverb(Scanner scanner) {
        String adverb = null;

        System.out.print("Enter an adverb: ");
        adverb = scanner.nextLine();

        return adverb;
    }

    public void printString(String noun, String verb, String adjective, String adverb) {
        System.out.println(String.format("Do you %s your %s %s %s? That's hilarious!", verb, adjective, noun, adverb));
    }

}
