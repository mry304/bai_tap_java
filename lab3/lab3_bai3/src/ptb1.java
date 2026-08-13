
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ptb1 extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JLabel label_rs;

    public ptb1(){
        setTitle("ptb1");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giai_phuong_trinh_bac_nhat();
            }
        });
    }

    private void giai_phuong_trinh_bac_nhat(){
        try{
            double a = Double.parseDouble(textField1.getText().trim());
            double b = Double.parseDouble((textField2.getText().trim()));

            if(a == 0){
                if(b == 0){
                    label_rs.setText("Vô số nghiệm");
                }
                else{
                    label_rs.setText("vô nghiệm");
                }
            }
            else{
                double x = -b / a;
                label_rs.setText(String.format("%.2f",x));
            }
        }catch (NumberFormatException ex){
            label_rs.setText("vui lòng nhập lại");
        }
    }
}
