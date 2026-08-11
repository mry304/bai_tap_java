package org.example;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Welcome extends JFrame {

    public Welcome() {
        setTitle("Welcome");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Welcome welcome = new Welcome();
            welcome.setVisible(true);

            JOptionPane.showMessageDialog(
                    welcome,
                    "Welcome to Java Swing",
                    "Welcome",
                    JOptionPane.INFORMATION_MESSAGE
            );

            System.exit(0);
        });
    }
}
