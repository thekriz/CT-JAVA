package p20;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public void process() {
        double amount = 0;
        String state = null;
        String county = null;
        double stateTax = 0;
        double countyTax = 0;
        double totalTax = 0;
        double total = 0;
        String result = "";
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        
        scanner = new Scanner(System.in);
        decimalFormat = new DecimalFormat("0.00");
        amount = inputDouble(scanner, "What is the order amount? ");
        total += amount;
        state = inputString(scanner, "What state do you live in? ");
        if(state.equals("wisconsin")) {
            stateTax = amount * 0.055;
            result += "The state tax is $" + decimalFormat.format(stateTax) + "." + System.lineSeparator();
            county = inputString(scanner, "What county do you live in? ");
            if(county.equals("eau claire")) {
                countyTax = 0.05;
                result += "The county tax is $" + decimalFormat.format(countyTax) + "." + System.lineSeparator();
            } else if (county.equals("dunn")) {
                countyTax = 0.04;
                result += "The county tax is $" + decimalFormat.format(countyTax) + "." + System.lineSeparator();
            } else {
                // do nothing.
            }
            totalTax = stateTax + countyTax;
            result += "The total tax is $" + decimalFormat.format(totalTax) + "." + System.lineSeparator();
        } else if(state.equals("illinois")) {
            stateTax = amount * 0.08;
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
    
    public String inputString(Scanner scanner, String message) {
        String textValue = null;
        String value = null;
        
        System.out.print(message);
        textValue = scanner.nextLine();
        value = textValue.toLowerCase();
        
        return value;
    }
    
    public double inputDouble(Scanner scanner, String message) {
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
                System.out.println("This value is not valid");
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
