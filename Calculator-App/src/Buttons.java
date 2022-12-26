import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Buttons extends JButton {

    public JButton b1 = new JButton("1");
    public JButton b2 = new JButton("2");
    public JButton b3 = new JButton("3");
    public JButton b4 = new JButton("4");
    public JButton b5 = new JButton("5");
    public JButton b6 = new JButton("6");
    public JButton b7 = new JButton("7");
    public JButton b8 = new JButton("8");
    public JButton b9 = new JButton("9");
    public JButton b0 = new JButton("0");
    public JButton bx = new JButton("×");
    public JButton bd = new JButton("÷");
    public JButton ba = new JButton("+");
    public JButton bm = new JButton("-");
    public JButton d = new JButton(".");
    public JButton clear = new JButton("C");
    public JButton back = new JButton("Back");
    public JButton e = new JButton("=");
    public JButton w = new JButton("");
    public JButton w1 = new JButton("");

    public Buttons(){
        StyleButtons();
    }

    private void StyleButtons(){

        Font small = new Font("Helvetica", Font.BOLD, 14);
        Font big = new Font("Helvetica",Font.BOLD,32);
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
    }
}
