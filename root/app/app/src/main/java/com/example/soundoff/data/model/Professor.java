package com.example.soundoff.data.model;

public class Professor {

    private String name;
    private String professorDegree;
    private String professorDepartment;
    private String professorEmail;
    private String password;

    public Professor(String name, String professorDegree, String professorDepartment, String professorEmail, String password) {
        this.name = name;
        this.professorDegree = professorDegree;
        this.professorDepartment = professorDepartment;
        this.professorEmail = professorEmail;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessorDegree() {
        return professorDegree;
    }

    public void setProfessorDegree(String professorDegree) {
        this.professorDegree = professorDegree;
    }

    public String getProfessorDepartment() {
        return professorDepartment;
    }

    public void setProfessorDepartment(String professorDepartment) {
        this.professorDepartment = professorDepartment;
    }

    public String getProfessorEmail() {
        return professorEmail;
    }

    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
