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
        double principal = 0;
        double rateOfInterest = 0;
        double numberOfYears = 0;
        double earnings = 0;
        
        scanner = new Scanner(System.in);
        
        principal = inputValue(scanner, "Enter the principal: ");
        rateOfInterest = inputValue(scanner, "Enter the rate of interset: ");
        numberOfYears = inputValue(scanner, "Enter the number of years: ");
        
        scanner.close();
        
        //earnings = calculateSimpleInterest(principal, rateOfInterest, numberOfYears);
        //printResult(numberOfYears, rateOfInterest, earnings);
        
        printResult2(principal, numberOfYears, rateOfInterest);
    }

    public double inputValue(Scanner scanner, String message) {
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
            
        } while (!isValid);
        
        return value;
    }
    
    public double calculateSimpleInterest(double principal, double rateOfInterest, double numberOfYears) {
        return principal * (1 + ((rateOfInterest / 100) * numberOfYears));
    }
    
    public void printResult(double numberOfYears, double rateOfInterest, double earnings) {
        DecimalFormat decimalFormat = null;
        
        decimalFormat = new DecimalFormat("#.##");
        
        System.out.println("After " + decimalFormat.format(numberOfYears) 
                        + " years at " + decimalFormat.format(rateOfInterest) 
                        + "%, the investment will be worth $" + decimalFormat.format(Math.round(earnings*100)/100.0));
    }
    
    public void printResult2(double principal, double numberOfYears, double rateOfInterest) {
        double earnings = 0;
        DecimalFormat decimalFormat = null;
        
        decimalFormat = new DecimalFormat("#.##");
        for(int count = 0; count <= numberOfYears; count++) {
            earnings = calculateSimpleInterest(principal, rateOfInterest, count);
            System.out.println("After " + String.valueOf(count)
                            + " years at: $" + decimalFormat.format(Math.round(earnings*100)/100.0));
        }
    }
}
