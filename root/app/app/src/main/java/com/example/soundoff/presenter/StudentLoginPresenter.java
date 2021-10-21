package com.example.soundoff.presenter;

import com.example.soundoff.service.StudentLoginService;
import com.example.soundoff.service.request.StudentLoginRequest;
import com.example.soundoff.service.response.StudentLoginResponse;

public class StudentLoginPresenter {
    private final StudentLoginPresenter.View view;

    public interface View {

    }

    public StudentLoginPresenter(StudentLoginPresenter.View view) {
        this.view = view;
    }

    public StudentLoginResponse loginStudent(StudentLoginRequest request){
        StudentLoginService service = new StudentLoginService();
        return service.loginStudent(request);
    }
}
