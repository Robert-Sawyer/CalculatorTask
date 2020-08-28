package executor;

import calculator.Calculator;
import command.MultiplyCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationExecutorTest {

    @Test
    void shouldReturnCorrectResult() {
        //given
        CalculationExecutor calculationExecutor = new CalculationExecutor(new Calculator());

        //when
        String operation = "apply 10";

        //then
        assertEquals(10, calculationExecutor.analyzeOperation(operation));
    }

    @Test
    void shouldExecuteCorrectOperation() {
        //given
        Calculator calculator = new Calculator();

        //when
        int currentNumber = 2;
        String operation = "multiply 2";
        String[] commandArr = operation.split(" ");
        MultiplyCommand command = new MultiplyCommand(currentNumber, Integer.parseInt(commandArr[1]));

        //then
        assertEquals(4, calculator.calculate(command));
    }

    @Test
    void shouldThrowException() {
        CalculationExecutor calculationExecutor = new CalculationExecutor(new Calculator());

        int currentNumber = 1;
        String operation = "";

        assertThrows(IllegalArgumentException.class, () -> calculationExecutor.executeOperation(currentNumber, operation));
    }
}
