package p15;

import java.util.Scanner;

public class App {
    public static final String CORRECT_USERNAME = "user";
    public static final String CORRECT_PASSWORD = "abc$123";
    
    public void process() {
        String username = null;
        String password = null;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        username = inputValue(scanner, "What is the username: ");
        password = inputValue(scanner, "What is the password: ");
        scanner.close();
        
        if(username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
            System.out.println("Welcome!");
        } else {
            System.out.println("This password is incorrect.");
        }
    }
    
    public String inputValue(Scanner scanner, String message) {
        String value = null;
        boolean isValid = false;
        
        do {
            System.out.print(message);
            value = scanner.nextLine();
            isValid = true;
        } while(!isValid);
        
        return value;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }

}
