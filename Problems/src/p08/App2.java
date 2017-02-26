package p08;

import java.util.Scanner;

public class App2 {

    public static void main(String[] args) {
        App2 app = null;
        
        app = new App2();
        app.process();
    }
    
    public void process() {
        Scanner scanner = null;
        int people = 0;
        int wantPieces = 0;
        int piece = 0;
        int pizza = 0;
        
        scanner = new Scanner(System.in);
        people = inputValue(scanner, "How many people? ");
        wantPieces = inputValue(scanner, "How many piece people wants? ");
        piece = inputEven(scanner, "How many pieces are in a pizza? ");
        scanner.close();
        
        pizza = getPizza(people, wantPieces, piece);
        printResult(pizza);
    }
    
    public int inputValue(Scanner scanner, String message) {
        int value = 0;
        String textValue = null;
        boolean isValid = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            try {
                value = Integer.valueOf(textValue);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("This value is invalid");
            }
        } while(!isValid);
        
        return value;
    }

    public int inputEven(Scanner scanner, String message) {
        int value = 0;
        boolean isEven = false;
        
        do {
            value = inputValue(scanner, message);
            isEven = (value % 2 == 0) ? true : false;
            if(!isEven) {
                System.out.println("Value must be even");
            }
        } while(!isEven);
        
        return value;
    }
    
    public int getPizza(int people, int wantPieces, int piece) {
        int pizza = 0;
        int leftOver = 0;
        pizza = (people * wantPieces) / piece;
        leftOver = (people * wantPieces) % piece;
        return (leftOver > 0) ? pizza + 1 : pizza;
    }
    
    public void printResult(int pizza) {
        System.out.println(String.valueOf(pizza) + " pizza need");
    }
}
