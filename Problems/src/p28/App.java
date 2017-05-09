package p28;

import java.util.Scanner;

public class App {
    public static final int NUMBER = 5;
    
    public void process() {
        int total = 0;
        int value = 0;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        for (int i = 0; i < NUMBER; i++) {
            value = inputValue(scanner);
            total += value;
        }
        scanner.close();
        
        System.out.println("The total is "+total+".");
    }
    
    private int inputValue(Scanner scanner) {
        String textValue = "";
        int value = 0;

        System.out.print("Enter a number: ");
        textValue = scanner.nextLine();
        try {
            value = Integer.parseInt(textValue);
        } catch (NumberFormatException e) {
            System.out.println("Rejected.");
            value = 0;
        }
        
        return value;
    }
    
    public static void main(String args[]) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
