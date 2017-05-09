package p21;

import java.util.Scanner;

public class App {
    
    public void process() {
        int number = 0;
        String name = "";
        String resultMessage = "";
        
        number = inputMonth();
        switch (number) {
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
                name = "";
                break;
        }
        
        resultMessage = (!name.isEmpty()) ? "The name of the month is " + name + "." : "This value is not valid.";
        System.out.println(resultMessage);
    }
    
    private int inputMonth() {
        String textValue = "";
        int value = 0;
        boolean valid = false;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        do {
            System.out.print("Please enter the number of the month: ");
            textValue = scanner.nextLine();
            try {
                value = Integer.parseInt(textValue);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("This value is not valid.");
            }
        } while (!valid);
        scanner.close();
        
        return value;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
