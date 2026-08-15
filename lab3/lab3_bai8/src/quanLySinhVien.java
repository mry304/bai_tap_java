import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
public class quanLySinhVien extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JTextField id_field;
    private JTextField textField2;
    private JTextField textField3;
    private JButton add_btn;
    private JButton rp_btn;
    private JButton del_btn;
    private JButton re_btn;
    public ArrayList<student> students;
    DefaultTableModel model;
    public quanLySinhVien(){

        students = new ArrayList<>();
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        Random rand = new Random();
        for(int i = 0; i < 10; ++i){
            int id = i;
            String name = "binh" + i;
            double point = Math.round(rand.nextDouble() * 10.0 * 100.0) / 100.0;
            student student = new student(id, name, point);
            students.add(student);
        }
        hienThiDanhSachSinhVien();
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectRow = table1.getSelectedRow();
                if(selectRow != -1){
                    String id = model.getValueAt(selectRow, 0).toString();
                    String name = model.getValueAt(selectRow, 1).toString();
                    String point = model.getValueAt(selectRow, 2).toString();

                    id_field.setText(id);
                    textField2.setText(name);
                    textField3.setText(point);
                }
            }
        });
        rp_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repiar();
            }
        });
        del_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });
        add_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
    }

    private void hienThiDanhSachSinhVien(){
        String[] column = {"Mã Sinh viên", "Tên", "Điểm TB"};
        model = new DefaultTableModel(column, 0);

        for(student st : students){
            Object[] row = {st.getId(), st.getName(), st.getPoint()};
            model.addRow(row);
        }
        table1.setModel(model);
    }
    private void add(){
        String idText = id_field.getText().trim();
        String name = textField2.getText().trim();
        String pointText = textField3.getText().trim();
        if(idText.isEmpty() || name.isEmpty() || pointText.isEmpty()) JOptionPane.showMessageDialog(null, "Nhap du");

        try{
            int id = Integer.parseInt(idText);
            double point = Double.parseDouble(pointText);

            student student = new student(id, name, point);
            model.addRow(new Object[]{
                    student.getId(),
                    student.getName(),
                    student.getPoint()
            });
            id_field.setText("");
            textField2.setText("");
            textField3.setText("");
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Khong hop le");
        }

    }
    private void repiar(){
        int selectRow = table1.getSelectedRow();
        if(selectRow != -1){
            String newid = id_field.getText().trim();
            String newName = textField2.getText().trim();
            String newPoint = textField3.getText().trim();

            model.setValueAt(newid, selectRow, 0);
            model.setValueAt(newName, selectRow, 1);
            model.setValueAt(newPoint, selectRow, 2);
            JOptionPane.showMessageDialog(null, "complete");
        }
        else{
            JOptionPane.showMessageDialog(null, "CHọn 1 dòng");
        }



    }
    private void delete(){
        int selectRow = table1.getSelectedRow();

        if(selectRow != -1) {
            model.removeRow(selectRow);

        }
        else {
            JOptionPane.showMessageDialog(null, "chưa chọn dòng");
        }
    }
    private void reload(){

    }
}
