import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
    //Calculator constructor
    Calculator(){
        Buttons b = new Buttons();
        JFrame frame = initializeFrame(b);
    }

    private JFrame initializeFrame(Buttons b){
        JFrame f = new JFrame("Calculator");
        f.setSize(300,400);
        JTextField a = new JTextField();
        a.setText("0");
        a.setBounds(2,5,280,60);

        Font big = new Font("Helvetica",Font.BOLD,32);
        a.setFont(big);
        f.setResizable(false);

        JPanel panel = initializePanel(b);

        f.add(panel);
        f.add(a);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        initializeActionListener(b, a);
        return f;
    }

    private JPanel initializePanel(Buttons b){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,4));
        panel.setBounds(2,75,280,275);
        panel.setBackground(Color.white);

        panel.add(b.clear); panel.add(b.bd); panel.add(b.bx); panel.add(b.back); panel.add(b.b7); panel.add(b.b8); panel.add(b.b9);
        panel.add(b.bm);panel.add(b.b4); panel.add(b.b5); panel.add(b.b6); panel.add(b.ba); panel.add(b.b1); panel.add(b.b2);panel.add(b.b3);
        panel.add(b.w1); panel.add(b.w);panel.add(b.b0); panel.add(b.d);panel.add(b.e);

        return panel;
    }

    private void initializeActionListener(Buttons b, JTextField a){
        addActionListener(b.b1, "1", a);
        addActionListener(b.b2, "2", a);
        addActionListener(b.b3, "3", a);
        addActionListener(b.b4, "4", a);
        addActionListener(b.b5, "5", a);
        addActionListener(b.b6, "6", a);
        addActionListener(b.b7, "7", a);
        addActionListener(b.b8, "8", a);
        addActionListener(b.b9, "9", a);
        addActionListener(b.b0,"0", a);
        addActionListener(b.bx, "×", a);
        addActionListener(b.bd, "÷", a);
        addActionListener(b.ba, "+", a);
        addActionListener(b.bm, "-", a);
        addActionListener(b.d, ".", a);

        clearButtonActionListener(b.clear, a);
        equalButtonActionListener(b.e, a);
        backButtonActionListener(b.back, a);
    }

    private void addActionListener(JButton button, String text, JTextField textField){
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().equals("0")){
                    textField.setText(text);
                }else {
                    textField.setText(textField.getText() + text);
                }
            }
        });
    }

    private void backButtonActionListener(JButton button, JTextField textField){
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String txt = textField.getText();

                if(txt.length() > 1){
                    textField.setText(txt.substring(0, txt.length() - 1));
                }else if(!txt.equals("0")){
                    textField.setText("0");
                }
            }
        });
    }

    private void backButtonActionListener1(JButton button, JTextField textField){
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String c;
                c = textField.getText();
                char[] t = c.toCharArray();

                if(t.length > 0) {
                    char[] t1 = new char[t.length - 1];

                    for (int x = 0; x < t.length - 1; x++) {
                        t1[x] = t[x];
                    }
                    c = String.copyValueOf(t1);
                    textField.setText(c);
                }
            }
        });
    }

    private void clearButtonActionListener(JButton button, JTextField textField) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("0");
            }
        });
    }

    private void equalButtonActionListener(JButton button, JTextField textField){
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String c = textField.getText();
                float count = EqualsButton.calculateValue(c);

                textField.setText(String.valueOf(count));
            }
        });
    }
}
