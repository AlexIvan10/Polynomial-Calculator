package Model;

import java.util.*;
import java.util.regex.*;

public class Polynomial {

    public TreeMap<Integer, Double> getPolynomialMap(String input) {
        TreeMap<Integer, Double> polynomial = new TreeMap<>(Collections.reverseOrder());
        String regex = "([+-]?\\d*)?\\*?(x)?\\^?(\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean firstMonom = false;

        while (matcher.find()) {
            String coefficientString = matcher.group(1);
            String xString = matcher.group(2);
            String exponentString = matcher.group(3);

            if (!coefficientString.isEmpty() || xString != null || exponentString != null) {
                double coefficient = 0.0;
                int exponent;

                if (!firstMonom) {
                    firstMonom = true;
                } else {
                    if (coefficientString.isEmpty()) {
                        System.out.println("1");
                        return null;
                    } else if (!coefficientString.startsWith("-") && !coefficientString.startsWith("+")) {
                        System.out.println("2");
                        return null;
                    }
                }

                if (!coefficientString.isEmpty()) {
                    if (coefficientString.equals("-") && xString != null)
                        coefficient = -1;
                    else if (coefficientString.equals("+") && xString != null)
                        coefficient = 1;
                    else {
                        try {
                            coefficient = Double.parseDouble(coefficientString);
                        } catch (Exception e) {
                            return null; // Exemplu input invalid: x+++
                        }
                    }
                }

                if (xString != null) {
                    if (coefficientString.isEmpty())
                        coefficient = 1;
                    if (exponentString != null)
                        exponent = Integer.parseInt(exponentString);
                    else
                        exponent = 1;
                } else
                    exponent = 0;


                if (polynomial.containsKey(exponent)) {
                    polynomial.put(exponent, polynomial.get(exponent) + coefficient);
                } else {
                    polynomial.put(exponent, coefficient);
                }

            }
        }

        return polynomial;
    }

    public String getPolynomialPretty(double coefficient, int exponent) {
        String result = "";
        if (exponent == 0) {
            if (coefficient != 0)
                result += Math.abs(coefficient) + " ";
        } else if (exponent == 1) {
            if (coefficient == 1 || coefficient == -1)
                result += "x" + " ";
            else if (coefficient != 0)
                result += Math.abs(coefficient) + "*x" + " ";
        } else {
            if (coefficient == 1 || coefficient == -1)
                result += "x^" + exponent + " ";
            else if (coefficient != 0)
                result += Math.abs(coefficient) + "*x^" + exponent + " ";
        }
        return result;
    }

    public String toString(TreeMap<Integer, Double> polynomial) {
        boolean firstMonom = true;
        String result = "";

        if (polynomial != null) {
            for (Map.Entry<Integer, Double> entry : polynomial.entrySet()) {
                double coefficient = entry.getValue();
                int exponent = entry.getKey();

                if (firstMonom) {
                    if (coefficient < 0) {
                        result += "- " + getPolynomialPretty(coefficient, exponent);
                    } else if (coefficient > 0) {
                        result += getPolynomialPretty(coefficient, exponent);
                    }
                    if (coefficient != 0) {
                        firstMonom = false;
                    }
                } else {
                    String tempResult = getPolynomialPretty(coefficient, exponent);
                    if (!tempResult.isEmpty()) {
                        if (coefficient > 0) {
                            result += "+ " + tempResult;
                        } else {
                            result += "- " + tempResult;
                        }
                    }
                }
            }
        }
        return result.trim();
    }
}
