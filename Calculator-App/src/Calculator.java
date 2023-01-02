import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    // Calculator constructor
    Calculator(){
        // Creating button components and a window frame
        Buttons buttons = new Buttons();

        // Sets up the JFrame
        JFrame frame = initializeFrame(buttons);
    }

    private JFrame initializeFrame(Buttons buttons){
        // Creates JFrame, sets the size of that frame
        JFrame frame = new JFrame("Calculator");
        frame.setSize(300,400);

        // Creates a JTextField, sets the value inside the JTextField to be equal to "0" and sets the boundaries of the
        // JTextField
        JTextField textField = new JTextField();
        textField.setText("0");
        textField.setBounds(2,5,280,60);

        Font big = new Font("Helvetica",Font.BOLD,32);
        textField.setFont(big);
        frame.setResizable(false);

        JPanel panel = initializePanel(buttons);

        // Adds the panel (That contains all the buttons) and the text field.
        frame.add(panel);
        frame.add(textField);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //
        initializeActionListener(buttons, textField);
        return frame;
    }

    private JPanel initializePanel(Buttons buttons){
        // Sets JPanel with all the buttons in a grid layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,4));
        panel.setBounds(2,75,280,275);
        panel.setBackground(Color.white);

        panel.add(buttons.clear); panel.add(buttons.bd); panel.add(buttons.bx); panel.add(buttons.back);
        panel.add(buttons.b7); panel.add(buttons.b8);panel.add(buttons.b9); panel.add(buttons.bm);panel.add(buttons.b4);
        panel.add(buttons.b5); panel.add(buttons.b6);panel.add(buttons.ba);panel.add(buttons.b1); panel.add(buttons.b2);
        panel.add(buttons.b3); panel.add(buttons.w1); panel.add(buttons.w); panel.add(buttons.b0);panel.add(buttons.d);
        panel.add(buttons.e);

        return panel;
    }

    private void initializeActionListener(Buttons b, JTextField textField){
        // Adds event listeners to all the buttons, which detects if a user has clicked a button.
        addActionListener(b.b1, "1", textField);
        addActionListener(b.b2, "2", textField);
        addActionListener(b.b3, "3", textField);
        addActionListener(b.b4, "4", textField);
        addActionListener(b.b5, "5", textField);
        addActionListener(b.b6, "6", textField);
        addActionListener(b.b7, "7", textField);
        addActionListener(b.b8, "8", textField);
        addActionListener(b.b9, "9", textField);
        addActionListener(b.b0,"0", textField);
        addActionListener(b.bx, "×", textField);
        addActionListener(b.bd, "÷", textField);
        addActionListener(b.ba, "+", textField);
        addActionListener(b.bm, "-", textField);

        clearButtonActionListener(b.clear, textField);
        equalButtonActionListener(b.e, textField);
        backButtonActionListener(b.back, textField);
        decimalButtonActionListener(b.d, textField);
    }

    // default actionListener class applied to most buttons
    private void addActionListener(JButton button, String text, JTextField textField){
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().equals("0")){
                    // If the text is "0", then we replace the "0" with whatever value we want.
                    textField.setText(text);
                }else {
                    // Otherwise, add text to be added to the text already contained in the textField
                    textField.setText(textField.getText() + text);
                }
            }
        });
    }

    // back button
    private void backButtonActionListener(JButton button, JTextField textField){
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String txt = textField.getText();

                //if text in length of text in textField is greater than 1, then set the string as the same text
                // originally in the textField but with one less character at the end
                if(txt.length() > 1){
                    textField.setText(txt.substring(0, txt.length() - 1));
                }else if(!txt.equals("0")){
                    // If the text in textField does not equal "0", then replace it with "0". Otherwise, it is "0" and
                    // we leave it as is.
                    textField.setText("0");
                }
            }
        });
    }

    // decimal button
    private void decimalButtonActionListener(JButton button, JTextField textField) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If the textField is just "0", then the text needs to return "0.". Otherwise, add "." to the value
                // in the textField
                if(textField.getText().equals("0")){
                    textField.setText("0.");
                }else {
                    textField.setText(textField.getText() + ".");
                }
            }
        });
    }

    // clear button
    private void clearButtonActionListener(JButton button, JTextField textField) {
        button.addActionListener(new ActionListener() {
            // Clear would just set the text in the textField to "0"
            public void actionPerformed(ActionEvent e) {
                textField.setText("0");
            }
        });
    }

    // equal button
    private void equalButtonActionListener(JButton button, JTextField textField){
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String c = textField.getText();

                String output;
                try {
                    // Calls EqualsButton.calculateValue static class to calculate the value
                    output = String.valueOf(EqualsButton.calculateValue(c));
                } catch (Exception error){
                    // If the method EqualsButton.calculateValue() returns an error, it is most likely a Math Error,
                    // or something that the math logic in Java cannot understand or handle.
                    output = "Math Error";
                }

                textField.setText(String.valueOf(output));
            }
        });
    }
}
