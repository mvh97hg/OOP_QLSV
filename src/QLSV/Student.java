/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV;

/**
 *
 * @author HUNGMV
 */
public class Student {

    int id;
    String full_name, student_id, date_of_birth, gender, classroom;

    public Student() {

    }

    public Student(int id, String full_name, String student_id, String date_of_birth, String gender, String classroom) {
        this.id = id;
        this.full_name = full_name;
        this.student_id = student_id;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.classroom = classroom;
    }

    public Student(String full_name, String student_id, String date_of_birth, String gender, String classroom) {
        this.full_name = full_name;
        this.student_id = student_id;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

}
