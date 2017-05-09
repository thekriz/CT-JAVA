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
        
        password = inputPassword();
        result = passwordValidator(password);
        printResult(password, result);
    }
    
    private String inputPassword() {
        String textValue = "";
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        System.out.print("Input the password: ");
        textValue = scanner.nextLine();
        scanner.close();
        
        return textValue;
    }
    
    private int passwordValidator(String password) {
        StringBuilder strBuilder = null;
        boolean hasNumber = false;
        boolean hasAlphabat = false;
        boolean hasSpecialCharacter = false;
        boolean validLength = false;
        int result = 0;
        char c = ' ' ;
        
        strBuilder = new StringBuilder(password);
        validLength = (password.length() >= VALID_PASSWORD_LENGTH) ? true : false;
        for (int i = 0; i < password.length(); i++) {
            c = strBuilder.charAt(i);
            if (c >= '0' && c <= '9') {
                hasNumber = true;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                hasAlphabat = true;
            } else if ((c == '!') || (c == '@') || (c == '#') || (c == '$') || (c == '%')
                || (c == '^') || (c == '&') || (c == '*') || (c == '(') || (c == ')')
                || (c == '!')) {
                hasSpecialCharacter = true; 
            }
        }
        
        if (hasNumber && !hasAlphabat && !hasSpecialCharacter && !validLength) {
            result = VERY_WEAK_PASSWORD;
        } else if (!hasNumber && hasAlphabat && !hasSpecialCharacter && !validLength) {
            result = WEAK_PASSWORD;
        } else if (hasNumber && hasAlphabat && !hasSpecialCharacter && validLength) {
            result = STRONG_PASSWORD;
        } else if (hasNumber && hasAlphabat && hasSpecialCharacter && validLength) { 
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
