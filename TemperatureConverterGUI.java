import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class TemperatureConverterGUI 
{
    public static void main(String[] args) 
    {
        JFrame frame=new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) 
    {
        panel.setLayout(null);
        JLabel valueLabel = new JLabel("Enter temperature:");
        valueLabel.setBounds(10, 20, 150, 25);
        panel.add(valueLabel);
        JTextField valueText = new JTextField(20);
        valueText.setBounds(180, 20, 165, 25);
        panel.add(valueText);
        JLabel fromUnitLabel = new JLabel("From Unit:");
        fromUnitLabel.setBounds(10, 60, 80, 25);
        panel.add(fromUnitLabel);
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> fromUnitBox = new JComboBox<>(units);
        fromUnitBox.setBounds(180, 60, 165, 25);
        panel.add(fromUnitBox);
        JLabel toUnitLabel = new JLabel("To Unit:");
        toUnitLabel.setBounds(10, 100, 80, 25);
        panel.add(toUnitLabel);
        JComboBox<String> toUnitBox = new JComboBox<>(units);
        toUnitBox.setBounds(180, 100, 165, 25);
        panel.add(toUnitBox);
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(10, 140, 100, 25);
        panel.add(convertButton);
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(10, 180, 300, 25);
        panel.add(resultLabel);
        convertButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    double value = Double.parseDouble(valueText.getText());
                    String fromUnit = (String) fromUnitBox.getSelectedItem();
                    String toUnit = (String) toUnitBox.getSelectedItem();
                    double result = TemperatureConverter.convertTemperature(value, fromUnit, toUnit);
                    resultLabel.setText(String.format("%.2f %s is equal to %.2f %s", value, fromUnit, result, toUnit));
                } 
                catch (NumberFormatException ex) 
                {
                    resultLabel.setText("Please enter a valid temperature value.");
                }
            }
        });
    }
}
