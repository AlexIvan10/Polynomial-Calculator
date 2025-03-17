package Logic;

import java.util.TreeMap;

public interface PolynomialOperations {
    TreeMap<Integer, Double> add(TreeMap<Integer, Double> firstPolynomial, TreeMap<Integer, Double> secondPolynomial);

    TreeMap<Integer, Double> sub(TreeMap<Integer, Double> firstPolynomial, TreeMap<Integer, Double> secondPolynomial);

    TreeMap<Integer, Double> mul(TreeMap<Integer, Double> firstPolynomial, TreeMap<Integer, Double> secondPolynomial);

    TreeMap<Integer, Double> div(TreeMap<Integer, Double> firstPolynomial, TreeMap<Integer, Double> secondPolynomial);

    TreeMap<Integer, Double> derivative(TreeMap<Integer, Double> polynomial);

    TreeMap<Integer, Double> integral(TreeMap<Integer, Double> polynomial);
}
