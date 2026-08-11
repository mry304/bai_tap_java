package org.example;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First Swing App");

        JLabel label = new JLabel("Hello world");

        frame.add(label);
        frame.setLocation(800,400);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}