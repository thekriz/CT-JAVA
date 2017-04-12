package p23;

import java.util.Scanner;

public class App {

    public void process() {
        String value = null;
        String result = null;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        value = inputAnswer(scanner, "Is the car silent when you turn the key? ");
        if(value.equals("y")) {
            value = inputAnswer(scanner, "Are the battery terminals corroded? ");
            if(value.equals("y")) {
                result = "Clear terminals and try again.";
            } else {
                result = "The battery cables may be damaged." + System.lineSeparator() 
                        + "Replace cables and try again.";
            }
        } else {
            // omit
        }
        scanner.close();
        System.out.println(result);
    }
    
    public String inputAnswer(Scanner scanner, String message) {
        String textValue = null;
        String value = null;
        boolean isValid = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            value = textValue.toLowerCase();
            if(value.equals("y") || value.equals("n")) {
                isValid = true;
            } else {
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
