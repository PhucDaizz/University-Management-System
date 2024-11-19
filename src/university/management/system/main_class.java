package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class main_class extends JFrame implements ActionListener {
    main_class() {
    	getContentPane().setForeground(Color.YELLOW);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        getContentPane().setLayout(null);
        
        JPanel header_panel = new JPanel();
        header_panel.setBounds(0, 0, 1496, 78);
        header_panel.setBackground(Color.CYAN);
        getContentPane().add(header_panel);
        header_panel.setLayout(null);
        
        JLabel Hello = new JLabel("Xin chào!");
        Hello.setForeground(Color.WHITE);
        Hello.setFont(new Font("Tahoma", Font.BOLD, 22));
        Hello.setBounds(1304, 29, 108, 24);
        header_panel.add(Hello);
        JLabel img = new JLabel(i3);
        img.setBounds(10, 98, 1496, 695);
        header_panel.add(img);
        img.setForeground(new Color(255, 0, 0));
        
        JLabel menu = new JLabel("");
        menu.setForeground(Color.BLACK);
        menu.setIcon(new ImageIcon(main_class.class.getResource("/icon/icons/icons8_menu_48px_1.png")));
        menu.setBounds(87, 11, 58, 57);
        header_panel.add(menu);
        
        JLabel I = new JLabel("l");
        I.setForeground(Color.LIGHT_GRAY);
        I.setFont(new Font("Tahoma", Font.PLAIN, 56));
        I.setBounds(139, 11, 21, 57);
        header_panel.add(I);
        
        JLabel nameProduct = new JLabel("Phần mềm quản lý đại học");
        nameProduct.setForeground(Color.WHITE);
        nameProduct.setFont(new Font("Tahoma", Font.BOLD, 25));
        nameProduct.setBounds(170, 21, 360, 38);
        header_panel.add(nameProduct);
        
        JPanel menu_panel = new JPanel();
        menu_panel.setBounds(0, 77, 278, 714);
        menu_panel.setBackground(new Color(253, 245, 230));
        getContentPane().add(menu_panel);
        menu_panel.setLayout(null);
        
        JButton btnTTT = new JButton("Thêm thông tin");
        btnTTT.setBackground(Color.WHITE);
        btnTTT.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnTTT.setBounds(0, 24, 278, 39);
        menu_panel.add(btnTTT);
        
        JButton btn_XTT = new JButton("Xem thông tin");
        btn_XTT.setBackground(Color.WHITE);
        btn_XTT.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_XTT.setBounds(0, 93, 278, 38);
        menu_panel.add(btn_XTT);
        
        JButton btn_NP = new JButton("Xin nghỉ phép");
        btn_NP.setBackground(Color.WHITE);
        btn_NP.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_NP.setBounds(0, 164, 278, 38);
        menu_panel.add(btn_NP);
        
        JButton btn_DSNP = new JButton("Danh sách nghỉ phép");
        btn_DSNP.setBackground(Color.WHITE);
        btn_DSNP.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_DSNP.setBounds(0, 231, 278, 38);
        menu_panel.add(btn_DSNP);
        
        JButton btn_BKT = new JButton("Bài kiểm tra");
        btn_BKT.setBackground(Color.WHITE);
        btn_BKT.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_BKT.setBounds(0, 307, 278, 38);
        menu_panel.add(btn_BKT);
        
        JButton btn_CNTT = new JButton("Cập nhật thông tin");
        btn_CNTT.setBackground(Color.WHITE);
        btn_CNTT.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_CNTT.setBounds(0, 384, 278, 38);
        menu_panel.add(btn_CNTT);
        
        JButton btn_TTHP = new JButton("Thanh toán học phí");
        btn_TTHP.setBackground(Color.WHITE);
        btn_TTHP.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_TTHP.setBounds(0, 459, 278, 38);
        menu_panel.add(btn_TTHP);
        
        JPanel panel_TTT = new JPanel();
        panel_TTT.setBounds(274, 89, 235, 62);
        panel_TTT.setBackground(new Color(255, 255, 240));
        getContentPane().add(panel_TTT);
        panel_TTT.setVisible(false);
        panel_TTT.setLayout(null);
        
        JButton btn_TGV = new JButton("Giảng viên");
        btn_TGV.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new AddFaculty();
        	}
        });
        btn_TGV.setBounds(16, 5, 211, 25);
        panel_TTT.add(btn_TGV);
        btn_TGV.setForeground(new Color(0, 0, 0));
        btn_TGV.setBackground(new Color(255, 255, 240));
        btn_TGV.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_TGV.setVisible(false);
        
        JButton btn_TSV = new JButton("Sinh viên");
        btn_TSV.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 new AddStudent();
        	}
        });
        btn_TSV.setBounds(16, 29, 211, 25);
        panel_TTT.add(btn_TSV);
        btn_TSV.setBackground(new Color(255, 255, 240));
        btn_TSV.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JPanel panel_XTT = new JPanel();
        panel_XTT.setBounds(274, 156, 235, 62);
        panel_XTT.setBackground(new Color(255, 255, 240));
        getContentPane().add(panel_XTT);
        panel_XTT.setLayout(null);
        panel_XTT.setVisible(false);
        
        JButton btn_XGV = new JButton("Giảng viên");
        btn_XGV.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new TeacherDetails();
        	}
        });
        btn_XGV.setBounds(10, 0, 215, 25);
        panel_XTT.add(btn_XGV);
        btn_XGV.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_XGV.setVisible(false);
        
        JButton btn_XSV = new JButton("Sinh viên");
        btn_XSV.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new StudentDetails();
        	}
        });
        btn_XSV.setBounds(10, 29, 215, 25);
        panel_XTT.add(btn_XSV);
        btn_XSV.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_XSV.setVisible(false);
        
        JPanel panel_XNP = new JPanel();
        panel_XNP.setBounds(274, 229, 235, 62);
        panel_XNP.setBackground(new Color(255, 255, 240));
        getContentPane().add(panel_XNP);
        panel_XNP.setLayout(null);
        panel_XNP.setVisible(false);
        
        JButton btn_XNPGV = new JButton("Giảng viên");
        btn_XNPGV.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 new TeacherLeave();
        	}
        });
        btn_XNPGV.setBounds(10, 5, 215, 25);
        btn_XNPGV.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel_XNP.add(btn_XNPGV);
        btn_XNPGV.setVisible(false);
        
        JButton btn_XNPSV = new JButton("Sinh viên");
        btn_XNPSV.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new StudentLeave();
        	}
        });
        btn_XNPSV.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_XNPSV.setBounds(10, 29, 215, 25);
        panel_XNP.add(btn_XNPSV);
        btn_XNPSV.setVisible(false);
        
        JPanel panel_DSNP = new JPanel();
        panel_DSNP.setBounds(274, 302, 235, 62);
        panel_DSNP.setBackground(new Color(255, 255, 240));
        getContentPane().add(panel_DSNP);
        panel_DSNP.setLayout(null);
        panel_DSNP.setVisible(false);
        
        JButton btn_DSNPSV = new JButton("Sinh viên");
        btn_DSNPSV.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new StudentLeaveDetails();
        	}
        });
        btn_DSNPSV.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_DSNPSV.setBounds(10, 34, 215, 25);
        panel_DSNP.add(btn_DSNPSV);
        btn_DSNPSV.setVisible(false);
        
        JButton btn_DSNPGV = new JButton("Giảng viên");
        btn_DSNPGV.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new TeacherLeaveDetails();
        	}
        });
        btn_DSNPGV.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_DSNPGV.setBounds(10, 8, 215, 25);
        panel_DSNP.add(btn_DSNPGV);
        btn_DSNPGV.setVisible(false);
        
        JPanel panel_BKT = new JPanel();
        panel_BKT.setBounds(279, 375, 230, 62);
        panel_BKT.setBackground(new Color(255, 255, 240));
        getContentPane().add(panel_BKT);
        panel_BKT.setVisible(false);
        panel_BKT.setLayout(null);
        
        JButton btn_KQBT = new JButton("Kết quả bài thi");
        btn_KQBT.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new ExaminationDetails();
        	}
        });
        btn_KQBT.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_KQBT.setBounds(10, 8, 215, 25);
        panel_BKT.add(btn_KQBT);
        btn_KQBT.setVisible(false);
        
        JButton btn_NhapDiem = new JButton("Nhập điểm");
        btn_NhapDiem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new EnterMarks();
        	}
        });
        btn_NhapDiem.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_NhapDiem.setBounds(10, 34, 215, 25);
        panel_BKT.add(btn_NhapDiem);
        btn_NhapDiem.setVisible(false);
        
        JPanel panel_CNTT = new JPanel();
        panel_CNTT.setBackground(new Color(255, 255, 240));
        panel_CNTT.setBounds(274, 450, 235, 62);
        getContentPane().add(panel_CNTT);
        panel_CNTT.setLayout(null);
        panel_CNTT.setVisible(false);
        
        JButton btn_CNTTGV = new JButton("Giảng viên");
        btn_CNTTGV.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new UpdateTeacher();
        	}
        });
        btn_CNTTGV.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_CNTTGV.setBounds(10, 8, 215, 25);
        panel_CNTT.add(btn_CNTTGV);
        btn_CNTTGV.setVisible(false);
        
        JButton btn_CNTTSV = new JButton("Sinh viên");
        btn_CNTTSV.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new updateStudent();
        	}
        });
        btn_CNTTSV.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_CNTTSV.setBounds(10, 34, 215, 25);
        panel_CNTT.add(btn_CNTTSV);
        btn_CNTTSV.setVisible(false);
        
        JPanel panel_TTHP = new JPanel();
        panel_TTHP.setBackground(new Color(255, 255, 240));
        panel_TTHP.setBounds(274, 523, 235, 62);
        getContentPane().add(panel_TTHP);
        panel_TTHP.setLayout(null);
        panel_TTHP.setVisible(false);
        
        JButton btn_BHP = new JButton("Bảng học phí");
        btn_BHP.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new FreeStructure();
        	}
        });
        btn_BHP.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_BHP.setBounds(10, 8, 215, 25);
        panel_TTHP.add(btn_BHP);
        btn_BHP.setVisible(false);
        
        JButton btn_ThanhToan = new JButton("Thanh toán");
        btn_ThanhToan.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new StudenFeeForm(); 
        	}
        });
        btn_ThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn_ThanhToan.setBounds(10, 34, 215, 25);
        panel_TTHP.add(btn_ThanhToan);
        btn_TSV.setVisible(false);
        btn_ThanhToan.setVisible(false);
        
        btnTTT.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// Thay đổi trạng thái hiển thị của các nút tùy chọn
        		panel_TTT.setVisible(!panel_TTT.isVisible());
        		btn_TGV.setVisible(!btn_TGV.isVisible());
        		btn_TSV.setVisible(!btn_TSV.isVisible());
        	}
        });
        
        btn_XTT.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_XTT.setVisible(!panel_XTT.isVisible());
        		btn_XGV.setVisible(!btn_XGV.isVisible());
        		btn_XSV.setVisible(!btn_XSV.isVisible());
        	}
        });
        
        btn_NP.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_XNP.setVisible(!panel_XNP.isVisible());
        		btn_XNPGV.setVisible(!btn_XNPGV.isVisible());
        		btn_XNPSV.setVisible(!btn_XNPSV.isVisible());
        	}
        });
        
        btn_DSNP.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_DSNP.setVisible(!panel_DSNP.isVisible());
        		btn_DSNPSV.setVisible(!btn_DSNPSV.isVisible());
        		btn_DSNPGV.setVisible(!btn_DSNPGV.isVisible());
        	}
        });
        
        btn_BKT.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_BKT.setVisible(!panel_BKT.isVisible());
        		btn_NhapDiem.setVisible(!btn_NhapDiem.isVisible());
        		btn_KQBT.setVisible(!btn_KQBT.isVisible());
        	}
        });
        
        btn_CNTT.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_CNTT.setVisible(!panel_CNTT.isVisible());
        		btn_CNTTGV.setVisible(!btn_CNTTGV.isVisible());
        		btn_CNTTSV.setVisible(!btn_CNTTSV.isVisible());
        	}
        });
        
        btn_TTHP.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_TTHP.setVisible(!panel_TTHP.isVisible());
        		btn_BHP.setVisible(!btn_BHP.isVisible());
        		btn_ThanhToan.setVisible(!btn_ThanhToan.isVisible());
        	}
        });

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

        setSize(1510, 850);
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
        	new updateStudent();
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
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
