package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Kitchen extends Values{
    private JButton mantiButton;
    private JButton borschtButton;
    private JPanel Kitchen;
    private JButton pilafButton;
    private JTable table1;
    private JButton lagmanButton;
    private JButton backButton;
    private JFormattedTextField priceTotal;
    private JTextField totalPrice;
    private JButton clearAllButton;

    public String file = "C:\\Users\\Ghost\\Desktop\\end\\EndTermJava\\src\\com\\company\\extra.txt";
    public String readfile = "C:\\Users\\Ghost\\Desktop\\end\\EndTermJava\\src\\com\\company\\read.txt";
    public JPanel getKitchen(){
        return Kitchen;
    }

    public Kitchen() {
        CreateTable();
        Insert();
        add(Kitchen);
        setTitle("Kitchen Menu");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
            }
        });

        pilafButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result+=700;
                priceTotal.setValue(result);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        mantiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result+=600;
                priceTotal.setValue(result);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            }
        });
        lagmanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result+=1000;
                priceTotal.setValue(result);
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        borschtButton.addActionListener(new ActionListener() {
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
    public void CreateTable(){
        Object[][] data = {
                {"Pilaf",700},
                {"Lagman",1000},
                {"Manti",600},
                {"Borscht",500}
        };
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        //Object[] columns = {"Name","Price"};
        model.setDataVector(data,new String[] {"Name","Price","sad"});
        table1.setTableHeader(null);
        table1.getTableHeader();
    }


}
