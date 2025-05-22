import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator {

    public static int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public static double divide(int firstNumber, int secondNumber) {
        return (double) firstNumber / secondNumber;
    }

    private static int getFirstNumber(Scanner input) {
        while (true) {
            try {
                System.out.println("Enter first number");
                int firstNumber = input.nextInt();
                input.nextLine();
                return firstNumber;
            } catch (InputMismatchException _) {
                System.out.println("The nr is not valid");
                input.nextLine();
            }
        }
    }

    private static int getSecondNumber(Scanner input) {
        while (true) {
            try {
                System.out.println("Enter second number");
                return input.nextInt();
            } catch (InputMismatchException _) {
                System.out.println("The nr is not valid");
                input.nextLine();
            }
        }

    }

    private static String getString(Scanner input) {
        while (true) {
            System.out.println("Choose the operation +,-,* or / to continue");
            String operator = input.nextLine();
            if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                return operator;
            } else {
                System.out.println("Enter correct operator");
            }
        }
    }

    private static void mathOperations(String operator, int firstNumber, int secondNumber) {
        switch (operator) {
            case "+" -> System.out.println("The answer is: " + add(firstNumber, secondNumber));
            case "-" -> System.out.println("The answer is: " + subtract(firstNumber, secondNumber));
            case "*" -> System.out.println("The answer is: " + multiply(firstNumber, secondNumber));
            case "/" -> System.out.println("The answer is: " + divide(firstNumber, secondNumber));
            default -> System.out.println("You did not enter valid operator");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int firstNumber = getFirstNumber(input);
        String operator = getString(input);
        int secondNumber = getSecondNumber(input);
        mathOperations(operator, firstNumber, secondNumber);
    }
}





