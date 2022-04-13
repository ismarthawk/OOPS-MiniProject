package OOP;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;


public class Log extends Applet implements ActionListener {

    Label log,id,pass,new_one;
    TextField idt,passt ;
    Button sin,sup;
    String msg;

    public void init() {
        setLayout(null);
        setFont(new Font("Dialog",Font.BOLD,22));
        log = new Label("Login-Page");
        add(log);
        log.setBounds(240,50,400,25);




        id = new Label("User ID :");
        add(id);
        id.setBounds(150,150,100,40);

        idt = new TextField();
        add(idt);
        idt.setBounds(250,150,250,40);

        pass = new Label("Password:");
        add(pass);
        pass.setBounds(120,230,130,40);

        passt = new TextField();
        passt.setEchoChar('*');
        add(passt);
        passt.setBounds(250,230,250,40);

        sin = new Button("Sign-in");
        add(sin);
        sin.setBounds(250,310,100,40);



        new_one = new Label("Need an Account?");
        add(new_one);
        new_one.setBounds(20,350,300,40);

        sup = new Button("Sign-Up");
        add(sup);
        sup.setBounds(250,400,100,40);


        sin.addActionListener(this);
        sup.addActionListener(this);



    }

    public void paint(Graphics g) {
        showStatus(msg);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if(s.equals("Sign-in")) {
            if(idt.getText().equals("") || passt.getText().equals("")) {
                new FillAll((Frame)this.getParent().getParent(),"Please fill all the entries").setVisible(true);
                repaint();
            }
            else {
                try {
                    Connection c = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/javapro?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                            "root","8688466782");
                    msg = "Connection Established";
                    Statement stmt = c.createStatement();
                    String query = "select * from login where id='"+idt.getText()+"'";
                    ResultSet rs = stmt.executeQuery(query);
                    if(rs.next()) {
                        if(passt.getText().equals(rs.getString(2))){
                            new Details(idt.getText());
                        }
                        else {
                            new FillAll((Frame)this.getParent().getParent(),"Incorrect Password").setVisible(true);
                        }
                    }else {
                        new FillAll((Frame)this.getParent().getParent(),"No such user").setVisible(true);

                        idt.setText("");
                        passt.setText("");
                    }

                }catch(SQLException l) {
                    msg = l.getMessage();
                    repaint();

                }
            }
        }
        else if(s.equals("Sign-Up")){
            new Register();
        }


    }


}

