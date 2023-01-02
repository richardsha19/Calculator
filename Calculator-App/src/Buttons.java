import javax.swing.*;
import java.awt.*;

public class Buttons extends JButton {

    //Creating the buttons
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
    JButton back = new JButton("Back");
    JButton e = new JButton("=");
    JButton w = new JButton("");
    JButton w1 = new JButton("");

    public Buttons(){
        StyleButtons();
    }

    private void StyleButtons(){

        // Styles the buttons
        //Setting big and small fonts
        Font small = new Font("Helvetica", Font.BOLD, 14);
        Font big = new Font("Helvetica",Font.BOLD,32);

        //Setting the font size
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

        //Setting background colour of the buttons
        b1.setBackground(Color.lightGray);
        b2.setBackground(Color.lightGray);
        b3.setBackground(Color.lightGray);
        b4.setBackground(Color.lightGray);
        b5.setBackground(Color.lightGray);
        b6.setBackground(Color.lightGray);
        b7.setBackground(Color.lightGray);
        b8.setBackground(Color.lightGray);
        b9.setBackground(Color.lightGray);
        b0.setBackground(Color.lightGray);
        bx.setBackground(Color.lightGray);
        bd.setBackground(Color.lightGray);
        ba.setBackground(Color.ORANGE);
        bm.setBackground(Color.orange);
        d.setBackground(Color.lightGray);
        clear.setBackground(Color.lightGray);
        back.setBackground(Color.orange);
        e.setBackground(Color.orange);
        w.setBackground(Color.lightGray);
        w1.setBackground(Color.orange);
    }
}
