package p12;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        Scanner scanner = null;
        float principal = 0.0f;
        float rateOfInterest = 0.0f;
        float numberOfYears = 0.0f;
        
        scanner = new Scanner(System.in);
        principal = inputValue(scanner, "Enter the principal: ");
        rateOfInterest = inputValue(scanner, "Enter the rate of interset: ");
        numberOfYears = inputValue(scanner, "Enter the number of years: ");
        scanner.close();
        
        printResult(principal, numberOfYears, rateOfInterest);
    }

    private float inputValue(Scanner scanner, String message) {
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
    
    private float calculateSimpleInterest(float principal, float rateOfInterest, float numberOfYears) {
        return principal * (1 + ((rateOfInterest / 100) * numberOfYears));
    }
/*    
    private void printResult(float numberOfYears, float rateOfInterest, float earnings) {
        DecimalFormat decimalFormat = null;
        
        decimalFormat = new DecimalFormat("#.##");
        System.out.println("After " + decimalFormat.format(numberOfYears) 
                        + " years at " + decimalFormat.format(rateOfInterest) 
                        + "%, the investment will be worth $" + decimalFormat.format(Math.round(earnings*100) / 100.0f));
    }
*/    
    private void printResult(float principal, float numberOfYears, float rateOfInterest) {
        float earnings = 0.0f;
        DecimalFormat decimalFormat = null;
        
        decimalFormat = new DecimalFormat("#.##");
        for (int count = 0; count <= numberOfYears; count++) {
            earnings = calculateSimpleInterest(principal, rateOfInterest, count);
            System.out.println("After " + count
                            + " years at: $" + decimalFormat.format(Math.round(earnings * 100) / 100.0));
        }
    }
}
