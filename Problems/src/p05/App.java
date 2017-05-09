package p05;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        Scanner scanner = null;
        int first = 0;
        int second = 0;
        
        int plus = 0;
        int minus = 0;
        int multiple = 0;
        float divide = 0.0f; /**/
        
        scanner = new Scanner(System.in);
        first = inputNumber(scanner, "What is the first number? ");
        second = inputNumber(scanner, "What is the second number? ");
        scanner.close();
        
        plus = calculatePlus(first, second);
        minus = calculateMinus(first, second);
        multiple = calculateMultiple(first, second);
        divide = calculateDivide(first, second); /**/
        
        printResult(first, second, plus, minus, multiple, divide);
    }
    
    private int inputNumber(Scanner scanner, String message) {
        String textNumber = "";
        int number = 0;
        boolean valid = false;
        boolean negative = true;
        
        do {
            valid = false;
            negative = false;
            System.out.print(message);
            textNumber = scanner.nextLine();
            try {
                number = Integer.parseInt(textNumber);
                valid = true;
                
                if (number < 0) {
                    System.out.println("This value is negative.");
                    negative = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("This value is not valid.");
            }
        } while (!valid || negative);
        
        return number;
    }
    
    private int calculatePlus(int first, int second) {
        return first + second;
    }
    
    private int calculateMinus(int first, int second) {
        return first - second;
    }
    
    private int calculateMultiple(int first, int second) {
        return first * second;
    }
    
    private float calculateDivide(int first, int second) { /**/
        return (float)first / (float)second;
    }
    
    private void printResult(int first, int second, int plus, int minus, int multiple, float divide) {
        System.out.println(first + " + " + second + " = " + plus);
        System.out.println(first + " - " + second + " = " + minus);
        System.out.println(first + " * " + second + " = " + multiple);
        System.out.println(first + " / " + second + " = " + divide);
    }
}
