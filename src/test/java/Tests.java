import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({LogExtension.class,TestResultWatcher.class})
public class Tests {
    private Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("== Starting all tests ==");
    }

    @BeforeEach
    void init() {
        calculator = new Calculator();
        System.out.println("-- Starting test --");
    }

    @AfterEach
    void tearDown() {
        System.out.println("-- Ending test --");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("== All tests finished ==");
    }

    @Test
    void testAdd() {
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    void testSubtract() {
        assertEquals(3, calculator.subtract(5, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(10, calculator.multiply(5, 2));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(4, 2));
    }

    @ParameterizedTest(name = "add({0}, {1}) = {2}")
    @CsvSource({
            "1, 2, 3",
            "-1, -1, -2",
            "0, 5, 5"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest(name = "divide({0}, {1}) = {2}")
    @MethodSource("divisionData")
    void testDivide(int a, int b, int expected) {
        assertEquals(expected, calculator.divide(a, b));
    }

    static Stream<Arguments> divisionData() {
        return Stream.of(
                Arguments.of(6, 2, 3),
                Arguments.of(10, 5, 2),
                Arguments.of(-8, 2, -4)
        );
    }
}
