package OOP;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.*;

public class SuccessDialog extends Dialog  {

    public SuccessDialog(Frame owner, String title) {
        super(owner, title,true);
        setSize(900,400);

        setLayout(null);
        setFont(new Font("Dialog",Font.BOLD,20));
        Label l = new Label("Registration Successful,Please restart");
        add(l);
        l.setBounds(50,100,500,500);
        owner.dispose();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }



}

