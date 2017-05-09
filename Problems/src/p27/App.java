package p27;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static final String PATTERN_NAME_EXP = "[a-zA-Z0-9 .]{2,}";
    public static final String PATTERN_ID_EXP = "[a-zA-Z]{2}-[0-9]{4}";
    public static final String PATTERN_ZIP_EXP = "[0-9]{5}";
    
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_NOT_MATCH_FORMAT = 1;
    public static final int CODE_EMPTY = 2;
    
    public void process() {
        String firstName = "";
        String lastName = "";
        String employeeId = "";
        String zipCode = "";
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        firstName = inputValue(scanner, "Enter the first name: ");
        lastName = inputValue(scanner, "Enter the last name: ");
        zipCode = inputValue(scanner, "Enter the ZIP code: ");
        employeeId = inputValue(scanner, "Enter the employee ID: ");
        scanner.close();
        
        validateInput(firstName, lastName, zipCode, employeeId);
    }
    
    private String inputValue(Scanner scanner, String message) {
        String value = "";
        
        System.out.print(message);
        value = scanner.nextLine();
        
        return value;
    }
    
    private void validateInput(String firstName, String lastName, String zipCode, String employeeId) {
        StringBuilder resultMessage = null;
        
        resultMessage = new StringBuilder();
        
        validateFirstName(firstName, resultMessage);
        validateLastName(lastName, resultMessage);
        validateZipCode(zipCode, resultMessage);
        validateEmployeeId(employeeId, resultMessage);
        
        if (resultMessage.length() == 0) {
            resultMessage.append("There were no erros found.");
        }
        
        System.out.println(resultMessage);
    }
    
    private void validateFirstName(String firstName, StringBuilder resultMessage) {
        if (firstName.isEmpty()) {
            resultMessage.append("The first name must be filled in.").append(System.lineSeparator());
        } else if (!Pattern.matches(PATTERN_NAME_EXP, firstName)) {
            resultMessage.append("\""+firstName+"\" is not a valid first name.").append(System.lineSeparator());
        } else {
            // do nothing
        }
    }
    
    private void validateLastName(String lastName, StringBuilder resultMessage) {
        if (lastName.isEmpty()) {
            resultMessage.append("The last name must be filled in.").append(System.lineSeparator());
        } else if (!Pattern.matches(PATTERN_NAME_EXP, lastName)) {
            resultMessage.append("\""+lastName+"\" is not a valid last name.").append(System.lineSeparator());
        } else {
            // do nothing
        }
    }
    
    private void validateZipCode(String zipCode, StringBuilder resultMessage) {
        if (!Pattern.matches(PATTERN_ZIP_EXP, zipCode)) {
            resultMessage.append(zipCode+" is not a valid ZIP Code.").append(System.lineSeparator());
        }
    }
    
    private void validateEmployeeId(String employeeId, StringBuilder resultMessage) {
        if (!Pattern.matches(PATTERN_ID_EXP, employeeId)) {
            resultMessage.append(employeeId+" is not a valid ID.").append(System.lineSeparator());
        }
    }
    
    public static void main(String args[]) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
