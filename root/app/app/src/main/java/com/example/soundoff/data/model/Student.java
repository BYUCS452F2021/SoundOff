package com.example.soundoff.data.model;

public class Student {
    private String studentName;
    private String studentMajor;
    private String studentPhone;
    private String studentEmail;
    private String password;

    public Student(String studentName, String studentMajor, String studentPhone, String studentEmail, String password) {
        this.studentName = studentName;
        this.studentMajor = studentMajor;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
        this.password = password;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
