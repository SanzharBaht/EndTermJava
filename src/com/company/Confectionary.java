package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Confectionary extends Values {

    private JTable table1;
    private JButton backButton;
    private JPanel Confectionary;
    private JButton cakeButton;
    private JButton pieButton;
    private JButton candyButton;
    private JButton biscuitButton;
    private JTextField totalPriceTextField;
    private JFormattedTextField priceTotal;
    private JButton clearAllButton;
    public String file = "C:\\Users\\Ghost\\Desktop\\end\\EndTermJava\\src\\com\\company\\extra.txt";
    public JPanel getConfectionary(){
        return Confectionary;
    }
    public Confectionary() {
        CreateTable();
        Insert();
        add(Confectionary);
        setTitle("Kitchen Menu");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainMenu mainMenu = new MainMenu();
                mainMenu .setVisible(true);
            }
        });
        cakeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result+=1800;
                priceTotal.setValue(result);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        pieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result+=1200;
                priceTotal.setValue(result);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        candyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result+=500;
                priceTotal.setValue(result);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        biscuitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result+=900;
                priceTotal.setValue(result);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
    }
    public void CreateTable(){
        Object[][] data = {
                {"Cake",1800},
                {"Candy",500},
                {"Pie",1200},
                {"Biscuit",900}
        };
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        //Object[] columns = {"Name","Price"};
        model.setDataVector(data,new String[] {"Name","Price","sad"});
        table1.setTableHeader(null);
        table1.getTableHeader();
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