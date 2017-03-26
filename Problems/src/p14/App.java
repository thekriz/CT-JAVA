package p14;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public void process() {
        double amount = 0;
        String state = null;
        double tax = 0;
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        String result = null;
        
        scanner = new Scanner(System.in);
        amount = inputDouble(scanner, "What is the order amount? ");
        state = inputString(scanner, "What is the state? ");
        scanner.close();
        
        tax = amount * 0.055;
        
        state = state.toLowerCase();
        decimalFormat = new DecimalFormat("0.00");
        result = "";
        if(state.equals("wi")) {
            result += "The subtotal is $" + decimalFormat.format(amount) + System.lineSeparator();
            result += "The tax is $" + decimalFormat.format(tax) + System.lineSeparator();
        }
        result += "The total is $"+decimalFormat.format(amount+tax) + System.lineSeparator();
        System.out.println(result);
    }
    
    public Double inputDouble(Scanner scanner, String message) {
        String textValue = null;
        double value = 0;
        boolean isValid = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            try {
                value = Double.valueOf(textValue);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("This value is not valid.");
            }
        } while (!isValid);
        
        return value;
    }
    
    public String inputString(Scanner scanner, String message) {
        String textValue = null;
        boolean isValid = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            isValid = true;
        } while(!isValid);
        
        return textValue;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }

}
