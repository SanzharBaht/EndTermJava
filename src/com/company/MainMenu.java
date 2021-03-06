package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JButton Kitchen;
    private JPanel rootPanel;
    private JButton kitchenButton;
    private JButton barButton;
    private JButton confectioneryButton;

    public MainMenu(){
        add(rootPanel);
        setTitle("My First GUI Form");
        setSize(400,500);
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
        confectioneryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Confectionary conf = new Confectionary();
                conf.setVisible(true);
            }
        });
    }


}