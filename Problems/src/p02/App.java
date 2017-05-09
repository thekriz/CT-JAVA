package p02;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        String string = "";
        
        string = inputString();
        printResult(string);
    }
    
    private String inputString() {
        String name = "";
        Scanner scanner = null;
        boolean valid = false;
        
        scanner = new Scanner(System.in);
        do {
            System.out.print("What is the input string? ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Input Text");
                continue;
            }
            valid = true;
        } while (!valid);
        scanner.close();
        
        return name;
    }
    
    private void printResult(String string) {
        System.out.println(string + " has " + string.length() + " characters.");
    }
}
