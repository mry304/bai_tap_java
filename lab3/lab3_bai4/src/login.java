import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame{
    private JPanel panel1;
    private JTextField tk_field;
    private JTextField mk_field;
    private JButton login_btn;
    private JLabel tb;
    private String tk = "admin";
    private String mk = "123";
    public login() {

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        tb.setVisible(false);
        login_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }
    void login(){
        String acc = tk_field.getText().trim();
        String pass = mk_field.getText().trim();

        if(acc.equals(tk) && pass.equals(mk)){
            tb.setText("Đăng nhập thành công");
            tb.setVisible(true);
        }
        else {
            tb.setText("Sai tài khoản or mk");
            tb.setVisible(true);
        }

    }
}
