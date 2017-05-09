package p29;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    
    public void process() {
        float rate = 0.0f;
        float years = 0.0f;
        DecimalFormat decimalFormat = null;
        
        rate = inputValue();
        years = calculateYears(rate);
        
        decimalFormat = new DecimalFormat("#.##");
        System.out.println("It will take " + decimalFormat.format(years) + " years to double your initial investment.");
    }
    
    private float inputValue() {
        float value = 0.0f;
        String textValue = "";
        boolean valid = false;
        Scanner scanner = null;

        scanner = new Scanner(System.in);
        do {
            System.out.print("What is the rate of return? ");
            textValue = scanner.nextLine();
            try {
                value = Float.parseFloat(textValue);
                if (value == 0) {
                    throw new NumberFormatException();
                }
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Sorry. That's not a valid input.");
            }
        } while (!valid);
        scanner.close();
        
        return value;
    }
    
    private float calculateYears(float rate) {
        return 72.0f/rate;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
