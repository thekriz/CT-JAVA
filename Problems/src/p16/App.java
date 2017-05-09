package p16;

import java.util.Scanner;

public class App {
    public static final int INVALID_AGE = -1;
    
    public void process() {
        Scanner scanner = null;
        int age = 0;
        int limitAge = 0;
        String resultMessage = "";
        
        scanner = new Scanner(System.in);
        age = inputValue(scanner, "What is your age? ");
        scanner.close();
        
        limitAge = 16;
        if (age == INVALID_AGE) {
            System.out.println("This value is not valid.");
            System.exit(-1);
        }
        resultMessage = (age >= limitAge) ? "You are enough to legally drive" :
                                            "You are not old enough to legally drive";
        
        System.out.println(resultMessage);
    }
    
    private int inputValue(Scanner scanner, String message) {
        String textValue = "";
        int value = 0;
        
        System.out.print(message);
        textValue = scanner.nextLine();
        
        try {
            value = Integer.parseInt(textValue);
            if (value < 0) {
                value = INVALID_AGE;
            }
        } catch (NumberFormatException e) {
            value = INVALID_AGE;
        }
        
        return value;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
