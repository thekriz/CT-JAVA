package p08;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = null;
        
        app = new App();
        app.process();
    }
    
    public void process() {
        int people = 0;
        int pizza = 0;
        int piece = 0;
        int getPiece = 0;
        int leftOver = 0;
        Scanner scanner = null;
        
        scanner = new Scanner(System.in);
        
        people = inputValue(scanner, "How many people? ");
        pizza = inputValue(scanner, "How many pizzas do you have? ");
        piece = inputEven(scanner, "How many pieces are in a pizza? ");
        
        scanner.close();
        
        getPiece = getPiecePerPerson(people, pizza, piece);
        leftOver = getLeftOver(people, pizza, piece);
        
        printResult(people, pizza, piece, getPiece, leftOver);
    }
    
    public int inputValue(Scanner scanner, String message) {
        String textValue = null;
        int value = 0;
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

    public int getPiecePerPerson(int people, int pizza, int piece) {
        return (pizza * piece) / people;
    }
    
    public int getLeftOver(int people, int pizza, int piece) {
        return (pizza * piece) % people;
    }
    
    public void printResult(int people, int pizza, int piece, int getPiece, int leftOver) {
        System.out.println(String.valueOf(people) + " people with " + String.valueOf(pizza) + " pizzas");
        if(getPiece > 1) {
            System.out.println("Each person gets " + String.valueOf(getPiece) + " pieces of pizza.");
        } else {
            System.out.println("Each person gets " + String.valueOf(getPiece) + " piece of pizza.");
        }
        System.out.println("There are " + String.valueOf(leftOver) + " leftover pieces.");
    }
}
