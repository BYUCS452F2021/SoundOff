package com.example.soundoff.presenter;

import com.example.soundoff.service.StudentLoginService;
import com.example.soundoff.service.request.StudentLoginRequest;
import com.example.soundoff.service.response.StudentLoginResponse;

import java.io.IOException;

public class StudentLoginPresenter {
    //private final StudentLoginPresenter.View view;
    private final View view;

    public interface View {

    }

    public StudentLoginPresenter(View view) {
        this.view = view;
    }

    public StudentLoginResponse loginStudent(StudentLoginRequest request) throws IOException {
        StudentLoginService service = new StudentLoginService();
        return service.loginStudent(request);
    }
}
