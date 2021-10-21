package com.example.soundoff.data.model;

public class Code {

    private Integer attendanceCode;
    private String classDate;
    private ClassObj classObj;

    public Code(Integer attendanceCode, String classDate, ClassObj classObj) {
        this.attendanceCode = attendanceCode;
        this.classDate = classDate;
        this.classObj = classObj;
    }

    public Integer getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(Integer attendanceCode) {
        this.attendanceCode = attendanceCode;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }

    public ClassObj getClassObj() {
        return classObj;
    }

    public void setClassObj(ClassObj classObj) {
        this.classObj = classObj;
    }

    public void generateHashCode(){
        //TODO: Generate hashcode based on class and classDate
    }
}
