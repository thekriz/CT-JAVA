package p30;

public class App {
    
    public void process() {
        for (int i = 0; i <= 12; i++) {
            for (int j = 0; j <= 12; j++) {
                System.out.printf("%d x %d = %d%s", i, j, i * j, System.lineSeparator());
            }
        }
    }
    
    public static void main(String args[]) {
        App app = null;
        
        app = new App();
        app.process();
    }
}
