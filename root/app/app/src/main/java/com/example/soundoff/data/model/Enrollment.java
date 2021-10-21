package com.example.soundoff.data.model;

public class Enrollment {

    private ClassObj classObj;
    private Student studentObj;

    public Enrollment(ClassObj classObj, Student studentObj) {
        this.classObj = classObj;
        this.studentObj = studentObj;
    }

    public ClassObj getClassObj() {
        return classObj;
    }

    public void setClassObj(ClassObj classObj) {
        this.classObj = classObj;
    }

    public Student getStudentObj() {
        return studentObj;
    }

    public void setStudentObj(Student studentObj) {
        this.studentObj = studentObj;
    }
}
