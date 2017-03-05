package p13;

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
        double rate = 0;
        double numberOfYears = 0;
        double compoundedPerYear = 0;
        double earnings = 0;
        
        scanner = new Scanner(System.in);
        
        principal = inputValue(scanner, "What is the principal amount? ");
        rate = inputValue(scanner, "What is the rate: ");
        numberOfYears = inputValue(scanner, "What is the number of years? ");
        compoundedPerYear = inputValue(scanner, "What is the number of times of the interest" + System.lineSeparator()
                                    + "is compounded per year: ");
        
        scanner.close();
        
        earnings = calculate(principal, rate, numberOfYears, compoundedPerYear);
        printResult(principal, rate, numberOfYears, compoundedPerYear, earnings);
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
    
    public double calculate(double principle, double rate, double numberOfYears, double compoundedYear) {
        return principle * Math.pow(1 + ((rate / 100) / compoundedYear), numberOfYears * compoundedYear);
    }
    
    public void printResult(double principle, double rate, double numberOfYears, double compoundedPerYear, double earnings) {
        DecimalFormat decimalFormat = null;
        
        decimalFormat = new DecimalFormat("#.##");
        System.out.println("$" + decimalFormat.format(principle) + " invested at "
                        + decimalFormat.format(rate) + "% for " + decimalFormat.format(numberOfYears)
                        + " years compounded " + decimalFormat.format(compoundedPerYear) + " times per year is $"
                        + decimalFormat.format(earnings));
    }

}
