package com.example.soundoff.data.model;

public class Attendance {

    private String attendanceTimestamp;
    private String location;
    private ClassObj classObj;
    private Student student;

    public Attendance(String attendanceTimestamp, String location, ClassObj classObj, Student student) {
        this.attendanceTimestamp = attendanceTimestamp;
        this.location = location;
        this.classObj = classObj;
        this.student = student;
    }

    public String getAttendanceTimestamp() {
        return attendanceTimestamp;
    }

    public void setAttendanceTimestamp(String attendanceTimestamp) {
        this.attendanceTimestamp = attendanceTimestamp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ClassObj getClassObj() {
        return classObj;
    }

    public void setClassObj(ClassObj classObj) {
        this.classObj = classObj;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
