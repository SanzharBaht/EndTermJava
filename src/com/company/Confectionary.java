package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Confectionary extends JFrame {

    private JTable table1;
    private JButton backButton;
    private JPanel Confectionary;
    private JButton cakeButton;
    private JButton pieButton;
    private JButton candyButton;
    private JButton biscuitButton;
    private JButton totalPriceButton;
    private JButton button6;

    public JPanel getConfectionary(){
        return Confectionary;
    }
    public Confectionary() {
        CreateTable();
        add(Confectionary);
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

}