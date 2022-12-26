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
                textField.setText(textField.getText()+ text);
            }
        });
    }

    private void backButtonActionListener(JButton button, JTextField textField){
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
                textField.setText("");
            }
        });
    }

    private void equalButtonActionListener(JButton button, JTextField textField){
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String c;
                c = textField.getText();
                char[] arr = c.toCharArray();
                ArrayList<Integer> pos = new ArrayList<>();
                char j = '+';
                int counter = 0;
                ArrayList<String> arr2 = new ArrayList<>();

                for (int x = 0;x < arr.length; x++){
                    if (arr[x] != '1'&&arr[x] != '0'&&arr[x] != '2'&&arr[x] != '3'&&arr[x] != '4'&&arr[x] != '5'&&arr[x] != '6'&&arr[x] != '7'&&arr[x] != '8'&&arr[x] != '9'){
                        pos.add(x);
                        counter++;
                    }
                }
                pos.add(c.length());
                String[] i = new String[counter+1];
                arr2.add(c.substring(0,pos.get(0)));
                arr2.add(c.substring(pos.get(0)+1,pos.get(1)));
                for (int y = 1; y < pos.size() - 1;y++) {
                    arr2.add(c.substring(pos.get(y)+1,pos.get(y+1)));
                }

                int f = arr[0];
                Double[] prime = new Double[arr2.size()];
                for (int x = 0; x < arr2.size(); x++){
                    prime[x] = Double.parseDouble(arr2.get(x));
                }

                System.out.println(Arrays.toString(prime));
                System.out.println(pos);

                //if the next element and the previous element both do not equal a symbol then it's fine. Else, math error
                //Division by 0
                //Binary Tree for calculation?
                //negative numbers
                Double count = 0d;

                if (arr[pos.get(0)] == ('×')) {
                    count = prime[0]*prime[1];
                }
                if (arr[pos.get(0)] == ('÷')) {
                    count = prime[0]/prime[1];
                }
                if (arr[pos.get(0)] == ('+')) {
                    count = prime[0]+prime[1];
                }

                if (arr[pos.get(0)] == ('-')) {
                    count = prime[0]-prime[1];
                }

                for (int g = 1; g < prime.length-1; g++){
                    if (arr[pos.get(g)] == ('×')) {
                        count = count*prime[g+1];
                    }
                    if (arr[pos.get(g)] == ('÷')) {
                        count = count/prime[g+1];
                    }
                    if (arr[pos.get(g)] == ('+')) {
                        count = count+prime[g+1];
                    }

                    if (arr[pos.get(g)] == ('-')) {
                        count = count-prime[g+1];
                    }

                }
                textField.setText(String.valueOf(count));
            }
        });
    }
}
