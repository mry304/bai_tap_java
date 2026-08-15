import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator extends JFrame {
    private JPanel panel1;
    private JButton clear_btn;
    private JButton a0Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;  // Phím 7
    private JButton a8Button; // Giả định phím 8
    private JButton a9Button; // Giả định phím 9
    private JButton plus_btn;
    private JButton mul_btn;
    private JButton divide_btn;
    private JButton rs_btn;     // Phím = (Lấy kết quả)
    private JButton minus_btn;
    private JTextField rs_field;

    // Các biến lưu trữ trạng thái tính toán
    private double firstOperand = 0;
    private String operator = "";
    private boolean isStartNewNumber = true;

    public calculator() {
        // Cấu hình khung chứa chính (JFrame)
        setTitle("Máy tính bỏ túi");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        // Đặt thuộc tính không cho sửa trực tiếp ô kết quả bằng bàn phím
        rs_field.setEditable(false);
        rs_field.setHorizontalAlignment(JTextField.RIGHT);

        // --- 1. ĐĂNG KÝ SỰ KIỆN CHO CÁC NÚT SỐ ---
        ActionListener numberListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                String digit = btn.getText();

                if (isStartNewNumber) {
                    rs_field.setText(digit);
                    isStartNewNumber = false;
                } else {
                    rs_field.setText(rs_field.getText() + digit);
                }
            }
        };

        // Gán sự kiện cho các nút số
        a1Button.addActionListener(numberListener);
        a2Button.addActionListener(numberListener);
        a3Button.addActionListener(numberListener);
        a4Button.addActionListener(numberListener);
        a5Button.addActionListener(numberListener);
        a6Button.addActionListener(numberListener);
        a7Button.addActionListener(numberListener);
        a8Button.addActionListener(numberListener);
        a9Button.addActionListener(numberListener);

        // --- 2. ĐĂNG KÝ SỰ KIỆN CHO CÁC NÚT PHÉP TOÁN (+, -, *, /) ---
        ActionListener operatorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                try {
                    firstOperand = Double.parseDouble(rs_field.getText());
                    operator = btn.getText();
                    isStartNewNumber = true;
                } catch (NumberFormatException ex) {
                    rs_field.setText("Error");
                    isStartNewNumber = true;
                }
            }
        };

        plus_btn.addActionListener(operatorListener);
        minus_btn.addActionListener(operatorListener);
        mul_btn.addActionListener(operatorListener);
        divide_btn.addActionListener(operatorListener);

        // --- 3. ĐĂNG KÝ SỰ KIỆN CHO NÚT BẰNG (=) ---
        rs_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });
        clear_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rs_field.setText("");
                firstOperand = 0;
                operator = "";
                isStartNewNumber = true;
            }
        });
    }

    // Hàm tính toán kết quả
    private void calculateResult() {
        if (operator.isEmpty()) return;

        try {
            double secondOperand = Double.parseDouble(rs_field.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand == 0) {
                        rs_field.setText("Cannot divide by 0");
                        isStartNewNumber = true;
                        operator = "";
                        return;
                    }
                    result = firstOperand / secondOperand;
                    break;
            }

            // Định dạng hiển thị: bỏ phần thập phân nếu là số nguyên
            if (result == (long) result) {
                rs_field.setText(String.format("%d", (long) result));
            } else {
                rs_field.setText(String.valueOf(result));
            }

            operator = "";
            isStartNewNumber = true;
        } catch (NumberFormatException ex) {
            rs_field.setText("Error");
            isStartNewNumber = true;
        }
    }
}