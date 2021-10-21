package com.example.soundoff.presenter;


import com.example.soundoff.service.TeacherLoginService;
import com.example.soundoff.service.request.TeacherLoginRequest;
import com.example.soundoff.service.response.TeacherLoginResponse;

public class TeacherLoginPresenter {
    private final TeacherLoginPresenter.View view;

    public interface View {

    }

    public TeacherLoginPresenter(TeacherLoginPresenter.View view) {
        this.view = view;
    }

    public TeacherLoginResponse loginTeacher(TeacherLoginRequest request){
        TeacherLoginService service = new TeacherLoginService();
        return service.loginTeacher(request);
    }
}
