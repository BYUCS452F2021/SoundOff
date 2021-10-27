package com.example.soundoff.presenter;


import com.example.soundoff.service.StudentAttendanceService;
import com.example.soundoff.service.request.StudentAttendanceRequest;
import com.example.soundoff.service.response.StudentAttendanceResponse;

import java.io.IOException;

public class StudentAttendancePresenter {
    private final StudentAttendancePresenter.View view;

    public interface View {

    }

    public StudentAttendancePresenter(StudentAttendancePresenter.View view) {
        this.view = view;
    }

    public StudentAttendanceResponse recordAttendance(StudentAttendanceRequest request) throws IOException {
        StudentAttendanceService service = new StudentAttendanceService();
        return service.recordAttendance(request);
    }
}
