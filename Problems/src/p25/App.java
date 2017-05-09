package p25;

import java.util.Scanner;

public class App {
    public final static int UNKNOWN = 0;
    public final static int VERY_WEAK_PASSWORD = 1;
    public final static int WEAK_PASSWORD = 2;
    public final static int STRONG_PASSWORD = 3;
    public final static int VERY_STRONG_PASSWORD = 4;
    
    public final static int VALID_PASSWORD_LENGTH = 8;
    
    public void process() {
        String password = "";
        int result = 0;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        password = inputString(scanner, "Input the password: ");
        scanner.close();
        
        result = passwordValidator(password);
        printResult(password, result);
    }
    
    private String inputString(Scanner scanner, String message) {
        String textValue = "";
        boolean valid = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            valid = true;
        } while (!valid);
        
        return textValue;
    }
    
    private int passwordValidator(String password) {
        StringBuilder strBuilder = null;
        boolean isHasNumber = false;
        boolean isHasAlphabat = false;
        boolean isHasSpecialCharacter = false;
        boolean isValidLength = false;
        int result = 0;
        char c = ' ' ;
        
        strBuilder = new StringBuilder(password);
        isValidLength = (password.length() >= VALID_PASSWORD_LENGTH) ? true : false;
        for (int i = 0; i < password.length(); i++) {
            c = strBuilder.charAt(i);
            if (c >= '0' && c <= '9') {
                isHasNumber = true;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                isHasAlphabat = true;
            } else if((c == '!') || (c == '@') || (c == '#') || (c == '$') || (c == '%')
                || (c == '^') || (c == '&') || (c == '*') || (c == '(') || (c == ')')
                || (c == '!')) {
                isHasSpecialCharacter = true; 
            }
        }
        
        if (isHasNumber && !isHasAlphabat && !isHasSpecialCharacter && !isValidLength) {
            result = VERY_WEAK_PASSWORD;
        } else if (!isHasNumber && isHasAlphabat && !isHasSpecialCharacter && !isValidLength) {
            result = WEAK_PASSWORD;
        } else if (isHasNumber && isHasAlphabat && !isHasSpecialCharacter && isValidLength) {
            result = STRONG_PASSWORD;
        } else if (isHasNumber && isHasAlphabat && isHasSpecialCharacter && isValidLength) { 
            result = VERY_STRONG_PASSWORD;
        } else {
            result = UNKNOWN;
        }
        
        return result;
    }
    
    private void printResult(String password, int result) {
        String resultStr = "";
        
        resultStr += "The password '" + password + "' is a ";
        switch (result) {
            case VERY_WEAK_PASSWORD:
                resultStr += "very weak password.";
                break;
            case WEAK_PASSWORD:
                resultStr += "weak password.";
                break;
            case STRONG_PASSWORD:
                resultStr += "strong password";
                break;
            case VERY_STRONG_PASSWORD:
                resultStr += "very strong password.";
                break;
            default:
                resultStr += "unknown password.";
                break;
        }
        
        System.out.println(resultStr);
    }
    
    public static void main(String args[]) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
