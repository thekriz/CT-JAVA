package p33;

import java.util.Random;
import java.util.Scanner;

public class App {
    public void process() {
        String[] answerList = {"Yes.", "No.", "Maybe.", "Ask again later."};
        
        Scanner scanner = null;
        String question = "";
        Random random;
        int answerIndex = -1;
        
        scanner = new Scanner(System.in);
        question = inputString(scanner, "What's your question? ");
        
        random = new Random();
        answerIndex = random.nextInt(answerList.length);
        
        System.out.println(answerList[answerIndex]);
    }
    
    private String inputString(Scanner scanner, String message) {
        String str = "";
        
        System.out.print(message);
        str = scanner.nextLine();
        
        return str;
    }
    
    static public void main(String args[]) {
        App app = new App();
        app.process();
    }
}
