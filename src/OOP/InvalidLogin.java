package OOP;

import java.awt.*;
import java.awt.event.*;


public class InvalidLogin extends Dialog {

    public InvalidLogin(Frame owner, String title) {
        super(owner, title,true);
        setSize(900, 400);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLayout(null);
        setFont(new Font("Dialog", Font.BOLD, 20));
        Label l = new Label("Invalid credidentials");
        add(l);
        l.setBounds(50, 100, 500, 500);



    }

}
