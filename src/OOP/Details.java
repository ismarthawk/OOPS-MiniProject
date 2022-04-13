package OOP;
import java.awt.*;
import java.sql.*;
//import java.awt.event.*;

//import javax.swing.tree.ExpandVetoException;

public class Details extends Frame {

    Label name, lname, age, address, mname, fname, email, gender, uid, cid1, cid2, nill, nill2;
    TextField n, ln, ag, mn, fn, em, ui;
    TextArea adr;
    Button check, create;
    Choice gn;
    boolean is = false;
    GridBagConstraints gbc = new GridBagConstraints();
    public Details(String id) {
        setTitle("Your Details");
        setSize(600, 700);

        setFont(new Font("Dialog", Font.BOLD, 16));

        setLayout(new GridBagLayout());
        // GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 0;
        name = new Label("Name");
        add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        n = new TextField(20);
        add(n, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 1;
        lname = new Label("Last Name");
        add(lname, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        ln = new TextField(20);
        add(ln, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 2;
        age = new Label("Age");
        add(age, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        ag = new TextField(20);
        add(ag, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 3;
        address = new Label("Address");
        add(address, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        adr = new TextArea(5, 20);
        add(adr, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 4;
        mname = new Label("Mother Name");
        add(mname, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        mn = new TextField(20);
        add(mn, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 5;
        fname = new Label("Father Name");
        add(fname, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        fn = new TextField(20);
        add(fn, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 6;
        email = new Label("E-Mail");
        add(email, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        em = new TextField(20);
        add(em, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 7;
        gender = new Label("Gender");
        add(gender, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gn = new Choice();
        gn.addItem("Male");
        gn.addItem("Female");
        gn.addItem("Other");
        add(gn, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 0;
        gbc.ipady = 50;

        gbc.gridx = 0;
        gbc.gridy = 8;
        cid1 = new Label("*Your custom");
        add(cid1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        cid2 = new Label("own USER_ID **");
        add(cid2, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 9;
        uid = new Label("USER_ID");
        add(uid, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        ui = new TextField(20);
        add(ui, gbc);



        MyWindowAdapter m = new MyWindowAdapter(this);
        addWindowListener(m);
        setVisible(true);

        n.setEditable(false); ln.setEditable(false); ag.setEditable(false); mn.setEditable(false); fn.setEditable(false); em.setEditable(false); ui.setEditable(false);
    getDetailsFromDB(id);

    }

    public void getDetailsFromDB(String id) {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javapro?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                    "root","8688466782");

            Statement stmt = c.createStatement();
            String query = "select * from details where id='"+id+"'";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()) {
                n.setText(rs.getString(2));
                //n, ln, ag, mn, fn, em, ui;
                //    TextArea adr
                ln.setText(rs.getString(3));
                ag.setText(rs.getString(4));
                adr.setText(rs.getString(5));
                mn.setText(rs.getString(6));
                fn.setText(rs.getString(7));
                em.setText(rs.getString(8));
                ui.setText(rs.getString(1));
                adr.setEditable(false);
                String s = rs.getString("gender");
                if(s.equals("M")){
                    gn.select(0);
                }else if(s.equals("F")) {
                    gn.select(1);
                }else {
                    gn.select(2);
                }
                gn.setEnabled(false);
            }


        }catch (SQLException e) {
            n.setText("Unable to connect");
        }
    }

}

