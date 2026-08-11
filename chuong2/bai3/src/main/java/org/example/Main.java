package org.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Main extends JFrame {

    public Main() {
        setTitle("Exit");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        setLayout(new BorderLayout());
        add(exitButton, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}