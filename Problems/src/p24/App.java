package p24;

import java.util.Scanner;

public class App {
    
    public void process() {
        String firstStr = "";
        String secondStr = "";
        String resultStr = "";
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        System.out.println("Enter two string and I'll tell you if they are anagrams:");
        firstStr = inputString(scanner, "Enter the first string: ");
        secondStr = inputString(scanner, "Enter the second string: ");
        scanner.close();
        
        resultStr = "\""+firstStr+"\" and \""+ secondStr + "\" are ";
        if (isAnagram(firstStr, secondStr)) {
            resultStr += "anagrams.";
        } else {
            resultStr += "not anagrams.";
        }
        
        System.out.println(resultStr);
    }
    
    private boolean isAnagram(String str1, String str2) {
        StringBuilder str1Builder = null;
        StringBuilder str2Builder = null;
        char c = ' ';
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        str1Builder = new StringBuilder(str1);
        str2Builder = new StringBuilder(str2);
        for (int i = 0; i < str1Builder.length(); i++) {
            c = str1Builder.charAt(i);
            for (int j = 0; j < str2Builder.length(); j++) {
                if (c == str2Builder.charAt(j)) {
                    str2Builder.replace(j, j+1, " ");
                    break;
                }
            }
        }
        
        for (int i = 0; i < str2Builder.length(); i++) {
            c = str2Builder.charAt(i);
            if (c != ' ') {
                return false;
            }
        }
         
        return true;
    }
    
    private String inputString(Scanner scanner, String message) {
        String value = "";
        
        System.out.print(message);
        value = scanner.nextLine();
        
        return value;
    }
    
    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }

}
