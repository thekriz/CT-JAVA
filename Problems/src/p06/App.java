package p06;

import java.util.Calendar;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        int age = 0;
        int retire = 0;
        Scanner scanner = null;
        boolean retired = false;
        
        scanner = new Scanner(System.in);
        do {
            age = inputNumber(scanner, "What is your current age? ");
            retire = inputNumber(scanner, "At what age would you like to retire? ");
            retired = (age > retire) ? true : false;
            if (retired) {
                System.out.println("Age must be less than retire.");
            }
        } while (retired);
        scanner.close();
        
        printLeftYear(age, retire);
        printRetireYear(age, retire);
    }
    
    private int inputNumber(Scanner scanner, String message) {
        String textNumber = "";
        int number = 0;
        
        do {
            System.out.print(message);
            textNumber = scanner.nextLine();
            try {
                number = Integer.parseInt(textNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("This value is not valid.");
                continue;
            }
        } while (true);
        
        return number;
    }
    
    private void printLeftYear(int age, int retire) {
        System.out.println("You have " + (retire - age) + " years left until you can retire.");
    }
    
    private void printRetireYear(int age, int retire) {
        Calendar calendar = null;
        
        calendar = Calendar.getInstance();
        
        System.out.println("It's " + calendar.get(Calendar.YEAR)
                        + ", so you can retire in " + (calendar.get(Calendar.YEAR) + (retire - age)) + ".");
    }

}
