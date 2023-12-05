import java.util.InputMismatchException;
import java.util.Scanner;

public class PDA {
    
    private Scanner scanner;
    private int age;
    private final int LOWER_BOUND = 18;
    private final int UPPER_BOUND = 100;
    
    private boolean shouldContinue;
    
    public PDA() {
        scanner = new Scanner(System.in);
        shouldContinue = true;
    }
    
    public void runEventLoop() {
        while (shouldContinue) {
            System.out.println("How old are you? (Enter 0 to quit)");
            try {
                age = scanner.nextInt();
                
                if (age == 0) {
                    shouldContinue = false;
                } else {
                    if (age < LOWER_BOUND) {
                       System.out.println(age + " is too young!!");
                    } else if (age > UPPER_BOUND) {
                       System.out.println("That age is to old.");
                    } else {
                        int youngerAge = getYoungerAge(age);
                        int olderAge = getOlderAge(age);
                        
                        System.out.println("Younger age: " + youngerAge);
                        System.out.println("Older age: " + olderAge);
                    }
                }
            } catch (InputMismatchException error) {
                System.out.println("Please enter a valid integer");
                scanner.next();
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
    
    private int getYoungerAge(int age) {
        return (int) Math.ceil(age / 2.0 + 7);
    }
    
    private int getOlderAge(int age) {
        return (int) Math.ceil((age - 7) * 2.0);
    }
    
    public static void main(String[] args) {
        PDA pda = new PDA();
        pda.runEventLoop();
    }
}
        


