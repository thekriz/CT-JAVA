package p18;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    
    public void process() {
        String toType = null;
        String fromType = null;
        double temperature = 0;
        double result = 0;
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        
        scanner = new Scanner(System.in);
        System.out.println("Press C to convert from Fahrenheit to Celsius." + System.lineSeparator()
                            + "Press F to convert from Celsius to Fahrentheit." );
        toType = inputType(scanner, "Your choice: ");
        fromType = (toType.equals("Celsius")) ? "Fahrenheit" : "Celsius";
        System.out.print(System.lineSeparator());
        temperature = inputDouble(scanner, "Please enter the temperature in " + fromType + ": ");
        scanner.close();
        
        if(toType.equals("Celsius")) {
            result = convertFtoC(temperature);
        } else {
            result = convertCtoF(temperature);
        }
        
        decimalFormat = new DecimalFormat("#.##");
        System.out.println("The temperature in " + toType + " is " + decimalFormat.format(result) + ".");
    }
    
    public String inputType(Scanner scanner, String message) {
        String textValue = null;
        String value = null;
        boolean isValid = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            textValue = textValue.toLowerCase();
            if(textValue.equals("c")) {
                value = "Celsius";
                isValid = true;
            } else if(textValue.equals("f")) {
                value = "Fahrenheit";
                isValid = true;
            } else {
                System.out.println("This value is not valid.");
            }
        } while(!isValid);
        
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
                System.out.println("This value is not valid.");
            }
        } while(!isValid);
        
        return value;
    }
    
    public double convertCtoF(double celsius) {
        return celsius * (9.0/5.0) + 32;
    }
    
    public double convertFtoC(double fahrenheit) {
        return (fahrenheit-32) * (9.0/5.0);
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
