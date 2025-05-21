import java.util.Objects;
import java.util.Scanner;

public class SimpleCalculator {

    public static int add(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
    public static int subtract(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number");
        int firstNumber = input.nextInt();

        System.out.println("Enter second number");
        int secondNumber = input.nextInt();
        input.nextLine();

        System.out.println("Choose the operation + or - to continue");
        String operator = input.nextLine();

        if(Objects.equals(operator, "+")){
            System.out.println("The answer is: " + add(firstNumber, secondNumber));
        }
        else if (Objects.equals(operator, "-")){
            System.out.println("The answer is: " + subtract(firstNumber, secondNumber));
        }
        else {
            System.out.println("You did not enter valid operator or number");
        }
    }
}
