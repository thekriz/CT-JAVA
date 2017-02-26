package p07;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static final double SQUARE_METER_CONSTANT = 0.09290304;
    public static final boolean TYPE_FEET_TO_METER = true;
    public static final boolean TYPE_METER_TO_FEET = false;
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        double length = 0;
        double width = 0;
        double squareFeet = 0;
        double squareMeter = 0;
        boolean type = false;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        type = inputType(scanner, "How to calculate dimensions(feet/meter)? ");
        
        if(type == TYPE_FEET_TO_METER) {
            length = inputDouble(scanner, "What is the length of the room in feet? ");
            width = inputDouble(scanner, "What is the width of the room in feet? ");

            squareFeet = calculateSquareFeet(length, width);
            squareMeter = transformSquareMeter(squareFeet);
        } else {
            length = inputDouble(scanner, "What is the length of the room in meter? ");
            width = inputDouble(scanner, "What is the width of the room in meter? ");

            squareMeter = calculateSquareMeter(length, width);
            squareFeet = transformSquareFeet(squareMeter);
        }
        
        scanner.close();
        printResult(type, length, width, squareFeet, squareMeter);
    }
    
    public double inputDouble(Scanner scanner, String message) {
        String textValue = null;
        double value = 0;
        boolean isDouble = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            
            try {
                value = Double.valueOf(textValue);
                isDouble = true;
            } catch(NumberFormatException e) {
                System.out.println("Input value is not double");
            }
        } while(!isDouble);
        
        return value;
    }

    public boolean inputType(Scanner scanner, String message) {
        boolean type = false;
        String textType = null;
        boolean isType = false;
        
        do {
            System.out.print(message);
            textType = scanner.nextLine();
            
            if (textType.equals("feet")) {
                type = TYPE_FEET_TO_METER;
                isType = true;
            } else if(textType.equals("meter")) {
                type = TYPE_METER_TO_FEET;
                isType = true;
            } else {
                System.out.println("Invalid types");
            }
        } while(!isType);
        
        return type;
    }
    
    public double calculateSquareFeet(double length, double width) {
        return length * width;
    }
    
    public double calculateSquareMeter(double length, double width) {
        return length * width;
    }
    
    public double transformSquareMeter(double squareFeet) {
        return squareFeet * SQUARE_METER_CONSTANT;
    }
    
    public double transformSquareFeet(double squareMeter) {
        return squareMeter / SQUARE_METER_CONSTANT;
    }
    
    public void printResult(boolean type, double length, double width, double squareFeet, double squareMeter) {
        DecimalFormat df = null;
        
        df = new DecimalFormat("#.###");
        System.out.println("The area is");
        
        if(type == TYPE_FEET_TO_METER){
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
