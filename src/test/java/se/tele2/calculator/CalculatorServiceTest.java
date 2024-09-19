package se.tele2.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import se.tele2.calculator.model.Calculation;
import se.tele2.calculator.repository.CalculationRepository;
import se.tele2.calculator.service.CalculatorService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CalculatorServiceTest {

    @Mock
    private CalculationRepository repository;

    @InjectMocks
    private CalculatorService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddition() {
        // Mock the save method to return the same Calculation object
        Calculation mockCalculation = new Calculation("add", 5, 3, 8);
        when(repository.save(any(Calculation.class))).thenReturn(mockCalculation);

        // Test addition operation
        Calculation calculation = service.performOperation("add", 5, 3);
        assertNotNull(calculation);  // Ensure calculation is not null
        assertEquals(8, calculation.getResult());
        assertEquals("add", calculation.getOperation());
        verify(repository, times(1)).save(any(Calculation.class));
    }

    @Test
    public void testSubtraction() {
        // Mock the save method to return the same Calculation object
        Calculation mockCalculation = new Calculation("subtract", 10, 3, 7);
        when(repository.save(any(Calculation.class))).thenReturn(mockCalculation);

        // Test subtraction operation
        Calculation calculation = service.performOperation("subtract", 10, 3);
        assertNotNull(calculation);  // Ensure calculation is not null
        assertEquals(7, calculation.getResult());
        assertEquals("subtract", calculation.getOperation());
        verify(repository, times(1)).save(any(Calculation.class));
    }

    @Test
    public void testMultiplication() {
        // Mock the save method to return the same Calculation object
        Calculation mockCalculation = new Calculation("multiply", 5, 4, 20);
        when(repository.save(any(Calculation.class))).thenReturn(mockCalculation);

        // Test multiplication operation
        Calculation calculation = service.performOperation("multiply", 5, 4);
        assertNotNull(calculation);  // Ensure calculation is not null
        assertEquals(20, calculation.getResult());
        assertEquals("multiply", calculation.getOperation());
        verify(repository, times(1)).save(any(Calculation.class));
    }

    @Test
    public void testDivision() {
        // Mock the save method to return the same Calculation object
        Calculation mockCalculation = new Calculation("divide", 10, 2, 5);
        when(repository.save(any(Calculation.class))).thenReturn(mockCalculation);

        // Test division operation
        Calculation calculation = service.performOperation("divide", 10, 2);
        assertNotNull(calculation);  // Ensure calculation is not null
        assertEquals(5, calculation.getResult());
        assertEquals("divide", calculation.getOperation());
        verify(repository, times(1)).save(any(Calculation.class));
    }

    @Test
    public void testDivisionByZero() {
        // Test division by zero exception
        assertThrows(ArithmeticException.class, () -> {
            service.performOperation("divide", 10, 0);
        });
    }
}
