package p32;

import java.util.Scanner;

public class App {
    
    public void process() {
        int level = 0;
        int count = 0;
        int answer = 0;
        int value = 0;
        boolean continueGame = false;
        Scanner scanner = null;
        
        System.out.println("Let's play Guess the Number.");
        scanner = new Scanner(System.in);
        do {
            level = inputLevel(scanner);
            answer = chooseValue(level);
            count += 1;
            value = inputValue(scanner, "I have my number. What's your guess? ");
            
            while (value != answer) {
                count += 1;
                if(value > answer) {
                    System.out.print("Too high. ");
                } else { // value < answer
                    System.out.print("Too low. ");
                }
                value = inputValue(scanner, "Guess again: ");
            }
            
            printMessage(count);
            continueGame = inputPlayAgain(scanner);
        } while (continueGame);
        
        System.out.println("Goodbye!");
        scanner.close();
    }
    
    private int chooseValue(int level) {
        return (int)(Math.random() * Math.pow(10, level)) + 1;
    }
    
    private int inputLevel(Scanner scanner) {
        int value = 0;
        String textValue = "";
        boolean valid = false;
        
        do {
            System.out.print("Pick a difficulty level(1, 2, or 3): ");
            textValue = scanner.nextLine();
            
            try {
                value = Integer.parseInt(textValue);
                
                if ((value >= 1) && (value <= 3)) {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("This value is not valid.");
            }
        } while (!valid);
        
        return value;
    }
    
    private int inputValue(Scanner scanner, String message) {
        int value = 0;
        String textValue = "";
        boolean valid = false;
        
        do {
            System.out.print(message);
            textValue = scanner.nextLine();
            
            try {
                value = Integer.parseInt(textValue);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("This value is not valid.");
            }
        } while (!valid);
        
        return value;
    }
    
    private boolean inputPlayAgain(Scanner scanner) {
        String textValue = "";
        
        do {
            System.out.print("Play again? ");
            textValue = scanner.nextLine();
            
            if (textValue.equals("n") || textValue.equals("N")) {
                return false;
            } else if (textValue.equals("y") || textValue.equals("Y")) {
                return true;
            } else {
                continue;
            }
        } while (true);
    }
    
    private void printMessage(int count) {
        String message = "";
        
        message += "You got it in "+count+" guesses!"+System.lineSeparator();
        if (count == 1) {
            message += "You're a mind reader!";
        } else if (count >= 2 && count <= 4) {
            message += "Most impressive.";
        } else if (count >= 5 && count <= 6) {
            message += "You can do better than that.";
        } else {
            message += "Better luck next time.";
        }
        
        System.out.println(message);
    }
    
    public static void main(String args[]) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
