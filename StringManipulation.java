import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StringManipulation extends JFrame implements ActionListener {
    JLabel inputLabel, outputLabel;
    JTextField inputField, outputField;
    JButton[] buttons;
    String[] buttonLabels = {"In Capital", "In Small", "Converted Case", "Words", "Letters", "Reverse", "Vowels", "Frequency", "Begin Caps", "Reset"};

    public StringManipulation() {
        setTitle("String Manipulation");
        setSize(800, 600);
        setLayout(null);
        getContentPane().setBackground(Color.PINK);

        inputLabel = new JLabel("Enter String:");
        inputLabel.setBounds(20, 120, 100, 30);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(170, 120, 585, 30);
        add(inputField);

        outputLabel = new JLabel("Output:");
        outputLabel.setBounds(20, 160, 100, 30);
        add(outputLabel);

        outputField = new JTextField();
        outputField.setBounds(170, 160, 585, 30);
        outputField.setEditable(false);
        add(outputField);

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setBounds(20 + (i % 2) * 380, 250 + (i / 2) * 50, 350, 30);
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        String operation = "";
        if (e.getSource() == buttons[0]) {
            outputField.setText(input.toUpperCase());
            operation = "In Capital";
        } else if (e.getSource() == buttons[1]) {
            outputField.setText(input.toLowerCase());
            operation = "In Small";
        } else if (e.getSource() == buttons[2]) {
            StringBuilder result = new StringBuilder();
            for (char c : input.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    result.append(Character.toUpperCase(c));
                } else if (Character.isUpperCase(c)) {
                    result.append(Character.toLowerCase(c));
                } else {
                    result.append(c);
                }
            }
            outputField.setText(result.toString());
            operation = "Converted Case";
        } else if (e.getSource() == buttons[3]) {
            String[] words = input.split("\\s+");
            outputField.setText(String.valueOf(words.length));
            operation = "Words";
        } else if (e.getSource() == buttons[4]) {
            outputField.setText(String.valueOf(input.length()));
            operation = "Letters";
        } else if (e.getSource() == buttons[5]) {
            StringBuilder reversed = new StringBuilder(input);
            outputField.setText(reversed.reverse().toString());
            operation = "Reverse";
        } else if (e.getSource() == buttons[6]) {
            int vowels = 0;
            for (char c : input.toCharArray()) {
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    vowels++;
                }
            }
            outputField.setText(String.valueOf(vowels));
            operation = "Vowels";
        } else if (e.getSource() == buttons[7]) {
            // Calculate frequency of each character
            StringBuilder result = new StringBuilder();
            for (char c = 'a'; c <= 'z'; c++) {
                int count = 0;
                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(j) == c || input.charAt(j) == (char)(c - 32)) {
                        count++;
                    }
                }
                if (count > 0) {
                    result.append(c).append(": ").append(count).append(", ");
                }
            }
            outputField.setText(result.toString());
            operation = "Frequency";
        } else if (e.getSource() == buttons[8]) {
            String[] words = input.split("\\s+");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
            outputField.setText(result.toString().trim());
            operation = "Begin Caps";
        } else if (e.getSource() == buttons[9]) {
            inputField.setText("");
            outputField.setText("");
            operation = "Reset";
        }
        outputLabel.setText("Output (" + operation + "):");
    }

    public static void main(String[] args) {
        new StringManipulation();
    }
}
