package OOP;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FillAll extends Dialog {

    public FillAll(Frame parent,String msg) {

            super(parent, "Error",true);
            setSize(600, 200);

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            });

            setLayout(null);
            setFont(new Font("Dialog", Font.BOLD, 20));
            Label l = new Label(msg);
            add(l);
            l.setBounds(50, 100, 500, 30);

    }
}
