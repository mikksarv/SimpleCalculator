import java.util.Scanner;

public class SimpleCalculator {

    public static int add(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
    public static int subtract(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }
    public static int multiply(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }
    public static double divide(int firstNumber, int secondNumber){
        return (double) firstNumber / secondNumber;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number");
        int firstNumber = input.nextInt();
        input.nextLine();

        System.out.println("Choose the operation +,-,* or / to continue");
        String operator = input.nextLine();

        System.out.println("Enter second number");
        int secondNumber = input.nextInt();

        switch (operator) {
            case "+" -> System.out.println("The answer is: " + add(firstNumber, secondNumber));
            case "-" -> System.out.println("The answer is: " + subtract(firstNumber, secondNumber));
            case "*" -> System.out.println("The answer is: " + multiply(firstNumber, secondNumber));
            case "/" -> System.out.println("The answer is: " + divide(firstNumber, secondNumber));
            default -> System.out.println("Something is missing!");
            }
        }
    }

