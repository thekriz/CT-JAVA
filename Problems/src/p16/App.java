package p16;

import java.util.Scanner;

public class App {
    public void process() {
        Scanner scanner = null;
        int age = 0;
        int limitAge = 0;
        String resultMessage = null;
        
        scanner = new Scanner(System.in);
        age = inputValue(scanner, "What is your age? ");
        scanner.close();
        if(age == -1) {
            System.out.println("This value is not valid.");
            System.exit(-1);
        }
        
        limitAge = 16;
        resultMessage = (age >= limitAge) ? "You are enough to legally drive" :
                                            "You are not old enough to legally drive";
        
        System.out.println(resultMessage);
    }
    
    public int inputValue(Scanner scanner, String message) {
        String textValue = null;
        int value = 0;
        
        System.out.print(message);
        textValue = scanner.nextLine();
        
        try {
            value = Integer.valueOf(textValue);
            if(value < 0) {
                value = -1;
            }
        } catch (NumberFormatException e) {
            value = -1;
        }
        
        return value;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
