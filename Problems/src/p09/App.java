package p09;

import java.util.Scanner;

public class App {
    public static final float SQUARE_PER_PAINT = 9.0f;
    
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
                System.out.println("This value is not valid");
                continue;
            }
        } while (true);
        
        return value;
    }
    
    private int calculateNumOfPaint(int width, int length) {
        return (int)Math.ceil((width * length) / SQUARE_PER_PAINT);
    }
    
    private void printResult(int width, int length, int paint) {
        System.out.println("You will need to purchase " + paint + " liters of" +
                            " paint to cover " + (width * length) + " meters.");
    }

}
