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
    private JButton button2;
    private JButton juiceButton;
    private JButton totalPriceButton;
    private JButton button6;

    public JPanel getBar(){
        return Bar;
    }
    public Bar() {
        CreateTable();
        add(Bar);
        setTitle("Kitchen Menu");
        setSize(400, 500);

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
        table1.setTableHeader(null);
        table1.getTableHeader();
    }

}
