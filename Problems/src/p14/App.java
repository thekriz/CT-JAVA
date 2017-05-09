package p14;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    
    public void process() {
        float amount = 0.0f;
        String state = "";
        float tax = 0.0f;
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        String resultMessage = "";
        
        scanner = new Scanner(System.in);
        amount = inputFloat(scanner, "What is the order amount? ");
        state = inputString(scanner, "What is the state? ");
        scanner.close();
        
        tax = amount * 0.055f;
        state = state.toLowerCase();
        decimalFormat = new DecimalFormat("0.00");
        resultMessage = "";
        if (state.equals("wi")) {
            resultMessage += "The subtotal is $" + decimalFormat.format(amount) + System.lineSeparator();
            resultMessage += "The tax is $" + decimalFormat.format(tax) + System.lineSeparator();
        }
        resultMessage += "The total is $"+decimalFormat.format(amount+tax) + System.lineSeparator();
        
        System.out.println(resultMessage);
    }
    
    private float inputFloat(Scanner scanner, String message) {
        String textValue = "";
        float value = 0.0f;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            try {
                value = Float.parseFloat(textValue);
                break;
            } catch (NumberFormatException e) {
                System.out.println("This value is not valid.");
                continue;
            }
        } while (true);
        
        return value;
    }
    
    private String inputString(Scanner scanner, String message) {
        String textValue = "";
        
        System.out.print(message);
        textValue = scanner.nextLine();
        
        return textValue;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }

}
