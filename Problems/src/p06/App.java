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
        boolean alreadyRetired = false;
        
        scanner = new Scanner(System.in);

        do {
            age = inputNumber(scanner, "What is your current age? ");
            retire = inputNumber(scanner, "At what age would you like to retire? ");
            alreadyRetired = (age > retire) ? true : false;
            if(alreadyRetired) {
                System.out.println("Age must be less than retire.");
            }
        } while(alreadyRetired);
        
        scanner.close();
        
        printLeftYear(age, retire);
        printRetireYear(age, retire);
    }
    
    public int inputNumber(Scanner scanner, String message) {
        String textNumber = null;
        int number = 0;
        
        System.out.print(message);
        textNumber = scanner.nextLine();
        number = Integer.valueOf(textNumber);
        
        return number;
    }
    
    public void printLeftYear(int age, int retire) {
        System.out.println("You have " + String.valueOf(retire-age) + " years left until you can retire.");
    }
    
    public void printRetireYear(int age, int retire) {
        Calendar calendar = null;
        
        calendar = Calendar.getInstance();
        
        System.out.println("It's " + String.valueOf(calendar.get(Calendar.YEAR))
                        + ", so you can retire in " + String.valueOf(calendar.get(Calendar.YEAR) + (retire-age)));
    }

}
