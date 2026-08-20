

import model.Student;
import model.SubjectScore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AddStudentDialog extends JDialog {

    private JTextField txtStudentId;
    private JTextField txtFullName;

    private JTable tblScores;
    private DefaultTableModel tableModel;

    private JButton btnSave;
    private JButton btnCancel;

    private Student studentResult;

    public AddStudentDialog(
            JFrame parent,
            String title,
            int numberOfSubjects
    ) {
        super(parent, title, true);

        initComponents(numberOfSubjects);

        setSize(800, 500);
        setLocationRelativeTo(parent);
    }

    private void initComponents(int numberOfSubjects) {

        setLayout(new BorderLayout(10, 10));

        JPanel pnlInfo = new JPanel(new GridLayout(2, 2, 10, 10));
        pnlInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        pnlInfo.add(new JLabel("Mã sinh viên:"));

        txtStudentId = new JTextField();
        pnlInfo.add(txtStudentId);

        pnlInfo.add(new JLabel("Họ tên:"));

        txtFullName = new JTextField();
        pnlInfo.add(txtFullName);

        add(pnlInfo, BorderLayout.NORTH);

        String[] columns = {
                "Môn học",
                "Chuyên cần",
                "Giữa kỳ",
                "Cuối kỳ"
        };

        tableModel = new DefaultTableModel(columns, numberOfSubjects) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        tblScores = new JTable(tableModel);

        for (int i = 0; i < numberOfSubjects; i++) {
            tblScores.setValueAt("Môn " + (i + 1), i, 0);
        }

        JScrollPane scrollPane = new JScrollPane(tblScores);

        add(scrollPane, BorderLayout.CENTER);

        JPanel pnlButton = new JPanel();

        btnSave = new JButton("Lưu");

        btnCancel = new JButton("Hủy");

        pnlButton.add(btnSave);
        pnlButton.add(btnCancel);

        add(pnlButton, BorderLayout.SOUTH);

        btnSave.addActionListener(e -> saveStudent());

        btnCancel.addActionListener(e -> dispose());
    }

    private void saveStudent() {

        String studentId = txtStudentId.getText().trim();
        String fullName = txtFullName.getText().trim();

        if (studentId.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập mã sinh viên!",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );

            txtStudentId.requestFocus();
            return;
        }

        if (fullName.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập họ tên!",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );

            txtFullName.requestFocus();
            return;
        }

        Student student = new Student(
                studentId,
                fullName
        );

        for (int i = 0; i < tblScores.getRowCount(); i++) {

            Object subjectObj =
                    tblScores.getValueAt(i, 0);

            if (subjectObj == null ||
                    subjectObj.toString().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Dòng " + (i + 1)
                                + ": Vui lòng nhập tên môn học!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );

                tblScores.requestFocus();
                tblScores.changeSelection(i, 0, false, false);

                return;
            }

            String subjectName =
                    subjectObj.toString().trim();

            Object attendanceObj =
                    tblScores.getValueAt(i, 1);

            if (attendanceObj == null ||
                    attendanceObj.toString().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Dòng " + (i + 1)
                                + ": Vui lòng nhập điểm chuyên cần!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );

                tblScores.requestFocus();
                tblScores.changeSelection(i, 1, false, false);

                return;
            }

            Object midtermObj =
                    tblScores.getValueAt(i, 2);

            if (midtermObj == null ||
                    midtermObj.toString().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Dòng " + (i + 1)
                                + ": Vui lòng nhập điểm giữa kỳ!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );

                tblScores.requestFocus();
                tblScores.changeSelection(i, 2, false, false);

                return;
            }

            Object finalObj =
                    tblScores.getValueAt(i, 3);

            if (finalObj == null ||
                    finalObj.toString().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Dòng " + (i + 1)
                                + ": Vui lòng nhập điểm cuối kỳ!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );

                tblScores.requestFocus();
                tblScores.changeSelection(i, 3, false, false);

                return;
            }

            double attendance;
            double midterm;
            double finalExam;

            try {

                attendance = Double.parseDouble(
                        attendanceObj.toString().trim()
                );

                midterm = Double.parseDouble(
                        midtermObj.toString().trim()
                );

                finalExam = Double.parseDouble(
                        finalObj.toString().trim()
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Dòng " + (i + 1)
                                + ": Điểm phải là số!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (attendance < 0 || attendance > 10) {

                JOptionPane.showMessageDialog(
                        this,
                        "Dòng " + (i + 1)
                                + ": Điểm chuyên cần phải từ 0 đến 10!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );

                tblScores.requestFocus();
                tblScores.changeSelection(i, 1, false, false);

                return;
            }

            if (midterm < 0 || midterm > 10) {

                JOptionPane.showMessageDialog(
                        this,
                        "Dòng " + (i + 1)
                                + ": Điểm giữa kỳ phải từ 0 đến 10!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );

                tblScores.requestFocus();
                tblScores.changeSelection(i, 2, false, false);

                return;
            }

            if (finalExam < 0 || finalExam > 10) {

                JOptionPane.showMessageDialog(
                        this,
                        "Dòng " + (i + 1)
                                + ": Điểm cuối kỳ phải từ 0 đến 10!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );

                tblScores.requestFocus();
                tblScores.changeSelection(i, 3, false, false);

                return;
            }

            SubjectScore score =
                    new SubjectScore(
                            subjectName,
                            attendance,
                            midterm,
                            finalExam
                    );
            student.addScore(score);
        }

        studentResult = student;

        JOptionPane.showMessageDialog(
                this,
                "Lưu sinh viên thành công!",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE
        );

        dispose();
    }

    public Student getStudentResult() {
        return studentResult;
    }
}