import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame {
    private JTextField displayField;
    private JPanel buttonPanel;
    private String currentInput = "";
    private String storedInput = "";
    private String currentOperation = "";

    public CalculatorApp() {
        setTitle("Complex Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Arial", Font.PLAIN, 24));
        add(displayField, BorderLayout.NORTH);

        buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        add(buttonPanel, BorderLayout.CENTER);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "i", "+",
            "C", "(", ")", "="
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "C":
                    currentInput = "";
                    storedInput = "";
                    currentOperation = "";
                    break;
                case "=":
                    if (!storedInput.isEmpty() && !currentInput.isEmpty()) {
                        calculate();
                    }
                    break;
                case "+": case "-": case "*": case "/":
                    if (!currentInput.isEmpty()) {
                        if (!storedInput.isEmpty()) {
                            calculate();
                        }
                        storedInput = currentInput;
                        currentInput = "";
                        currentOperation = command;
                    }
                    break;
                default:
                    currentInput += command;
                    break;
            }
            updateDisplay();
        }
    }

    private void calculate() {
        try {
            Complex c1 = new Complex(storedInput);
            Complex c2 = new Complex(currentInput);
            Complex result;
    
            switch (currentOperation) {
                case "+":
                    result = c1.add(c2);
                    break;
                case "-":
                    result = c1.subtract(c2);
                    break;
                case "*":
                    result = c1.multiply(c2);
                    break;
                case "/":
                    result = c1.divide(c2);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation");
            }
    
            currentInput = result.toString();
            storedInput = "";
            currentOperation = "";
        } catch (Exception ex) {
            currentInput = "Error: " + ex.getMessage();
        }
    }

    private void updateDisplay() {
        if (!storedInput.isEmpty()) {
            displayField.setText(storedInput + " " + currentOperation + " " + currentInput);
        } else {
            displayField.setText(currentInput);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorApp();
            }
        });
    }
}