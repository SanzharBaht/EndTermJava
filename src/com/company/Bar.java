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

public class Bar extends Values{
    private JTable table1;
    private JButton backButton;
    private JPanel Bar;
    private JButton teaButton;
    private JButton lemonadeButton;
    private JButton beerButton;
    private JButton juiceButton;
    private JTextField totalPriceTextField;
    private JFormattedTextField priceTotal;
    private JButton clearAllButton;
    private JTable table2;
    public String file = "C:\\Users\\Ghost\\Desktop\\end\\EndTermJava\\src\\com\\company\\extra.txt";
    public JPanel getBar(){
        return Bar;
    }
    public Bar() {
        CreateTable();
        Insert();
        add(Bar);
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
        lemonadeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result+=1500;
                priceTotal.setValue(result);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        teaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result+=1250;
                priceTotal.setValue(result);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        juiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result+=800;
                priceTotal.setValue(result);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        beerButton.addActionListener(new ActionListener() {
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
        clearAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result=0;
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
                {"Lemonade",1500},
                {"Tea",1250},
                {"Juice",800},
                {"Beer",1200}
        };
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        //Object[] columns = {"Name","Price"};
        model.setDataVector(data,new String[] {"Name","Price","sad"});
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


