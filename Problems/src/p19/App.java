package p19;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    
    public void process() {
        float height = 0.0f;
        float weight = 0.0f;
        float bmi = 0.0f;
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        
        scanner = new Scanner(System.in);
        height = inputFloat(scanner, "What is your height?(in) ");
        weight = inputFloat(scanner, "What is your weight?(lb) ");
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
    
    private float inputFloat(Scanner scanner, String message) {
        String textValue = "";
        float value = 0.0f;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            
            try {
                value = Float.parseFloat(textValue);
                break;
            } catch(NumberFormatException e) {
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
