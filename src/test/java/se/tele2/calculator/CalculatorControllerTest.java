package se.tele2.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import se.tele2.calculator.controller.CalculatorController;
import se.tele2.calculator.model.Calculation;
import se.tele2.calculator.service.CalculatorService;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CalculatorControllerTest {

    @Mock
    private CalculatorService service;

    @InjectMocks
    private CalculatorController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testAdditionEndpoint() throws Exception {
        Calculation calculation = new Calculation("add", 5, 3, 8);
        when(service.performOperation("add", 5, 3)).thenReturn(calculation);

        mockMvc.perform(get("/api/calculator/add")
                        .param("a", "5")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(8))
                .andExpect(jsonPath("$.operation").value("add"));

        verify(service, times(1)).performOperation("add", 5, 3);
    }

    @Test
    public void testSubtractionEndpoint() throws Exception {
        Calculation calculation = new Calculation("subtract", 10, 3, 7);
        when(service.performOperation("subtract", 10, 3)).thenReturn(calculation);

        mockMvc.perform(get("/api/calculator/subtract")
                        .param("a", "10")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(7))
                .andExpect(jsonPath("$.operation").value("subtract"));

        verify(service, times(1)).performOperation("subtract", 10, 3);
    }

    @Test
    public void testMultiplicationEndpoint() throws Exception {
        Calculation calculation = new Calculation("multiply", 5, 4, 20);
        when(service.performOperation("multiply", 5, 4)).thenReturn(calculation);

        mockMvc.perform(get("/api/calculator/multiply")
                        .param("a", "5")
                        .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(20))
                .andExpect(jsonPath("$.operation").value("multiply"));

        verify(service, times(1)).performOperation("multiply", 5, 4);
    }

    @Test
    public void testDivisionEndpoint() throws Exception {
        Calculation calculation = new Calculation("divide", 10, 2, 5);
        when(service.performOperation("divide", 10, 2)).thenReturn(calculation);

        mockMvc.perform(get("/api/calculator/divide")
                        .param("a", "10")
                        .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5))
                .andExpect(jsonPath("$.operation").value("divide"));

        verify(service, times(1)).performOperation("divide", 10, 2);
    }

    @Test
    public void testGetHistory() throws Exception {
        Calculation calculation1 = new Calculation("add", 5, 3, 8);
        Calculation calculation2 = new Calculation("multiply", 5, 4, 20);
        when(service.getAllCalculations()).thenReturn(Arrays.asList(calculation1, calculation2));

        mockMvc.perform(get("/api/calculator/history")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].result").value(8))
                .andExpect(jsonPath("$[1].result").value(20));

        verify(service, times(1)).getAllCalculations();
    }
}
