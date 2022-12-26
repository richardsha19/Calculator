import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator {
    //Calculator constructor
    Calculator(){
        JFrame f = new JFrame("Calculator");
        f.setSize(300,400);
        JTextField a = new JTextField();
        a.setBounds(2,5,280,60);
        f.setResizable(false);
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton bx = new JButton("×");
        JButton bd = new JButton("÷");
        JButton ba = new JButton("+");
        JButton bm = new JButton("-");
        JButton d = new JButton(".");
        JButton clear = new JButton("C");
        JButton back = new JButton("B");
        JButton e = new JButton("=");
        JButton w = new JButton("");
        JButton w1 = new JButton("");

        Font small = new Font("Helvetica", Font.BOLD, 14);
        Font big = new Font("Helvetica",Font.BOLD,32);

        a.setFont(big);
        b1.setFont(small);
        b2.setFont(small);
        b3.setFont(small);
        b4.setFont(small);
        b5.setFont(small);
        b6.setFont(small);
        b7.setFont(small);
        b8.setFont(small);
        b9.setFont(small);
        b0.setFont(small);
        bx.setFont(small);
        bd.setFont(small);
        ba.setFont(small);
        bm.setFont(small);
        d.setFont(small);
        clear.setFont(small);
        back.setFont(small);
        e.setFont(small);
        w.setFont(small);
        w1.setFont(small);

        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        b3.setBackground(Color.white);
        b4.setBackground(Color.white);
        b5.setBackground(Color.white);
        b6.setBackground(Color.white);
        b7.setBackground(Color.white);
        b8.setBackground(Color.white);
        b9.setBackground(Color.white);
        b0.setBackground(Color.white);
        bx.setBackground(Color.white);
        bd.setBackground(Color.white);
        ba.setBackground(Color.white);
        bm.setBackground(Color.white);
        d.setBackground(Color.white);
        clear.setBackground(Color.white);
        back.setBackground(Color.white);
        e.setBackground(Color.white);
        w.setBackground(Color.white);
        w1.setBackground(Color.white);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,4));
        panel.setBounds(2,75,280,275);
        panel.setBackground(Color.white);

        panel.add(clear); panel.add(bd); panel.add(bx); panel.add(back); panel.add(b7); panel.add(b8); panel.add(b9);
        panel.add(bm);panel.add(b4); panel.add(b5); panel.add(b6); panel.add(ba); panel.add(b1); panel.add(b2);panel.add(b3);
        panel.add(w1); panel.add(w);panel.add(b0); panel.add(d);panel.add(e);

        f.add(panel);
        f.add(a);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        String text = "";
        String finalText = text;
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "1");
            }
        });
        text = a.getText();
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "2");
            }
        });
        text = a.getText();
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "3");
            }
        });
        text = a.getText();
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "4");

            }
        });
        text = a.getText();
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "5");
            }
        });
        text = a.getText();
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "6" );
            }
        });
        text = a.getText();
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "7");
            }
        });
        text = a.getText();
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "8");
            }
        });
        text = a.getText();
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "9");
            }
        });
        text = a.getText();
        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "0");
            }
        });
        text = a.getText();
        bx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "×");
            }
        });
        text = a.getText();
        bd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "÷");
            }
        });
        text = a.getText();
        ba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+ "+" );
            }
        });
        text = a.getText();
        bm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText( a.getText()+ "-");
            }
        });
        text = a.getText();
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText("");
            }
        });

        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.setText(a.getText()+".");
            }
        });

        e.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String c;
                c = a.getText();
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
                a.setText(String.valueOf(count));
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String c;
                c = a.getText();
                char[] t = c.toCharArray();
                char[] t1 = new char[t.length-1];

                for (int x = 0; x < t.length-1; x++){
                    t1[x] = t[x];
                }
                c = String.copyValueOf(t1);
                a.setText(c);
            }
        });
    }
}
