package p11;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public static final float RATE_TO = 100;
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        float amountTo = 0.0f;
        float amountFrom = 0.0f;
        float rateFrom = 0.0f;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        amountFrom = inputValue(scanner, "How many Euros are you exchanging? ");
        rateFrom = inputValue(scanner, "What is the exchange rate? ");
        scanner.close();
        
        amountTo = calculateAmountTo(amountFrom, rateFrom, RATE_TO);
        printResult(amountFrom, rateFrom, amountTo);
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
    
    private float calculateAmountTo(float amountFrom, float rateFrom, float rateTo) {
        return (amountFrom * rateFrom) / rateTo;
    }
    
    private void printResult (float amountFrom, float rateFrom, float amountTo) {
        DecimalFormat decimalFormat = null;
        
        decimalFormat = new DecimalFormat("#.##");
        System.out.println(decimalFormat.format(amountFrom) + " Euros at an exchange rate of "
                        + decimalFormat.format(rateFrom) + " is " 
                        + decimalFormat.format((Math.round(amountTo * 100)) / 100.0) + " dollars");
    }

}
