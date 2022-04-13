package OOP;

import java.awt.event.*;
import java.awt.*;
public class MyWindowAdapter extends WindowAdapter {

    Frame f ;

    public MyWindowAdapter(Frame f) {
        this.f = f;
    }
    public void windowClosing(WindowEvent e) {
        f.dispose();
    }
}

