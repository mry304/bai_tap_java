package org.example;

import javax.swing.*;
import java.awt.*;

public class test extends JFrame {

    private JTextField txtNum1;
    private JTextField txtNum2;
    private JLabel lblResult;

    public test() {
        setTitle("Sum Calculator");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        txtNum1 = new JTextField(15);
        txtNum2 = new JTextField(15);
        JButton btnSum = new JButton("Tính tổng");
        lblResult = new JLabel("Kết quả: ");

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Số thứ nhất:"));
        panel.add(txtNum1);

        panel.add(new JLabel("Số thứ hai:"));
        panel.add(txtNum2);

        panel.add(btnSum);
        panel.add(lblResult);

        add(panel);

        txtNum1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                    JOptionPane.showMessageDialog(
                            test.this,
                            "Chỉ được nhập số!",
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        txtNum2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                    JOptionPane.showMessageDialog(
                            test.this,
                            "Chỉ được nhập số!",
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        btnSum.addActionListener(e -> {
            if (txtNum1.getText().isEmpty() || txtNum2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Vui lòng nhập đầy đủ hai số!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            int num1 = Integer.parseInt(txtNum1.getText());
            int num2 = Integer.parseInt(txtNum2.getText());

            lblResult.setText("Kết quả: " + (num1 + num2));
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new test().setVisible(true);
        });
    }
}
