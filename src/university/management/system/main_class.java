package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        // new Information
        JMenu newInfo  = new JMenu("Thêm thông tin");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        JMenuItem faculty = new JMenuItem("Thêm thông tin giảng viên");
        faculty.setBackground(Color.WHITE);
        faculty.addActionListener(this);
        newInfo.add(faculty);

        JMenuItem studentInfo = new JMenuItem("Thêm thông tin sinh viên");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        // Details
        JMenu details  = new JMenu("Xem thông tin");
        details.setForeground(Color.BLACK);
        details.addActionListener(this);
        mb.add(details);

        JMenuItem facultyDetails = new JMenuItem("Xem thông tin giảng viên");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("Xem thông tin sinh viên");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        // Leave
        JMenu leave  = new JMenu("Xin nghỉ phép");
        leave.setForeground(Color.BLACK);
        leave.addActionListener(this);
        mb.add(leave);

        JMenuItem facultyLeave = new JMenuItem("NP Giảng viên");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("NP Sinh viên");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        // Leave Detail
        JMenu leaveDetail  = new JMenu("Danh sách nghỉ phép");
        leaveDetail.setForeground(Color.BLACK);
        leaveDetail.addActionListener(this);
        mb.add(leaveDetail);

        JMenuItem facultyLeaveDetail = new JMenuItem("Danh sách np giảng viên");
        facultyLeaveDetail.setBackground(Color.WHITE);
        facultyLeaveDetail.addActionListener(this);
        leaveDetail.add(facultyLeaveDetail);

        JMenuItem studentLeaveDetail = new JMenuItem("Danh sách np sinh viên");
        studentLeaveDetail.setBackground(Color.WHITE);
        studentLeaveDetail.addActionListener(this);
        leaveDetail.add(studentLeaveDetail);

        // Exams
        JMenu exam  = new JMenu("Bài kiểm tra");
        exam.setForeground(Color.BLACK);
        exam.addActionListener(this);
        mb.add(exam);

        JMenuItem examinationDetail = new JMenuItem("Kết quả bài thi");
        facultyLeaveDetail.setBackground(Color.WHITE);
        examinationDetail.addActionListener(this);
        exam.add(examinationDetail);

        JMenuItem enterMarks = new JMenuItem("Nhập điểm");
        studentLeaveDetail.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        // Update Info
        JMenu updateInfo  = new JMenu("Cập nhật chi tiết");
        updateInfo.setForeground(Color.BLACK);
        updateInfo.addActionListener(this);
        mb.add(updateInfo);

        JMenuItem updateFacultyInfo = new JMenuItem("TT Giảng viên");
        updateFacultyInfo.setBackground(Color.WHITE);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo = new JMenuItem("TT Sinh viên");
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        // Fee
        JMenu fee  = new JMenu("Thanh toán học phí");
        fee.setForeground(Color.BLACK);
        fee.addActionListener(this);
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem("Bảng học phí");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Thanh toán học phí");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        // Utility
        JMenu utility  = new JMenu("Tiện ích");
        utility.setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem ca = new JMenuItem("Máy tính");
        ca.setBackground(Color.WHITE);
        ca.addActionListener(this);
        utility.add(ca);

        JMenuItem Notepad = new JMenuItem("Note");
        Notepad.setBackground(Color.WHITE);
        Notepad.addActionListener(this);
        utility.add(Notepad);

        // About
        JMenu about  = new JMenu("About");
        about.setForeground(Color.BLACK);
        mb.add(about);

        JMenuItem About = new JMenuItem("Thông tin");
        About.setBackground(Color.WHITE);
        about.add(About);

        // Exit
        JMenu exit  = new JMenu("Thoát");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Thoát ứng dụng");
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        exit.add(Exit);

        setJMenuBar(mb);

        setSize(1540, 850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if(sm.equals("Thoát ứng dụng")) {
            System.exit(15);
        }else if(sm.equals("Máy tính")){
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else if(sm.equals("Note")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (sm.equals("Thêm thông tin giảng viên")) {
            new AddFaculty();
        } else if (sm.equals("Thêm thông tin sinh viên")) {
            new AddStudent();
        } else if (sm.equals("Xem thông tin giảng viên")) {
            new TeacherDetails();
        } else if (sm.equals("Xem thông tin sinh viên")) {
            new StudentDetails();
        } else if (sm.equals("NP Giảng viên")) {
            new TeacherLeave();
        } else if (sm.equals("NP Sinh viên")) {
            new StudentLeave();
        }else if (sm.equals("Danh sách np giảng viên")) { 
            new TeacherLeaveDetails();
        } else if (sm.equals("Danh sách np sinh viên")) {  
            new StudentLeaveDetails();
        } else if (sm.equals("Nhập điểm")) {
            new EnterMarks();
        } else if (sm.equals("Kết quả bài thi")) {
            new ExaminationDetails();
        } else if (sm.equals("TT Giảng viên")) {
        	new UpdateTeacher();
        } else if (sm.equals("TT Sinh viên")) {
        	new UpdateTeacher();
        }else if (sm.equals("Bảng học phí")) {
            new FreeStructure();
        }else if (sm.equals("Thanh toán học phí")){
            new StudenFeeForm(); 
        } else if (sm.equals("Thông tin")) {
            new About();
        }   
    }

    public static void main(String[] args) {
        new main_class();
    }
}
