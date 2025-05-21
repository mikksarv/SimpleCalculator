import java.util.Scanner;

public class SimpleCalculator {

    public static int add(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public static void main(String[] args) {
        System.out.println("Enter first number");

        Scanner input = new Scanner(System.in);
        int firstNumber = input.nextInt();

        System.out.println("Enter second number");
        int secondNumber = input.nextInt();

        System.out.println("The total of the numbers is: " + add(firstNumber, secondNumber) );

    }
}
