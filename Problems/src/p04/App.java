package p04;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        String noun = "";
        String verb = "";
        String adjective = "";
        String adverb = "";
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        noun = inputWord(scanner, "Enter a noun: ");
        verb = inputWord(scanner, "Enter a verb: ");
        adjective = inputWord(scanner, "Enter an adjective: ");
        adverb = inputWord(scanner, "Enter an adverb: ");
        scanner.close();
        
        printString(noun, verb, adjective, adverb);
    }
    
    private String inputWord(Scanner scanner, String message) {
        String value = "";
        
        System.out.print(message);
        value = scanner.nextLine();
        
        return value;
    }
    
    private void printString(String noun, String verb, String adjective, String adverb) {
        System.out.println(String.format("Do you %s your %s %s %s? That's hilarious!", verb, adjective, noun, adverb));
    }
}
