package org.example;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DigitalClock extends JFrame {

    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        JLabel label = new JLabel(now.format(formatter), JLabel.CENTER);

        add(label, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new DigitalClock().setVisible(true);
    }
}