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
        int divide = 0; /**/
        
        scanner = new Scanner(System.in);
        
        first = inputNumber(scanner, "What is the first number? ");
        second = inputNumber(scanner, "What is the second number? ");
        
        plus = calculatePlus(first, second);
        minus = calculateMinus(first, second);
        multiple = calculateMultiple(first, second);
        divide = calculateDivide(first, second); /**/
        
        scanner.close();
        
        //printResult(first, second);
        printResult(first, second, plus, minus, multiple, divide);
    }
    
    public int inputNumber(Scanner scanner, String message) {
        String textNumber = null;
        int number = 0;
        boolean isNumber = false;
        boolean isNegative = true;
        
        do {
            isNumber = false;
            isNegative = true;
            System.out.print(message);
            textNumber = scanner.nextLine();
            try {
                number = Integer.valueOf(textNumber);
                isNumber = true;
                
                if(number < 0) {
                    System.out.println("This value is negative");
                } else {
                    isNegative = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("This value is not number.");
            }
        } while(!isNumber || isNegative);
        
        return number;
    }
    
    public int calculatePlus(int first, int second) {
        return first + second;
    }
    
    public int calculateMinus(int first, int second) {
        return first - second;
    }
    
    public int calculateMultiple(int first, int second) {
        return first * second;
    }
    
    public int calculateDivide(int first, int second) { /**/
        return first / second;
    }
    
    public void printResult(int first, int second, int plus, int minus, int multiple, int divide) {
        System.out.println(String.valueOf(first) + " + " + String.valueOf(second) + " = " + String.valueOf(plus));
        System.out.println(String.valueOf(first) + " - " + String.valueOf(second) + " = " + String.valueOf(minus));
        System.out.println(String.valueOf(first) + " * " + String.valueOf(second) + " = " + String.valueOf(multiple));
        System.out.println(String.valueOf(first) + " / " + String.valueOf(second) + " = " + String.valueOf(divide));
    }
    
    public void printResult(int first, int second) {
        System.out.println(String.valueOf(first) + " + " + String.valueOf(second) + " = "
                        + String.valueOf(first + second) + System.lineSeparator()
                        + String.valueOf(first) + " - " + String.valueOf(second) + " = "
                        + String.valueOf(first - second) + System.lineSeparator()
                        + String.valueOf(first) + " * " + String.valueOf(second) + " = "
                        + String.valueOf(first * second) + System.lineSeparator()
                        + String.valueOf(first) + " / " + String.valueOf(second) + " = "
                        + String.valueOf(first / second) + System.lineSeparator()
                        );
    }

}
