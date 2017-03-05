package p10;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static final double TAX_RATE = 0.055;
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        Scanner scanner = null;
        int count = 0;
        int item = 0;
        int quantity = 0;
        double subTotal = 0;
        double tax = 0;
        double total = 0;
        
        scanner = new Scanner(System.in);

        count = 1;
        while(count <= 3 /*true*/) {
            item = inputValue(scanner, "Price of item " + String.valueOf(count) + ": ");
            if(item == -1) {
                break;
            }
            quantity = inputValue(scanner, "Quantity of item " + String.valueOf(count) + ": ");
            subTotal = subTotal + (item * quantity);
            count = count + 1;
        }
        tax = subTotal * TAX_RATE;
        total = subTotal + tax;
        
        printResult(subTotal, tax, total);
        
        scanner.close();
    }
    
    public int inputValue(Scanner scanner, String message) {
        String textValue = null;
        int value = 0;
        boolean isValid = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            try {
                value = Integer.valueOf(textValue);
                isValid = true;
            } catch (NumberFormatException e) {
                if(textValue.equals("")) {
                    return -1;
                }
                System.out.println("This value is not valid");
            }
        } while(!isValid);
        
        return value;
    }
    
    public void printResult(double subTotal, double tax, double total) {
        DecimalFormat decimalFormat  = null;
        
        decimalFormat = new DecimalFormat(".00");
        
        System.out.println("Subtotal: $" + decimalFormat.format(Math.round(subTotal * 100) / 100.0));
        System.out.println("Tax: $" + decimalFormat.format(Math.round(tax * 100) / 100.0));
        System.out.println("Total: $" + decimalFormat.format(Math.round(total*100) / 100.0));
    }

}
