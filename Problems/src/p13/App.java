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
        float principal = 0.0f;
        float rate = 0.0f;
        float numberOfYears = 0.0f;
        float compoundedPerYear = 0.0f;
        float earnings = 0.0f;
        
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
                System.out.println("This value is not valid");
                continue;
            }
        } while (true);
        
        return value;
    }
    
    private float calculate(float principle, float rate, float numberOfYears, float compoundedYear) {
        return principle * (float)Math.pow(1 + ((rate / 100.0f) / compoundedYear), numberOfYears * compoundedYear);
    }
    
    private void printResult(float principle, float rate, float numberOfYears, float compoundedPerYear, float earnings) {
        DecimalFormat decimalFormat = null;
        
        decimalFormat = new DecimalFormat("#.##");
        System.out.println("$" + decimalFormat.format(principle) + " invested at "
                        + decimalFormat.format(rate) + "% for " + decimalFormat.format(numberOfYears)
                        + " years compounded " + decimalFormat.format(compoundedPerYear) + " times per year is $"
                        + decimalFormat.format(earnings));
    }

}
