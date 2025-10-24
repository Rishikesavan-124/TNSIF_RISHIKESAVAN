import java.util.Scanner;
import java.util.function.IntUnaryOperator;

public class Find_Factorial_Lambda {

    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number to find its factorial:");

        // Get input from user
        int num = scan.nextInt();

        // 1. Define a Functional Interface (IntUnaryOperator)
        // IntUnaryOperator is a predefined functional interface for a function
        // that accepts one int argument and produces an int result.

        // 2. Implement the interface using a Lambda Expression
        // The lambda expression takes an integer 'n' and calculates its factorial.
        IntUnaryOperator factorialCalculator = (n) -> {
            long f = 1; // Use long to prevent overflow for larger factorials
            // Check for negative input (optional but good practice)
            if (n < 0) {
                return -1; // Indicate error or handle as per requirement
            }
            // Calculate factorial using a loop
            for (int i = 1; i <= n; i++) {
                f = f * i;
            }
            // Cast back to int for IntUnaryOperator's return type,
            // or switch to LongUnaryOperator if factorials exceed Integer.MAX_VALUE
            return (int) f;
        };

        // 3. Call the abstract method of the functional interface using the lambda
        int result = factorialCalculator.applyAsInt(num);

        // Print the result
        if (result == -1) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            System.out.println("Factorial of the " + num + " is " + result);
        }

        scan.close();
    }
}