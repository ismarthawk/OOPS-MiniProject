package OOP;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class Register extends Frame implements ActionListener {
    String msg="";
    Label name,lname,age,address,mname,fname,email,gender,uid ,cid1,cid2,nill,nill2,pass,pass2;
    TextField n,ln,ag,mn,fn,em,ui,ps,ps2;
    TextArea adr;
    Button check,create;
    Choice gn;
    boolean is = false;
    GridBagConstraints gbc = new GridBagConstraints();


    public Register() {
        setTitle("Register Here");
        setSize(600,700);

        setFont(new Font("Dialog",Font.BOLD,16));

        setLayout(new GridBagLayout());
        // GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill=  GridBagConstraints.HORIZONTAL;
        gbc.ipadx=30;
        gbc.ipady=10;

        gbc.gridx=0;
        gbc.gridy=0;
        name = new Label("Name");
        add(name,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        n = new TextField(20);
        add(n,gbc);


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
        adr = new TextArea(5,20);
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
        mn = new TextField( 20);
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
        add(em , gbc);

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
        //gn.addItem("Select Gender");
        gn.addItem("Male");
        gn.addItem("Female");
        gn.addItem("Other");
        add(gn, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 0;
        gbc.ipady = 50;

        gbc.gridx = 0;
        gbc.gridy = 8;
        cid1 = new Label("**Enter a custom");
        add(cid1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        cid2= new Label("own USER_ID **");
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

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        gbc.ipady = 10;

        gbc.gridx = 0;
        gbc.gridy = 11;
        pass= new Label("Set Password");
        add(pass, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        ps = new TextField(20);
        add(ps,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx=30;
        gbc.ipady=10;

        gbc.gridx = 0;
        gbc.gridy = 12;
        pass2= new Label("Confirm Password");
        add(pass2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 12;
        ps2 = new TextField(20);
        ps2.setEchoChar('*');
        add(ps2,gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx=30;
        gbc.ipady=10;

        gbc.gridx = 0;
        gbc.gridy = 13;
        nill= new Label("");
        add(nill, gbc);

        gbc.gridx = 1;
        gbc.gridy = 13;
        check = new Button("Check and Continue");
        add(check,gbc);










        MyWindowAdapter m = new MyWindowAdapter(this);
        addWindowListener(m);

        check.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //TextField n,ln,ag,mn,fn,em,ui,ps,ps2;
        //    TextArea adr;
        String s [] = new String[11];
        s[0]=n.getText();
        s[1]=ln.getText();
        s[2] = ag.getText();
        s[3]=adr.getText();
        s[4] = mn.getText();
        s[5] = fn.getText();
        s[6] = em.getText();
        s[7]=ui.getText();
        s[8]=ps.getText();
        s[9]=ps2.getText();
        s[10]=gn.getSelectedItem();
        if(s[10].equals("Male")){
            s[10]="M";
        }else if(s[10].equals("Female")) {
            s[10]="F";
        }else {
            s[10]="O";
        }

        for(String a : s) {
            if(a.equals("")) {
                FillAll fillAll = new FillAll(this,"Please Fill all the fields");
                fillAll.setVisible(true);
                return;
            }
        }

        if(!ps.getText().equals(ps2.getText())) {
            FillAll fillAll = new FillAll(this,"Please confirm the password again");
            fillAll.setVisible(true);
            return;
        }

        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapro?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","8688466782");
            Statement stmt = c.createStatement();

            String query = "select * from login where id='"+ui.getText()+"'";
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()) {
                FillAll fillAll = new FillAll(this,"This user id already taken,try another one");
                fillAll.setVisible(true);
                ui.setText("");
                return;
            }

            query = " insert into details (id,name ,lname, age, address,mname,fname,email,gender)"
                    + " values (?, ?, ?, ?, ?,?,?,?,?)";
            PreparedStatement pr = c.prepareStatement(query);
            pr.setString(1,ui.getText());
            pr.setString(2,n.getText());
            pr.setString(3,ln.getText());
            pr.setString(4,ag.getText());
            pr.setString(5,adr.getText());
            pr.setString(6,mn.getText());
            pr.setString(7,fn.getText());
            pr.setString(8,em.getText());
            pr.setString(9,s[10]);

            pr.execute();

            query ="insert into login values(?,?)";
            PreparedStatement p = c.prepareStatement(query);
            p.setString(1,ui.getText());
            p.setString(2,ps.getText());
            p.execute();
            new SuccessDialog(this,"Success").setVisible(true);


        } catch (SQLException m) {
            new FillAll(this,"Error"+m.getMessage()).setVisible(true);
        }




    }


}

