package p17;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    
    public void process() {
        double weight = 0;
        boolean sex = true; // male=true, female=false
        double amount = 0;
        double content = 0;
        double hour = 0;
        double totalAmount = 0;
        double coefficient = 0;
        double bac = 0;
        double driveLimit = 0;
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        
        scanner = new Scanner(System.in);
        weight = inputDouble(scanner, "What is your weight?(lb) ");
        sex = inputSex(scanner, "What is your sex?(m/f) ");
        amount = inputDouble(scanner, "What is amount you drank?(oz) ");
        content = inputDouble(scanner, "What is Alcohol contents you drank?(%) ");
        hour = inputDouble(scanner, "How long hours you drank? ");
        scanner.close();
        
        totalAmount = amount * content;
        coefficient = (sex) ? 0.73 : 0.6;
        bac = ((totalAmount * 5.14) / (weight * coefficient)) - 0.015 * hour;
        
        driveLimit = 0.08;
        
        decimalFormat = new DecimalFormat("0.##");
        System.out.println("Your BAC is "+decimalFormat.format(bac));
        if(bac > driveLimit) {
            System.out.println("It is not legal for you drive.");
        } else {
            System.out.println("It is legal for you drive.");
        }
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
                System.out.println("This valud is not valid.");
            }
        } while(!isValid);
        
        return value;
    }
    
    public boolean inputSex(Scanner scanner, String message) {
        String textValue = null;
        boolean value = true;
        boolean isValid = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            textValue = textValue.toLowerCase();
            if(textValue.equals("m")) {
                value = true;
                isValid = true;
            } else if(textValue.equals("f")) {
                value = false;
                isValid = true;
            } else { 
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
