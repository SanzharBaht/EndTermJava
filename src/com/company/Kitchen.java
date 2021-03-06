package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kitchen extends JFrame{
    private JButton mantiButton;
    private JButton borschtButton;
    private JPanel Kitchen;
    private JButton pilafButton;
    private JTable table1;
    private JButton lagmanButton;
    private JButton backButton;
    private JFormattedTextField formattedTextField1;
    private JTextField totalPrice;

    public JPanel getKitchen(){
        return Kitchen;
    }

    public Kitchen() {
        CreateTable();
        add(Kitchen);
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
        pilafButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

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
