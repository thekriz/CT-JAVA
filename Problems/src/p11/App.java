package p11;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static final double RATE_TO = 100;
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        double amountTo = 0;
        double amountFrom = 0;
        double rateFrom = 0;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        
        amountFrom = inputValue(scanner, "How many Euros are you exchanging? ");
        rateFrom = inputValue(scanner, "What is the exchange rate? ");
        
        scanner.close();
        
        amountTo = calculateAmountTo(amountFrom, rateFrom, RATE_TO);
        printResult(amountFrom, rateFrom, amountTo);
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
    
    public double calculateAmountTo(double amountFrom, double rateFrom, double rateTo) {
        return (amountFrom * rateFrom) / rateTo;
    }
    
    public void printResult (double amountFrom, double rateFrom, double amountTo) {
        DecimalFormat decimalFormat = null;
        
        decimalFormat = new DecimalFormat("#.##");
        System.out.println(decimalFormat.format(amountFrom) + " Euros at an exchange rate of "
                        + decimalFormat.format(rateFrom) + " is " 
                        + decimalFormat.format((Math.round(amountTo * 100)) / 100.0) + " dollars");
    }

}
