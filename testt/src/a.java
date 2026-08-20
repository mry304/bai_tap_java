import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
public class a extends JFrame{
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JPanel mainpanel;
    private JPanel twothpanel;
    private JButton loginButton;
    private JTextField textField1;
    private JTextField tk;
    private JTextField mk;
    private JButton signInButton;
    private JLabel l1;
    private JLabel l2;


    private Map<String, String> mp = new HashMap<>();
    public a() {
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        twothpanel.setVisible(false);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                twothpanel.setVisible(true);
                mainpanel.setVisible(false);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                twothpanel.setVisible(false);
                mainpanel.setVisible(true);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = tk.getText().trim();
                if(!mp.containsKey(user)) {
                    JOptionPane.showMessageDialog(mainpanel, "loi");
                    return;
                }
                String pass1 = mp.get(user);
                String pass = mk.getText().trim();
                if(pass1.equals(pass)){
                    JOptionPane.showMessageDialog(mainpanel, "complete");
                }
                else JOptionPane.showMessageDialog(mainpanel, "sai mk");
            }
        });
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = tk.getText().trim();
                String pass = mk.getText().trim();
                mp.put(user,pass);
                tk.setText("");
                mk.setText("");
                l1.setText(mp.get(user));
                l2.setText(pass);
                JOptionPane.showMessageDialog(mainpanel, "dk xong");

            }
        });

    }
}
