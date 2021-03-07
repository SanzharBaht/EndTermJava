package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bar extends JFrame{
    private JTable table1;
    private JButton backButton;
    private JPanel Bar;
    private JButton teaButton;
    private JButton lemonadeButton;
    private JButton beerButton;
    private JButton juiceButton;
    private JTextField totalPriceTextField;
    private JFormattedTextField formattedTextField1;
    private JButton clearAllButton;
    private JTable table2;

    public JPanel getBar(){
        return Bar;
    }
    public Bar() {
        CreateTable();
        add(Bar);
        setTitle("Kitchen Menu");
        setSize(700, 500);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                MainMenu mainMenu = new MainMenu();
                mainMenu .setVisible(true);
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

    }


