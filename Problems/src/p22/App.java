package p22;

import java.util.Scanner;

public class App {

    public void process() {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int max = 0;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        num1 = inputValue(scanner, "Enter the first number: ");
        num2 = inputValue(scanner, "Enter the second number: ");
        num3 = inputValue(scanner, "Enter the third number: ");
        scanner.close();
        
        if((num1 == num2) || (num2 == num3) || (num1 == num3)) {
            System.exit(-1);
        } else {
            if(num1 >= max) {
                max = num1;
            }
            if(num2 >= max) {
                max = num2;
            }
            if(num3 >= max) {
                max = num3;
            }
        }
        
        System.out.println("The largest number is " + max);
    }
    
    public int inputValue(Scanner scanner, String message) {
        String textValue = null;
        int value = 0;
        boolean isValid = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            try {
                value = Integer.valueOf(textValue);
                isValid = true;
            } catch(NumberFormatException e) {
                System.out.println("This value is not valid.");
            }
        } while(!isValid);
        
        return value;
    }

    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }

}
