import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testAdd() {
        assertEquals(10, SimpleCalculator.add(5,5));
    }

    @Test
    void testSubtract(){
        assertEquals(0, SimpleCalculator.subtract(5, 5));
    }

    @Test
    void testMultiply(){
        assertEquals(25, SimpleCalculator.multiply(5, 5));
    }

    @Test
    void testDivide(){
        assertEquals(1.0, SimpleCalculator.divide(5, 5), 0.0001);
    }

    @Test
    void testGetNumber() {
        Scanner input = new Scanner("e\n5\n");
        assertEquals(5, SimpleCalculator.getNumber(input));
    }

    @Test
    void testGetNumberReturnsValidErrorMessage() {
        Scanner input = new Scanner("e\n5\n");
        try {
            SimpleCalculator.getNumber(input);
            String printedOutput = outputStream.toString();
            assertTrue(printedOutput.contains("The nr is not valid"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testGetString() {
        Scanner input = new Scanner("e\n+\n");
        assertEquals("+",SimpleCalculator.getString(input));
    }

    @Test
    void testGetStringReturnsValidErrorMessage(){
        Scanner input = new Scanner("e\n\n+");
        SimpleCalculator.getString(input);
        String printedOutput = outputStream.toString();

        assertTrue(printedOutput.contains("Enter correct operator"));
    }
    @Test
    void testMathOperationsReturnsValidErrorMessage(){
        SimpleCalculator.mathOperations("e", 5,5);
        String printedOutput = outputStream.toString();
        assertTrue(printedOutput.contains("You did not enter valid operator"));
    }
    @Test
    void testMathOperations(){
        SimpleCalculator.mathOperations("+", 5,5);
        String printedOutputAdd = outputStream.toString();
        assertTrue(printedOutputAdd.contains("The answer is: " + 10), "");

        outputStream.reset();
        SimpleCalculator.mathOperations("-", 10,5);
        String printedOutputSubtract = outputStream.toString();
        assertTrue(printedOutputSubtract.contains("The answer is: " + 5), "");

        outputStream.reset();
        SimpleCalculator.mathOperations("/", 25,5);
        String printedOutput = outputStream.toString();
        assertTrue(printedOutput.contains("The answer is: " + 5), "");

        outputStream.reset();
        SimpleCalculator.mathOperations("*", 5,5);
        String printedOutputMultiply = outputStream.toString();
        assertTrue(printedOutputMultiply.contains("The answer is: " + 25), "");

    }

}