import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int numTerms = scanner.nextInt();
        scanner.close();

        int firstTerm = 0;
        int secondTerm = 1;

        System.out.println("Fibonacci Sequence of " + numTerms + " terms:");
        for (int i = 0; i < numTerms; i++) {
            System.out.print(firstTerm + " ");
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
}
