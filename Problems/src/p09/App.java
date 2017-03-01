package p09;

import java.util.Scanner;

public class App {

    public static final double SQUARE_PER_PAINT = 9;
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        Scanner scanner = null;
        int width = 0;
        int length = 0;
        int numberOfPaint = 0;
        
        scanner = new Scanner(System.in);
        
        width = inputValue(scanner, "What is the width of the room in meter? ");
        length = inputValue(scanner, "What is the length of the room in meter? ");
        
        scanner.close();
        
        numberOfPaint = calculateNumOfPaint(width, length);
        printResult(width, length, numberOfPaint);
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
                System.out.println("This value is not invalid");
            }
        } while(!isValid);
        
        return value;
    }
    
    public int calculateNumOfPaint(int width, int length) {
        return (int)Math.ceil((width*length)/SQUARE_PER_PAINT);
    }
    
    public void printResult(int width, int length, int paint) {
        System.out.println("You will need to purchase " + String.valueOf(paint) + " liters of" +
                            " paint to cover " + String.valueOf(width*length) + " meters.");
    }

}
