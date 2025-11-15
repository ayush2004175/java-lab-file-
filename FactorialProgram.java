import java.util.Scanner;

public class FactorialProgram {

    // Recursive method
    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    // Iterative method
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        long recResult = factorialRecursive(num);
        long iterResult = factorialIterative(num);

        System.out.println("\nFactorial using recursion: " + recResult);
        System.out.println("Factorial using iteration: " + iterResult);

        sc.close();
    }
}

