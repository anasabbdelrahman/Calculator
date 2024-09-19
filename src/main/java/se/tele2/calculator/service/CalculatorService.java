package se.tele2.calculator.service;

import se.tele2.calculator.model.Calculation;
import se.tele2.calculator.repository.CalculationRepository;
import org.springframework.stereotype.Service;

/**
 * Handling arithmetic operations and managing calculation history.
 */
@Service
public class CalculatorService {

    private final CalculationRepository repository;

    /**
     * Constructor
     *
     * @param repository The CalculationRepository for storing and retrieving calculations.
     */
    public CalculatorService(CalculationRepository repository) {
        this.repository = repository;
    }

    /**
     * Perform an arithmetic operation.
     *
     * @param operation The type of operation ("add", "subtract", "multiply", or "divide").
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @return A Calculation object hold the result of the operation.
     * @throws IllegalArgumentException If an invalid operation type is passed.
     * @throws ArithmeticException If division by zero is attempted.
     */
    public Calculation performOperation(String operation, double operand1, double operand2) {
        double result = switch (operation) {
            case "add" -> operand1 + operand2;
            case "subtract" -> operand1 - operand2;
            case "multiply" -> operand1 * operand2;
            case "divide" -> {
                if (operand2 == 0) throw new ArithmeticException("Cannot divide by zero");
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Invalid operation");
        };

        Calculation calculation = new Calculation(operation, operand1, operand2, result);
        return repository.save(calculation);
    }

    /**
     * Retrieve all calculations from the database.
     *
     * @return An Iterable of Calculation objects.
     */
    public Iterable<Calculation> getAllCalculations() {
        return repository.findAll();
    }
}
