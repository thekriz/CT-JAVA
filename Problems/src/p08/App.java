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
    
    private int inputValue(Scanner scanner, String message) {
        String textValue = "";
        int value = 0;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            try {
                value = Integer.parseInt(textValue);
                break;
            } catch (NumberFormatException e) {
                System.out.println("This value is not valid");
                continue;
            }
        } while (true);
        
        return value;
    }
    
    private int inputEven(Scanner scanner, String message) {
        int value = 0;
        boolean even = false;
        
        do {
            value = inputValue(scanner, message);
            even = (value % 2 == 0) ? true : false;
            if (!even) {
                System.out.println("Value must be even");
                continue;
            }
        } while (!even);
        
        return value;
    }

    private int getPiecePerPerson(int people, int pizza, int piece) {
        return (pizza * piece) / people;
    }
    
    private int getLeftOver(int people, int pizza, int piece) {
        return (pizza * piece) % people;
    }
    
    private void printResult(int people, int pizza, int piece, int getPiece, int leftOver) {
        System.out.println(people + " people with " + pizza + " pizzas");
        
        if (getPiece > 1) {
            System.out.println("Each person gets " + getPiece + " pieces of pizza.");
        } else {
            System.out.println("Each person gets " + getPiece + " piece of pizza.");
        }
        
        System.out.println("There are " + leftOver + " leftover pieces.");
    }
}
