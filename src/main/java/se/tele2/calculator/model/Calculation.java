package se.tele2.calculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Model class representing a mathematical calculation.
 * Contains information about the operation, operands, and the result.
 */
@Entity
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String operation;
    private double operand1;
    private double operand2;
    private double result;

    /**
     * Default constructor required by JPA.
     */
    public Calculation() {
    }

    /**
     * Constructor to initialize a Calculation object.
     *
     * @param operation The type of operation (e.g., "add", "subtract", "multiply", "divide").
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @param result The result of the operation.
     */
    public Calculation(String operation, double operand1, double operand2, double result) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    /**
     * Get the unique ID of the calculation.
     *
     * @return The calculation ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique ID of the calculation.
     *
     * @param id The calculation ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the operation type.
     *
     * @return The operation type ("add", "subtract", "multiply", "divide").
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Set the operation type.
     *
     * @param operation The operation type to set.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Get the first operand.
     *
     * @return The first operand of the operation.
     */
    public double getOperand1() {
        return operand1;
    }

    /**
     * Set the first operand.
     *
     * @param operand1 The first operand to set.
     */
    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    /**
     * Get the second operand.
     *
     * @return The second operand of the operation.
     */
    public double getOperand2() {
        return operand2;
    }

    /**
     * Set the second operand.
     *
     * @param operand2 The second operand to set.
     */
    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    /**
     * Get the result of the calculation.
     *
     * @return The result of the calculation.
     */
    public double getResult() {
        return result;
    }

    /**
     * Set the result of the calculation.
     *
     * @param result The result to set.
     */
    public void setResult(double result) {
        this.result = result;
    }
}
