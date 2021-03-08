package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    priceTotal.write(fileWriter);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JOptionPane.showMessageDialog(rootPane,"Submitted successfully");
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
