package com.example.soundoff.presenter;


import com.example.soundoff.service.StudentAttendanceService;
import com.example.soundoff.service.StudentRegisterService;
import com.example.soundoff.service.request.StudentAttendanceRequest;
import com.example.soundoff.service.request.StudentRegisterRequest;
import com.example.soundoff.service.response.StudentAttendanceResponse;
import com.example.soundoff.service.response.StudentRegisterResponse;

import java.io.IOException;

public class StudentRegisterPresenter {
    private final StudentRegisterPresenter.View view;

    public interface View {

    }

    public StudentRegisterPresenter(StudentRegisterPresenter.View view) {
        this.view = view;
    }

    public StudentRegisterResponse registerStudent(StudentRegisterRequest request) throws IOException {
        StudentRegisterService service = new StudentRegisterService();
        return service.registerStudent(request);
    }
}
