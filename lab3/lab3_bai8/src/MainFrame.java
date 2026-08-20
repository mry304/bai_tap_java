
import manager.StudentManager;
import model.Student;
import model.SubjectScore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {

    private JTextField txtNumberOfSubjects;

    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnRefresh;

    private JTable tblStudents;
    private DefaultTableModel tableModel;

    private final StudentManager studentManager;

    public MainFrame() {

        studentManager = new StudentManager();

        initComponents();

        setTitle("Quản lý điểm sinh viên");

        setSize(1000, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {

        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new FlowLayout());

        topPanel.add(
                new JLabel("Số môn học:")
        );

        txtNumberOfSubjects =
                new JTextField(5);

        topPanel.add(txtNumberOfSubjects);

        btnAdd =
                new JButton("Thêm sinh viên");

        topPanel.add(btnAdd);

        btnEdit =
                new JButton("Sửa");

        topPanel.add(btnEdit);

        btnDelete =
                new JButton("Xóa");

        topPanel.add(btnDelete);

        btnRefresh =
                new JButton("Làm mới");

        topPanel.add(btnRefresh);

        add(topPanel, BorderLayout.NORTH);

        String[] columns = {
                "Mã SV",
                "Họ tên",
                "Môn học",
                "Chuyên cần",
                "Giữa kỳ",
                "Cuối kỳ",
                "Tổng"
        };

        tableModel =
                new DefaultTableModel(columns, 0) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {

                        return false;
                    }
                };

        tblStudents =
                new JTable(tableModel);

        tblStudents.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        add(
                new JScrollPane(tblStudents),
                BorderLayout.CENTER
        );

        btnAdd.addActionListener(
                e -> addStudent()
        );

        btnDelete.addActionListener(
                e -> deleteStudent()
        );

        btnEdit.addActionListener(
                e -> editStudent()
        );

        btnRefresh.addActionListener(
                e -> refreshTable()
        );
    }

    private void addStudent() {

        String text =
                txtNumberOfSubjects.getText().trim();

        if (text.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập số môn!"
            );

            return;
        }

        int numberOfSubjects;

        try {

            numberOfSubjects =
                    Integer.parseInt(text);

            if (numberOfSubjects <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Số môn phải > 0!"
                );

                return;
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Số môn phải là số nguyên!"
            );

            return;
        }

        // mở dialog
        AddStudentDialog dialog =
                new AddStudentDialog(
                        this,
                        "Thêm sinh viên",
                        numberOfSubjects
                );

        dialog.setVisible(true);

        Student student =
                dialog.getStudentResult();

        if (student == null) {
            return;
        }

        // kiểm tra trùng mã sinh viên

        if (studentManager.existsStudentId(
                student.getStudentId())) {

            JOptionPane.showMessageDialog(
                    this,
                    "Mã sinh viên đã tồn tại!"
            );

            return;
        }

        studentManager.addStudent(student);

        refreshTable();
    }

    private void refreshTable() {

        tableModel.setRowCount(0);

        List<Student> students =
                studentManager.getStudents();

        for (Student student : students) {

            for (SubjectScore score :
                    student.getScores()) {

                Object[] row = {

                        student.getStudentId(),

                        student.getFullName(),

                        score.getSubjectName(),

                        score.getAttendance(),

                        score.getMidterm(),

                        score.getFinalExam(),

                        String.format(
                                "%.2f",
                                score.getTotal()
                        )
                };

                tableModel.addRow(row);
            }
        }
    }

    private void deleteStudent() {

        int selectedRow =
                tblStudents.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng chọn sinh viên cần xóa!"
            );

            return;
        }

        String studentId =
                tableModel
                        .getValueAt(selectedRow, 0)
                        .toString();

        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Bạn có chắc muốn xóa sinh viên "
                                + studentId + "?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION
                );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        Student studentToDelete = null;

        for (Student student :
                studentManager.getStudents()) {

            if (student.getStudentId()
                    .equals(studentId)) {

                studentToDelete = student;

                break;
            }
        }

        if (studentToDelete != null) {

            studentManager.removeStudent(
                    studentToDelete
            );

            refreshTable();
        }
    }

    private void editStudent() {

        int selectedRow =
                tblStudents.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng chọn sinh viên cần sửa!"
            );

            return;
        }

        String studentId =
                tableModel
                        .getValueAt(selectedRow, 0)
                        .toString();

        Student student = null;

        for (Student s :
                studentManager.getStudents()) {

            if (s.getStudentId()
                    .equals(studentId)) {

                student = s;

                break;
            }
        }

        if (student == null) {
            return;
        }

        // Số môn hiện tại
        int numberOfSubjects =
                student.getScores().size();

        AddStudentDialog dialog =
                new AddStudentDialog(
                        this,
                        "Sửa sinh viên",
                        numberOfSubjects
                );

        dialog.setVisible(true);

        Student updatedStudent =
                dialog.getStudentResult();

        if (updatedStudent == null) {
            return;
        }

        // cập nhật
        student.setStudentId(
                updatedStudent.getStudentId()
        );

        student.setFullName(
                updatedStudent.getFullName()
        );

        student.setScores(
                updatedStudent.getScores()
        );

        refreshTable();
    }
}