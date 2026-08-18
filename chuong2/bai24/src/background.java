import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class background extends JFrame{
    private JPanel panel1;
    private JCheckBox checkBox1;

    public background() {
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        panel1.setBackground(Color.red);
        checkBox1.addItemListener(e->{
            if(checkBox1.isSelected()) panel1.setBackground(Color.green);
            else panel1.setBackground(Color.red);
        });
    }
}
