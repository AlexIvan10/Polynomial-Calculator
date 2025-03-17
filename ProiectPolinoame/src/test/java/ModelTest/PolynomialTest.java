package ModelTest;

import Model.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class PolynomialTest {
    Polynomial polynomial = new Polynomial();

    @Test
    public void getPolynomialMapTest() {
        TreeMap<Integer, Double> result;
        TreeMap<Integer, Double> expected = new TreeMap<>(Collections.reverseOrder());

        result = polynomial.getPolynomialMap("x^2+2*x-1");
        expected.put(2, 1.0);
        expected.put(1, 2.0);
        expected.put(0, -1.0);
        assertEquals(expected, result);

        expected.clear();
        result = polynomial.getPolynomialMap("-3*x^4-2*x^2+x^2+35");
        expected.put(4, -3.0);
        expected.put(2, -1.0);
        expected.put(0, 35.0);
        assertEquals(expected, result);
    }

    @Test
    public void toStringTest(){
        String result;
        String expected;
        TreeMap<Integer, Double> polynomialMap = new TreeMap<>(Collections.reverseOrder());

        polynomialMap.put(3, -1.0);
        polynomialMap.put(1, -5.0);
        polynomialMap.put(0, 3.0);
        result = polynomial.toString(polynomialMap);
        expected = "- x^3 - 5.0*x + 3.0";
        assertEquals(expected, result);

        polynomialMap.put(5, 2.0);
        polynomialMap.put(1, -3.0);
        polynomialMap.put(0, -2.0);
        polynomialMap.put(3, -5.0);
        result = polynomial.toString(polynomialMap);
        expected = "2.0*x^5 - 5.0*x^3 - 3.0*x - 2.0";
        assertEquals(expected, result);
    }
}
