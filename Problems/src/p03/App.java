package p03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        String quote = "";
        String who = "";
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        quote = inputWord(scanner, "Who is the quote? ");
        who = inputWord(scanner, "Who said it? ");
        scanner.close();
        
        printString(quote, who);
    }
    
    private String inputWord(Scanner scanner, String message) {
        String textValue = "";
        
        System.out.print(message);
        textValue = scanner.nextLine();
        
        return textValue;
    }
    
    private void printString(String quote, String who) {
        System.out.println(who + " says, \"" + quote + ".\"");
    }
}
