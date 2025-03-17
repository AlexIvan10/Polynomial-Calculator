package Interface;

import Logic.Operations;
import Model.Polynomial;

import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;

public class Controller {
    private Polynomial polynomial = new Polynomial();
    private Operations operations = new Operations();
    private View controllerView;
    private TreeMap<Integer, Double> firstPolynomial = new TreeMap<>(Collections.reverseOrder());
    private TreeMap<Integer, Double> secondPolynomial = new TreeMap<>(Collections.reverseOrder());

    public Controller(View view) {
        controllerView = view;

        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addMulListener(new MulListener());
        view.addDivListener(new DivListener());
        view.addDerivativeListener(new DerivativeListener());
        view.addIntegralListener(new IntegralListener());
    }

    public boolean performPolynomialExtract() {
        String firstPolynomialString = controllerView.getFirstPolynomial();
        String secondPolynomialString = controllerView.getSecondPolynomial();

        firstPolynomial = polynomial.getPolynomialMap(firstPolynomialString);
        if (firstPolynomial == null) {
            return false;
        }

        secondPolynomial = polynomial.getPolynomialMap(secondPolynomialString);
        if (secondPolynomial == null) {
            return false;
        }
        return true;
    }

    public boolean performFirstPolynomialExtract() {
        String firstPolynomialString = controllerView.getFirstPolynomial();

        firstPolynomial = polynomial.getPolynomialMap(firstPolynomialString);
        if (firstPolynomial == null) {
            return false;
        }

        return true;
    }

    public void invalidInput() {
        controllerView.clearResultPolynomialText();
        controllerView.clearRemainderPolynomialText();
        controllerView.setErrorMessageText();
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean validPolynoms = performPolynomialExtract();

            if (validPolynoms) {
                controllerView.clearErrorMessageText();
                controllerView.clearRemainderPolynomialText();
                firstPolynomial =  operations.add(firstPolynomial, secondPolynomial);
                controllerView.setResultPolynomialText(polynomial.toString(firstPolynomial));
            } else {
                invalidInput();
            }
        }
    }

    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean validPolynoms = performPolynomialExtract();

            if (validPolynoms) {
                controllerView.clearErrorMessageText();
                controllerView.clearRemainderPolynomialText();
                firstPolynomial = operations.sub(firstPolynomial, secondPolynomial);
                controllerView.setResultPolynomialText(polynomial.toString(firstPolynomial));
            } else {
                invalidInput();
            }
        }
    }

    class MulListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean validPolynoms = performPolynomialExtract();

            if (validPolynoms) {
                controllerView.clearErrorMessageText();
                controllerView.clearRemainderPolynomialText();
                firstPolynomial = operations.mul(firstPolynomial, secondPolynomial);
                controllerView.setResultPolynomialText(polynomial.toString(firstPolynomial));
            } else {
                invalidInput();
            }
        }
    }

    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean validPolynoms = performPolynomialExtract();
            TreeMap<Integer, Double> resultPolynomial;

            if(firstPolynomial == null || secondPolynomial == null)
                validPolynoms = false;
            else{
                secondPolynomial.entrySet().removeIf(entry -> entry.getValue() == 0.0);
                if(firstPolynomial.isEmpty() || secondPolynomial.isEmpty())
                    validPolynoms = false;
            }

            if (validPolynoms) {
                controllerView.clearErrorMessageText();
                resultPolynomial = operations.div(firstPolynomial, secondPolynomial);

                if (resultPolynomial == null){
                    controllerView.setResultPolynomialText("0");
                    controllerView.setRemainderPolynomialText(polynomial.toString(firstPolynomial));

                }
                else{
                    controllerView.setResultPolynomialText(polynomial.toString(resultPolynomial));
                    if(firstPolynomial.isEmpty())
                        controllerView.setRemainderPolynomialText("0");
                    else
                        controllerView.setRemainderPolynomialText(polynomial.toString(firstPolynomial));
                }
            }
            else
                invalidInput();
        }
    }

    class DerivativeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean validPolynoms = performFirstPolynomialExtract();

            if (validPolynoms) {
                controllerView.clearErrorMessageText();
                controllerView.clearRemainderPolynomialText();
                firstPolynomial = operations.derivative(firstPolynomial);
                controllerView.setResultPolynomialText(polynomial.toString(firstPolynomial));
            } else {
                invalidInput();
            }
        }
    }

    class IntegralListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean validPolynoms = performFirstPolynomialExtract();

            if (validPolynoms) {
                controllerView.clearErrorMessageText();
                controllerView.clearRemainderPolynomialText();
                firstPolynomial = operations.integral(firstPolynomial);
                controllerView.setResultPolynomialText(polynomial.toString(firstPolynomial));
            } else {
                invalidInput();
            }
        }
    }
}