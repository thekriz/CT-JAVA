package p07;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public static final float SQUARE_METER_CONSTANT = 0.09290304f;
    public static final boolean TYPE_FEET_TO_METER = true;
    public static final boolean TYPE_METER_TO_FEET = false;
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        float length = 0.0f;
        float width = 0.0f;
        float squareFeet = 0.0f;
        float squareMeter = 0.0f;
        boolean type = false;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        type = inputType(scanner);
        if (type == TYPE_FEET_TO_METER) {
            length = inputFloat(scanner, "What is the length of the room in feet? ");
            width = inputFloat(scanner, "What is the width of the room in feet? ");

            squareFeet = calculateSquareFeet(length, width);
            squareMeter = transformSquareMeter(squareFeet);
        } else {
            length = inputFloat(scanner, "What is the length of the room in meter? ");
            width = inputFloat(scanner, "What is the width of the room in meter? ");

            squareMeter = calculateSquareMeter(length, width);
            squareFeet = transformSquareFeet(squareMeter);
        }
        scanner.close();
        
        printResult(type, length, width, squareFeet, squareMeter);
    }
    
    private float inputFloat(Scanner scanner, String message) {
        String textValue = "";
        float value = 0.0f;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            
            try {
                value = Float.parseFloat(textValue);
                break;
            } catch(NumberFormatException e) {
                System.out.println("Input value is not float.");
                continue;
            }
        } while (true);
        
        return value;
    }

    private boolean inputType(Scanner scanner) {
        boolean type = false;
        String textType = "";
        
        do {
            System.out.print("How to calculate dimensions(feet/meter)? ");
            textType = scanner.nextLine();
            
            if (textType.equals("feet")) {
                type = TYPE_FEET_TO_METER;
                break;
            } else if (textType.equals("meter")) {
                type = TYPE_METER_TO_FEET;
                break;
            } else {
                System.out.println("Invalid types.");
                continue;
            }
        } while (true);
        
        return type;
    }
    
    private float calculateSquareFeet(float length, float width) {
        return length * width;
    }
    
    private float calculateSquareMeter(float length, float width) {
        return length * width;
    }
    
    private float transformSquareMeter(float squareFeet) {
        return squareFeet * SQUARE_METER_CONSTANT;
    }
    
    private float transformSquareFeet(float squareMeter) {
        return squareMeter / SQUARE_METER_CONSTANT;
    }
    
    private void printResult(boolean type, float length, float width, float squareFeet, float squareMeter) {
        DecimalFormat df = null;
        
        df = new DecimalFormat("#.###");
        System.out.println("The area is");
        if (type == TYPE_FEET_TO_METER) {
            System.out.println("You entered dimensions of " + df.format(length)
                            + " feet by " + df.format(width) + " feet");
            System.out.println(df.format(squareFeet) + " square feet");
            System.out.println(df.format(squareMeter) + " square meters");
        } else {
            System.out.println("You entered dimensions of " + df.format(length)
            + " meter by " + df.format(width) + " meter");
            System.out.println(df.format(squareMeter) + " square meters");
            System.out.println(df.format(squareFeet) + " square feet");
        }
    }
}
