package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MainMenu extends Values {
    private JButton Kitchen;
    private JPanel rootPanel;
    private JTextField totalPriceTextField;
    private JFormattedTextField priceTotal;
    private JButton submitButton;
    private JButton kitchenButton;
    private JButton barButton;
    private JButton confectionaryButton;
    public String file = "C:\\Users\\Ghost\\Desktop\\end\\EndTermJava\\src\\com\\company\\extra.txt";
    public MainMenu(){
        add(rootPanel);
        Insert();
        setTitle("My First GUI Form");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kitchenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Kitchen kitchen = new Kitchen();
                kitchen.setVisible(true);
            }
        });
        barButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
               Bar  bar = new Bar();
                bar.setVisible(true);
            }
        });
        confectionaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Confectionary conf = new Confectionary();
                conf.setVisible(true);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result=0;
                priceTotal.setValue(result);
                System.out.println(insertPilaf);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JOptionPane.showMessageDialog(rootPane,"Submitted successfully");
                Statement st;
                Connection connection = null;
                String host = "localhost";
                String port = "5432";
                String db_name = "JavaEndterm";
                String username = "postgres";
                String password = "0000";
                try {
                    Class.forName("org.postgresql.Driver");
                    // Establish the connection
                    //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0000");
                    connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name, username, password);

                    st = connection.createStatement();

                    ResultSet rs = st.executeQuery("Insert into requests(waiter_id,product_id,product_name,price,time,request_id) Values(10001,1001,'Pilaf',"+insertPilaf+",'00:10:00',1)");

                    st.close();
                    connection.close();
                }catch(Exception r) {
                    System.out.println(r);
                }
            }
        });
    }
    public void Insert(){
        try {
            File input = new File(file);
            Scanner myScanner = new Scanner(input);
            while (myScanner.hasNextLine()){
                result = myScanner.nextInt();
                priceTotal.setValue(result);
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
