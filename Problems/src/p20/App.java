package p20;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    
    public void process() {
        float amount = 0.0f;
        String state = null;
        String county = null;
        float stateTax = 0.0f;
        float countyTax = 0.0f;
        float totalTax = 0.0f;
        float total = 0.0f;
        String result = "";
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        
        scanner = new Scanner(System.in);
        decimalFormat = new DecimalFormat("0.00");
        
        amount = inputFloat(scanner, "What is the order amount? ");
        total += amount;
        
        state = inputString(scanner, "What state do you live in? ");
        if (state.equals("wisconsin")) {
            stateTax = amount * 0.055f;
            result += "The state tax is $" + decimalFormat.format(stateTax) + "." + System.lineSeparator();
            county = inputString(scanner, "What county do you live in? ");
            if (county.equals("eau claire")) {
                countyTax = 0.05f;
                result += "The county tax is $" + decimalFormat.format(countyTax) + "." + System.lineSeparator();
            } else if (county.equals("dunn")) {
                countyTax = 0.04f;
                result += "The county tax is $" + decimalFormat.format(countyTax) + "." + System.lineSeparator();
            } else {
                // do nothing.
            }
            totalTax = stateTax + countyTax;
            result += "The total tax is $" + decimalFormat.format(totalTax) + "." + System.lineSeparator();
        } else if (state.equals("illinois")) {
            stateTax = amount * 0.08f;
            result += "The state tax is $" + decimalFormat.format(stateTax) + "." + System.lineSeparator();
            
            totalTax += stateTax;
            result += "The total tax is $" + decimalFormat.format(totalTax) + "." + System.lineSeparator();
        } else {
            // do nothing.
        }
        scanner.close();

        total = amount + totalTax;
        result += "The total is $" + decimalFormat.format(total) + "." + System.lineSeparator();
        System.out.println(result);
    }
    
    private String inputString(Scanner scanner, String message) {
        String textValue = "";
        String value = "";
        
        System.out.print(message);
        textValue = scanner.nextLine();
        value = textValue.toLowerCase();
        
        return value;
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
                System.out.println("This value is not valid");
                continue;
            }
        } while (true);
        
        return value;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
