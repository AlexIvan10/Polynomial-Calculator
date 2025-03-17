package Interface;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private JFrame frame = new JFrame("Polynomial Calculator");
    private JPanel fullPanel = new JPanel();
    private JPanel firstPolynomialPanel = new JPanel();
    private JPanel secondPolynomialPanel = new JPanel();
    private JPanel resultPolynomialPanel = new JPanel();
    private JPanel remainderPolynomialPanel = new JPanel();
    private JPanel errorMessagePanel = new JPanel();
    private JPanel buttonsPanel = new JPanel(new GridLayout(3, 2));
    private JButton addButton = new JButton("+");
    private JButton subButton = new JButton("-");
    private JButton mulButton = new JButton("*");
    private JButton divButton = new JButton("/");
    private JButton derivativeButton = new JButton("Derivate");
    private JButton integralButton = new JButton("Integrate");
    private JLabel firstPolynomialLabel = new JLabel("First polynomial");
    private JLabel secondPolynomialLabel = new JLabel("Second polynomial");
    private JLabel resultPolynomialLabel = new JLabel("Result polynomial");
    private JLabel remainderPolynomialLabel = new JLabel("Division remainder");
    private JLabel errorMessageLabel = new JLabel("Error message");
    private JTextField firstPolynomialText = new JTextField();
    private JTextField secondPolynomialText = new JTextField();
    private JTextField resultPolynomialText = new JTextField();
    private JTextField remainderPolynomialText = new JTextField();
    private JTextField errorMessageText = new JTextField();
    private Font font = new JTextField().getFont();
    private Color black = new Color(30, 30, 30);
    private Color gray = new Color(77, 77, 91);
    private Dimension dimensionTextField = new Dimension(500, 40);
    private Dimension dimensionLabel = new Dimension(200, 40);
    private Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

    public View() {
        resultPolynomialText.setEditable(false);
        remainderPolynomialText.setEditable(false);
        errorMessageText.setEditable(false);
        fullPanel.setLayout(new BoxLayout(fullPanel, BoxLayout.Y_AXIS));

        addLabel(firstPolynomialLabel, firstPolynomialPanel);
        addLabel(secondPolynomialLabel, secondPolynomialPanel);
        addLabel(resultPolynomialLabel, resultPolynomialPanel);
        addLabel(remainderPolynomialLabel, remainderPolynomialPanel);
        addLabel(errorMessageLabel, errorMessagePanel);

        addTextField(firstPolynomialText, firstPolynomialPanel);
        addTextField(secondPolynomialText, secondPolynomialPanel);
        addTextField(resultPolynomialText, resultPolynomialPanel);
        addTextField(remainderPolynomialText, remainderPolynomialPanel);
        addTextField(errorMessageText, errorMessagePanel);

        addButtons(addButton, buttonsPanel);
        addButtons(subButton, buttonsPanel);
        addButtons(mulButton, buttonsPanel);
        addButtons(divButton, buttonsPanel);
        addButtons(derivativeButton, buttonsPanel);
        addButtons(integralButton, buttonsPanel);

        addPanel(fullPanel, firstPolynomialPanel);
        addPanel(fullPanel, secondPolynomialPanel);
        addPanel(fullPanel, resultPolynomialPanel);
        addPanel(fullPanel, remainderPolynomialPanel);
        addPanel(fullPanel, errorMessagePanel);
        addPanel(fullPanel, buttonsPanel);

        Dimension displayDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (displayDimension.width - frame.getWidth()) / 5;
        int y = (displayDimension.height - frame.getHeight()) / 5;
        fullPanel.setBackground(black);
        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1000, 700);
        frame.add(fullPanel);
        frame.setVisible(true);

    }

    public void addLabel(JLabel label, JPanel panel) {
        label.setPreferredSize(dimensionLabel);
        label.setForeground(Color.WHITE);
        label.setFont(font.deriveFont(20.0f));
        panel.add(label);
    }

    public void addTextField(JTextField textField, JPanel panel) {
        textField.setPreferredSize(dimensionTextField);
        textField.setBackground(gray);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font(font.getName(), font.getStyle(), 20));
        textField.setBorder(border);
        panel.add(textField);
    }

    public void addButtons(JButton button, JPanel panel) {
        button.setFont(new Font(button.getName(), Font.PLAIN, 20));
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setBackground(gray);
        panel.add(button);
    }

    public void addAddListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void addSubListener(ActionListener actionListener) {
        subButton.addActionListener(actionListener);
    }

    public void addMulListener(ActionListener actionListener) {
        mulButton.addActionListener(actionListener);
    }

    public void addDivListener(ActionListener actionListener) {
        divButton.addActionListener(actionListener);
    }

    public void addDerivativeListener(ActionListener actionListener) {
        derivativeButton.addActionListener(actionListener);
    }

    public void addIntegralListener(ActionListener actionListener) {
        integralButton.addActionListener(actionListener);
    }

    public void addPanel(JPanel panel1, JPanel panel2) {
        panel2.setBackground(black);
        panel1.add(panel2);
    }

    public String getFirstPolynomial() {
        return firstPolynomialText.getText();
    }

    public String getSecondPolynomial() {
        return secondPolynomialText.getText();
    }

    public void setResultPolynomialText(String result) {
        if (result.isEmpty())
            resultPolynomialText.setText("0");
        else
            resultPolynomialText.setText(result);
    }

    public void setRemainderPolynomialText(String remainder) {
        remainderPolynomialText.setText(remainder);
    }

    public void setErrorMessageText() {
        errorMessageText.setText("Invalid input");
    }

    public void clearErrorMessageText() {
        errorMessageText.setText("");
    }

    public void clearResultPolynomialText() {
        resultPolynomialText.setText("");
    }

    public void clearRemainderPolynomialText() {
        remainderPolynomialText.setText("");
    }
}
