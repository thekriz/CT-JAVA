package p21;

import java.util.Scanner;

public class App {

    public void process() {
        int number = 0;
        String name = null;
        String result = null;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        number = inputValue(scanner, "Please enter the number of the month: ");
        scanner.close();
        
        switch(number) {
            case 1:
                name = "January";
                break;
            case 2:
                name = "Februrary";
                break;
            case 3:
                name = "March";
                break;
            case 4:
                name = "April";
                break;
            case 5:
                name = "May";
                break;
            case 6:
                name = "June";
                break;
            case 7:
                name = "July";
                break;
            case 8:
                name = "August";
                break;
            case 9:
                name = "September";
                break;
            case 10:
                name = "Octobor";
                break;
            case 11:
                name = "November";
                break;
            case 12:
                name = "December";
                break;
            default:
                name = null;
                break;
        }
        
        result = (name != null) ? "The name of the month is " + name + "." : "This value is not valid.";
        System.out.println(result);
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
                System.out.println("This value is not valid.");
            }
        } while(!isValid);
        
        return value;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }

}
