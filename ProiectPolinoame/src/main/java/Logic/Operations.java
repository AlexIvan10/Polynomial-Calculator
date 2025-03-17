package Logic;

import java.text.DecimalFormat;
import java.util.*;

public class Operations implements PolynomialOperations {

    @Override
    public TreeMap<Integer, Double> add(TreeMap<Integer, Double> firstPolynomial, TreeMap<Integer, Double> secondPolynomial) {
        for (Map.Entry<Integer, Double> polynomial : secondPolynomial.entrySet()) {
            if (firstPolynomial.containsKey(polynomial.getKey())) {
                double coefficient = firstPolynomial.get(polynomial.getKey()) + polynomial.getValue();
                firstPolynomial.put(polynomial.getKey(), coefficient);
            } else {
                firstPolynomial.put(polynomial.getKey(), polynomial.getValue());
            }
        }
        firstPolynomial.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        return firstPolynomial;
    }

    @Override
    public TreeMap<Integer, Double> sub(TreeMap<Integer, Double> firstPolynomial, TreeMap<Integer, Double> secondPolynomial) {
        for (Map.Entry<Integer, Double> polynomial : secondPolynomial.entrySet()) {
            if (firstPolynomial.containsKey(polynomial.getKey())) {
                double coefficient = firstPolynomial.get(polynomial.getKey()) - polynomial.getValue();
                firstPolynomial.put(polynomial.getKey(), coefficient);
            } else {
                firstPolynomial.put(polynomial.getKey(), -polynomial.getValue());
            }
        }
        firstPolynomial.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        return firstPolynomial;
    }

    @Override
    public TreeMap<Integer, Double> mul(TreeMap<Integer, Double> firstPolynomial, TreeMap<Integer, Double> secondPolynomial) {
        TreeMap<Integer, Double> result = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Double> polynomialOne : firstPolynomial.entrySet()) {
            for (Map.Entry<Integer, Double> polynomialTwo : secondPolynomial.entrySet()) {
                int exponent = polynomialOne.getKey() + polynomialTwo.getKey();
                double coefficient = polynomialOne.getValue() * polynomialTwo.getValue();

                if (result.containsKey(exponent)) {
                    double resultValue = result.get(exponent);
                    result.put(exponent, resultValue + coefficient);
                } else
                    result.put(exponent, coefficient);
            }
        }
        result.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        return result;
    }

    //Operatia de impartire a doua polinoame
    @Override
    public TreeMap<Integer, Double> div(TreeMap<Integer, Double> firstPolynomial, TreeMap<Integer, Double> secondPolynomial) {

        //Daca cea mai mare putere a celui de-al doilea polinom este mai mare ca a primului polinom nu facem impartirea
        if (firstPolynomial.firstKey() < secondPolynomial.firstKey())
            return null;

        TreeMap<Integer, Double> resultPolynomial = new TreeMap<>(Collections.reverseOrder());
        DecimalFormat format = new DecimalFormat("#.##");

        while (!firstPolynomial.isEmpty() && firstPolynomial.firstKey() >= secondPolynomial.firstKey()) {

            //Obtinem un exponent si coeficient pentru a scapa primul element al primului polinom
            int exponent = firstPolynomial.firstKey() - secondPolynomial.firstKey();
            double coefficient = firstPolynomial.get(firstPolynomial.firstKey()) / secondPolynomial.get(secondPolynomial.firstKey());
            resultPolynomial.put(exponent, Double.parseDouble(format.format(coefficient)));

            TreeMap<Integer, Double> complement = new TreeMap<>(Collections.reverseOrder());

            //Inmultim toate monoamele celui de-al doilea polinom cu coeficientul obtinut
            for (Map.Entry<Integer, Double> polynomial : secondPolynomial.entrySet()) {
                int secondPolynomialExponent = polynomial.getKey();
                double secondPolynomialCoefficient = polynomial.getValue();
                complement.put(secondPolynomialExponent + exponent, secondPolynomialCoefficient * coefficient);
            }

            //Scadem din primul polinom complementul obtinut la pasul 2
            for (Map.Entry<Integer, Double> polynomial : complement.entrySet()) {
                int complementExponent = polynomial.getKey();
                double complementCoefficient = polynomial.getValue();
                double firstPolynomialCoefficient;

                if (firstPolynomial.containsKey(complementExponent))
                    firstPolynomialCoefficient = firstPolynomial.get(complementExponent);
                else
                    firstPolynomialCoefficient = 0;

                double newCoefficient = firstPolynomialCoefficient - complementCoefficient;

                //Daca coeficientul este aproape 0 il eliminam, altfel actualizam coeficientul termenului din primul polinom
                if (Math.abs(newCoefficient) > 0.001)
                    firstPolynomial.put(complementExponent, newCoefficient);
                else {
                    firstPolynomial.remove(complementExponent);
                }
            }
        }
        resultPolynomial.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        return resultPolynomial;
    }

    @Override
    public TreeMap<Integer, Double> derivative(TreeMap<Integer, Double> polynomial) {
        TreeMap<Integer, Double> result = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Double> polynom : polynomial.entrySet()) {
            int exponent = polynom.getKey() - 1;
            double coefficient = polynom.getValue() * polynom.getKey();
            result.put(exponent, coefficient);
        }
        result.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        return result;
    }

    @Override
    public TreeMap<Integer, Double> integral(TreeMap<Integer, Double> polynomial) {
        TreeMap<Integer, Double> result = new TreeMap<>(Collections.reverseOrder());
        DecimalFormat format = new DecimalFormat("#.##");
        for (Map.Entry<Integer, Double> polynom : polynomial.entrySet()) {
            int exponent = polynom.getKey() + 1;
            double coefficient = polynom.getValue() / (polynom.getKey() + 1);
            coefficient = Double.parseDouble(format.format(coefficient));
            result.put(exponent, coefficient);
        }
        result.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        return result;
    }
}