package p10;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public static final float TAX_RATE = 0.055f;
    public static final int NUM_OF_ITEMS = 3;
    public static final int END_OF_ITEMS = -1;
    
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
        float subTotal = 0.0f;
        float tax = 0.0f;
        float total = 0.0f;
        
        scanner = new Scanner(System.in);
        count = 1;
        while (count <= NUM_OF_ITEMS) {
            item = inputValue(scanner, "Price of item " + count + ": ");
            if (item == END_OF_ITEMS) {
                break;
            }
            quantity = inputValue(scanner, "Quantity of item " + count + ": ");
            subTotal = subTotal + (item * quantity);
            count = count + 1;
        }
        scanner.close();
        
        tax = subTotal * TAX_RATE;
        total = subTotal + tax;
        
        printResult(subTotal, tax, total);
    }
    
    private int inputValue(Scanner scanner, String message) {
        String textValue = "";
        int value = 0;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            try {
                value = Integer.parseInt(textValue);
                break;
            } catch (NumberFormatException e) {
                if (textValue.equals("")) {
                    value = END_OF_ITEMS;
                    break;
                }
                System.out.println("This value is not valid");
                continue;
            }
        } while (true);
        
        return value;
    }
    
    private void printResult(float subTotal, float tax, float total) {
        DecimalFormat decimalFormat  = null;
        
        decimalFormat = new DecimalFormat(".00");
        System.out.println("Subtotal: $" + decimalFormat.format(Math.round(subTotal * 100) / 100.0f));
        System.out.println("Tax: $" + decimalFormat.format(Math.round(tax * 100) / 100.0f));
        System.out.println("Total: $" + decimalFormat.format(Math.round(total*100) / 100.0f));
    }

}
