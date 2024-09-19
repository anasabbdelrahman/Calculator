package se.tele2.calculator.controller;

import se.tele2.calculator.model.Calculation;
import se.tele2.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

/**
 * CalculatorController provides REST API endpoints for performing
 * basic arithmetic operations (+, -, *, and /).
 */
@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService service;

    /**
     * Constructor for CalculatorController that injects the CalculatorService.
     *
     * @param service The CalculatorService which handles the business logic.
     */
    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    /**
     * Perform addition of two numbers.
     *
     * @param a First operand.
     * @param b Second operand.
     * @return A Calculation object containing the result of the addition.
     */
    @GetMapping("/add")
    public Calculation add(@RequestParam double a, @RequestParam double b) {
        return service.performOperation("add", a, b);
    }

    /**
     * Perform subtraction of two numbers.
     *
     * @param a First operand.
     * @param b Second operand.
     * @return A Calculation object containing the result of the subtraction.
     */
    @GetMapping("/subtract")
    public Calculation subtract(@RequestParam double a, @RequestParam double b) {
        return service.performOperation("subtract", a, b);
    }

    /**
     * Perform multiplication of two numbers.
     *
     * @param a First operand.
     * @param b Second operand.
     * @return A Calculation object containing the result of the multiplication.
     */
    @GetMapping("/multiply")
    public Calculation multiply(@RequestParam double a, @RequestParam double b) {
        return service.performOperation("multiply", a, b);
    }

    /**
     * Perform division of two numbers.
     *
     * @param a First operand.
     * @param b Second operand.
     * @return A Calculation object containing the result of the division.
     * @throws ArithmeticException If the second operand is zero (division by zero).
     */
    @GetMapping("/divide")
    public Calculation divide(@RequestParam double a, @RequestParam double b) {
        return service.performOperation("divide", a, b);
    }

    /**
     * Retrieve the history of all calculations.
     *
     * @return An Iterable of Calculation objects representing the calculation history.
     */
    @GetMapping("/history")
    public Iterable<Calculation> getHistory() {
        return service.getAllCalculations();
    }
}
