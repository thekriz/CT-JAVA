package p31;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    
    public static final int MIN_INTENSITY = 55;
    public static final int MAX_INTENSITY = 95;
    
    public void process() {
        int age = 0;
        int pulse = 0;
        float rate = 0.0f;
        Scanner scanner = null;
        DecimalFormat decimalFormat = null;
        
        scanner = new Scanner(System.in);
        pulse = inputValue(scanner, "Input your pulse: ");
        age = inputValue(scanner, "Input your age: ");
        scanner.close();
        
        printTitle(pulse, age);
        decimalFormat = new DecimalFormat("#");
        for (int intensity = MIN_INTENSITY; intensity <= MAX_INTENSITY; intensity += 5) {
            rate = calculateRate(pulse, age, intensity);
            System.out.println( intensity+"%       | " + decimalFormat.format(rate) + " bpm" );
        }
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
    
    private void printTitle(int pulse, int age) {
        System.out.println("Resting Pulse: "+pulse+" age: "+age);
        System.out.println("Intensity | Rate");
        System.out.println("----------------------");
    }
    
    private float calculateRate(int pulse, int age, int intensity) {
        return (((220 - age) - pulse) * (intensity / 100.0f)) + pulse;
        
    }
    
    public static void main(String args[]) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
