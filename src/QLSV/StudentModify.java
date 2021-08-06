/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HUNGMV
 */
public class StudentModify {

    static final String URL = "jdbc:mysql://localhost:3306/student_management";
    static final String USER = "hungmv";
    static final String PASSWORD = "12345a@";

    public static List<Student> getStudentClass(String cls) {
        List<Student> datatList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            //query
            if (cls != null && cls.length() > 0) {

                String sql = "select * from student where classroom = '" + cls + "' ";
                PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet resultSet = stm.executeQuery();

                while (resultSet.next()) {
                    Student std = new Student(resultSet.getInt("id"),
                            resultSet.getString("full_name"),
                            resultSet.getString("student_id"),
                            resultSet.getString("date_of_birth"),
                            resultSet.getString("gender"),
                            resultSet.getString("classroom"));
                    datatList.add(std);
                }
                System.out.println(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally { //ngắt kết nối sql

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return datatList;
    }

    public static List<Student> getALL() {
        List<Student> datatList = new ArrayList<>();

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //query
            String sql = "select * from student";

            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                Student std = new Student(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("student_id"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("gender"),
                        resultSet.getString("classroom"));
                datatList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally { //ngắt kết nối sql

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return datatList;
    }

    public static void insert(Student std) {
        Connection conn = null;

        try {

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            //query
            String sql = "insert into student(full_name, student_id, date_of_birth,gender, classroom) values(?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, std.getFull_name());
            stm.setString(2, std.getStudent_id());
            stm.setString(3, std.getDate_of_birth());
            stm.setString(4, std.getGender());
            stm.setString(5, std.getClassroom());

            stm.execute();
            JOptionPane.showMessageDialog(null, "Thêm thành công.");
            System.out.println(stm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mã sinh viên ' " + std.student_id + " ' đã tồn tại.");
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void update(Student std) {
        Connection conn = null;

        try {

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            //query
            String sql = "UPDATE student SET full_name=?,date_of_birth=?,gender=?,classroom=? WHERE student_id =?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, std.full_name);
            stm.setString(2, std.date_of_birth);
            stm.setString(3, std.gender);
            stm.setString(4, std.classroom);
            stm.setString(5, std.student_id);
            stm.execute();
            System.out.println(stm);
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void delete(String student_id) {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            //lay tat ca danh sach sinh vien
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            //query
            String sql = "delete from student where student_id =?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, student_id);
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

}
