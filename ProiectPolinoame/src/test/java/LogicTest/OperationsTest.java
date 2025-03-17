package LogicTest;

import Logic.Operations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class OperationsTest {
    private TreeMap<Integer, Double> firstPolynomial = new TreeMap<>(Collections.reverseOrder());
    private TreeMap<Integer, Double> secondPolynomial = new TreeMap<>(Collections.reverseOrder());
    private TreeMap<Integer, Double> resultPolynomial = new TreeMap<>(Collections.reverseOrder());
    private TreeMap<Integer, Double> expectedPolynomial = new TreeMap<>(Collections.reverseOrder());
    private TreeMap<Integer, Double> expectedRemainderPolynomial = new TreeMap<>(Collections.reverseOrder());
    Operations operations = new Operations();

    public void firstTestSet() {
        firstPolynomial.clear();
        secondPolynomial.clear();
        firstPolynomial.put(2, 1.0);
        firstPolynomial.put(1, 2.0);
        firstPolynomial.put(0, -3.0);

        secondPolynomial.put(1, 1.0);
        secondPolynomial.put(0, 2.0);
    }

    public void secondTestSet() {
        firstPolynomial.clear();
        secondPolynomial.clear();
        firstPolynomial.put(4, 1.0);
        firstPolynomial.put(2, -4.0);
        firstPolynomial.put(0, -2.0);

        secondPolynomial.put(2, 1.0);
        secondPolynomial.put(1, 1.0);
        secondPolynomial.put(0, -2.0);
    }

    @Test
    public void addTest() {
        firstTestSet();
        resultPolynomial = operations.add(firstPolynomial, secondPolynomial);
        expectedPolynomial.clear();
        expectedPolynomial.put(2, 1.0);
        expectedPolynomial.put(1, 3.0);
        expectedPolynomial.put(0, -1.0);
        assertEquals(expectedPolynomial, resultPolynomial);

        secondTestSet();
        expectedPolynomial.clear();
        resultPolynomial = operations.add(firstPolynomial, secondPolynomial);
        expectedPolynomial.put(4, 1.0);
        expectedPolynomial.put(2, -3.0);
        expectedPolynomial.put(1, 1.0);
        expectedPolynomial.put(0, -4.0);
        assertEquals(expectedPolynomial, resultPolynomial);
    }

    @Test
    public void subTest() {
        firstTestSet();
        resultPolynomial = operations.sub(firstPolynomial, secondPolynomial);
        expectedPolynomial.clear();
        expectedPolynomial.put(2, 1.0);
        expectedPolynomial.put(1, 1.0);
        expectedPolynomial.put(0, -5.0);
        assertEquals(expectedPolynomial, resultPolynomial);

        secondTestSet();
        resultPolynomial = operations.sub(firstPolynomial, secondPolynomial);
        expectedPolynomial.clear();
        expectedPolynomial.put(4, 1.0);
        expectedPolynomial.put(2, -5.0);
        expectedPolynomial.put(1, -1.0);
        assertEquals(expectedPolynomial, resultPolynomial);
    }

    @Test
    public void mulTest() {
        firstTestSet();
        resultPolynomial = operations.mul(firstPolynomial, secondPolynomial);
        expectedPolynomial.clear();
        expectedPolynomial.put(3, 1.0);
        expectedPolynomial.put(2, 4.0);
        expectedPolynomial.put(1, 1.0);
        expectedPolynomial.put(0, -6.0);
        assertEquals(expectedPolynomial, resultPolynomial);

        secondTestSet();
        resultPolynomial = operations.mul(firstPolynomial, secondPolynomial);
        expectedPolynomial.clear();
        expectedPolynomial.put(6, 1.0);
        expectedPolynomial.put(5, 1.0);
        expectedPolynomial.put(4, -6.0);
        expectedPolynomial.put(3, -4.0);
        expectedPolynomial.put(2, 6.0);
        expectedPolynomial.put(1, -2.0);
        expectedPolynomial.put(0, 4.0);
        assertEquals(expectedPolynomial, resultPolynomial);
    }

    @Test
    public void divTest() {
        firstTestSet();
        resultPolynomial = operations.div(firstPolynomial, secondPolynomial);
        expectedPolynomial.clear();
        expectedRemainderPolynomial.clear();
        expectedPolynomial.put(1, 1.0);
        expectedRemainderPolynomial.put(0, -3.0);
        assertEquals(expectedPolynomial, resultPolynomial);
        assertEquals(expectedRemainderPolynomial, firstPolynomial);

        secondTestSet();
        resultPolynomial = operations.div(firstPolynomial, secondPolynomial);
        expectedPolynomial.clear();
        expectedRemainderPolynomial.clear();
        expectedPolynomial.put(2, 1.0);
        expectedPolynomial.put(1, -1.0);
        expectedPolynomial.put(0, -1.0);
        expectedRemainderPolynomial.put(1, -1.0);
        expectedRemainderPolynomial.put(0, -4.0);
        assertEquals(expectedPolynomial, resultPolynomial);
        assertEquals(expectedRemainderPolynomial, firstPolynomial);
    }

    @Test
    public void derivativeTest() {
        firstTestSet();
        resultPolynomial = operations.derivative(firstPolynomial);
        expectedPolynomial.clear();
        expectedPolynomial.put(1, 2.0);
        expectedPolynomial.put(0, 2.0);
        assertEquals(expectedPolynomial, resultPolynomial);

        secondTestSet();
        resultPolynomial = operations.derivative(firstPolynomial);
        expectedPolynomial.clear();
        expectedPolynomial.put(3, 4.0);
        expectedPolynomial.put(1, -8.0);
        assertEquals(expectedPolynomial, resultPolynomial);
    }

    @Test
    public void integralTest() {
        firstTestSet();
        resultPolynomial = operations.integral(firstPolynomial);
        expectedPolynomial.clear();
        expectedPolynomial.put(3, 0.33);
        expectedPolynomial.put(2, 1.0);
        expectedPolynomial.put(1, -3.0);
        assertEquals(expectedPolynomial, resultPolynomial);

        secondTestSet();
        resultPolynomial = operations.integral(firstPolynomial);
        expectedPolynomial.clear();
        expectedPolynomial.put(5, 0.2);
        expectedPolynomial.put(3, -1.33);
        expectedPolynomial.put(1, -2.0);
        assertEquals(expectedPolynomial, resultPolynomial);
    }
}
