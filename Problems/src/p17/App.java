package p17;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    
    private void process() {
        float weight = 0.0f;
        boolean sex = true; // male=true, female=false
        float amount = 0.0f;
        float content = 0.0f;
        float hour = 0.0f;
        float totalAmount = 0.0f;
        float coefficient = 0.0f;
        float bac = 0.0f;
        float driveLimit = 0.0f;
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        
        scanner = new Scanner(System.in);
        weight = inputFloat(scanner, "What is your weight?(lb) ");
        sex = inputSex(scanner, "What is your sex?(m/f) ");
        amount = inputFloat(scanner, "What is amount you drank?(oz) ");
        content = inputFloat(scanner, "What is Alcohol contents you drank?(%) ");
        hour = inputFloat(scanner, "How long hours you drank? ");
        scanner.close();
        
        totalAmount = amount * content;
        coefficient = (sex) ? 0.73f : 0.6f;
        bac = ((totalAmount * 5.14f) / (weight * coefficient)) - 0.015f * hour;
        
        driveLimit = 0.08f;
        
        decimalFormat = new DecimalFormat("0.##");
        System.out.println("Your BAC is " + decimalFormat.format(bac));
        if (bac > driveLimit) {
            System.out.println("It is not legal for you drive.");
        } else {
            System.out.println("It is legal for you drive.");
        }
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
                System.out.println("This valud is not valid.");
                continue;
            }
        } while (true);
        
        return value;
    }
    
    private boolean inputSex(Scanner scanner, String message) {
        String textValue = "";
        boolean value = true;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            textValue = textValue.toLowerCase();
            if (textValue.equals("m")) {
                value = true;
                break;
            } else if (textValue.equals("f")) {
                value = false;
                break;
            } else { 
                System.out.println("This value is not valid.");
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
