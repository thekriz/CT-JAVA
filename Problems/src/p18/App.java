package p18;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    
    public void process() {
        String toType = null;
        String fromType = null;
        float temperature = 0;
        float result = 0;
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        
        scanner = new Scanner(System.in);
        toType = inputType(scanner);
        fromType = (toType.equals("Celsius")) ? "Fahrenheit" : "Celsius";
        System.out.println("");
        temperature = inputFloat(scanner, "Please enter the temperature in " + fromType + ": ");
        scanner.close();
        
        if (toType.equals("Celsius")) {
            result = convertFtoC(temperature);
        } else {
            result = convertCtoF(temperature);
        }
        
        decimalFormat = new DecimalFormat("#.##");
        System.out.println("The temperature in " + toType + " is " + decimalFormat.format(result) + ".");
    }
    
    private String inputType(Scanner scanner) {
        String textValue = "";
        String value = "";

        System.out.println("Press C to convert from Fahrenheit to Celsius." + System.lineSeparator()
        + "Press F to convert from Celsius to Fahrentheit." );
        do {
            System.out.print("Your choice: ");
            textValue = scanner.nextLine();
            textValue = textValue.toLowerCase();
            if (textValue.equals("c")) {
                value = "Celsius";
                break;
            } else if (textValue.equals("f")) {
                value = "Fahrenheit";
                break;
            } else {
                System.out.println("This value is not valid.");
                continue;
            }
        } while (true);
        
        return value;
    }
    
    private float inputFloat(Scanner scanner, String message) {
        String textValue = "";
        float value = 0;
        
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
    
    private float convertCtoF(float celsius) {
        return celsius * (9.0f / 5.0f) + 32;
    }
    
    private float convertFtoC(float fahrenheit) {
        return (fahrenheit - 32) * (9.0f / 5.0f);
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
