package com.example.soundoff.data.model;

public class ClassObj {
    private String className;
    private String sectionNumber;
    private Professor professor;

    public ClassObj(String className, String sectionNumber, Professor professor) {
        this.className = className;
        this.sectionNumber = sectionNumber;
        this.professor = professor;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}

