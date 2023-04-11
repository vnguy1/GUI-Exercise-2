import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CelsiusToFahrenheit extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField textField;

    public CelsiusToFahrenheit() {
        super("Celsius To Fahrenheit Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        textField = new JTextField(10);
        add(textField);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        add(convertButton);

        JButton exitButton = new JButton("Cancel");
        exitButton.addActionListener(this);
        add(exitButton);
        
        label = new JLabel("Enter a temperature in °C.");
        add(label);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        
        if (event.getActionCommand().equals("Convert")) {
            String input = textField.getText();
            double celsius;
            double fahrenheit;
            try {
                celsius = Double.parseDouble(input);
                fahrenheit = (celsius * 9/5) + 32;
                String result = String.format("%.2f", fahrenheit);
                label.setText(celsius + " °C is " + result + " °F.");
            } 
            catch (NumberFormatException e) {
                label.setText("Please enter a valid temperature in °C.");
            }
        } 
        else if (event.getActionCommand().equals("Cancel")) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new CelsiusToFahrenheit();
    }
}
