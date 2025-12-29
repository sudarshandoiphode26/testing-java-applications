package dev.darsh;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("This class test mathematical functionalities")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    int a, b;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Executing beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Executing afterAll");
    }

    static Stream<Arguments> mul() {
        return Stream.of(Arguments.of(1, 2, 2),
                Arguments.of(2, 2, 4));
    }

    @BeforeEach
    void setUp() {
        System.out.println("Executing BeforeEach");
        a = 10;
        b = 5;
    }

    @AfterEach
    void tearDown() {
        a = 0;
        b = 0;
        System.out.println("Executing afterEach");
    }

    @Test
    @DisplayName("Test addition of 2 numbers ")
    @Disabled("WOrk on this")
    void add() {
        //Arrange
        Calculator c = new Calculator();

        //Act
        int result = c.add(a, b);

        //Assert
        assertEquals(15, result, "The sum of a+b should be 15");
    }

    @Test
    void sub() {
        Calculator c = new Calculator();
        int result = c.sub(a, b);
        assertEquals(5, result, "The subtraction of a-b should be 5");
    }

    @ParameterizedTest
    @MethodSource()
    void mul(int val1, int val2, int expected) {
        Calculator c = new Calculator();
        int result = c.mul(val1, val2);
        assertEquals(expected, result, () -> "The multiplication of a*b should be 50");
    }

    @ParameterizedTest
    @CsvSource({
            "6, 2, 3",
            "6, 3, 2"
    })
    void div(int num1, int num2, int expected) {
        Calculator c = new Calculator();
        int result = c.div(num1, num2);
        assertEquals(expected, result, "The division of a/b should match expected value");
    }

    @Test
    void testDiv_throwsArithmeticException_whenDivisionByZero() {
        Calculator c = new Calculator();
        assertThrows(ArithmeticException.class, ()-> c.div(5, 0),  () -> "Division by zero should throw ArithmeticException");
    }

}