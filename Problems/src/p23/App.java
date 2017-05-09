package p23;

import java.util.Scanner;

public class App {
    
    public void process() {
        boolean answer = false;
        String result = "";
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        answer = inputAnswer(scanner, "Is the car silent when you turn the key? ");
        if (answer) {
            answer = inputAnswer(scanner, "Are the battery terminals corroded? ");
            if (answer) {
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
    
    private boolean inputAnswer(Scanner scanner, String message) {
        String textValue = "";
        char value = ' ';
        boolean valid = false;
        boolean answer = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            textValue = textValue.toLowerCase();
            value = textValue.charAt(0);
            
            switch (value) {
                case 'y':
                    valid = true;
                    answer = true;
                    break;
                case 'Y':
                    valid = true;
                    answer = true;
                    break;
                case 'n':
                    valid = true;
                    answer = false;
                    break;
                case 'N':
                    valid = true;
                    answer = false;
                    break;
                default:
                    System.out.println("This value is not valid.");
                    continue;
            }
        } while (!valid);
        
        return answer;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }

}
