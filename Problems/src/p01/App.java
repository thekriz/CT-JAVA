package p01;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        String name = "";
        String string = "";
        
        name = inputName();
        string = concatenate(name);
        printString(string);
    }
    
//    public void process() {
//        printString(concatenate(inputName()));
//    }
    
    private String inputName() {
        String name = "";
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        System.out.print("What is your name? ");
        name = scanner.nextLine();
        scanner.close();
        
        return name;
    }
    
    private String concatenate(String name) {
        return "Hello, " + name + ", nice to meet you!";
    }
    
    private void printString(String string) {
        System.out.println(string);
    }
}
