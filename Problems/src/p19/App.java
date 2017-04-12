package p19;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public void process() {
        double height = 0;
        double weight = 0;
        double bmi = 0;
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        
        scanner = new Scanner(System.in);
        height = inputDouble(scanner, "What is your height?(in) ");
        weight = inputDouble(scanner, "What is your weight?(lb) ");
        scanner.close();
        
        bmi = (weight / (height * height)) * 703;
        
        decimalFormat = new DecimalFormat("0.0");
        System.out.println("Your BMI is "+decimalFormat.format(bmi));
        if (bmi <= 18.5) {
            System.out.println("You are underweight. You should see your doctor.");
        } else if (bmi >= 25) {
            System.out.println("You are overweight. You should see your doctor.");
        } else {
            System.out.println("You are within the ideal weight range.");
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
