package com.example.soundoff.presenter;


import com.example.soundoff.service.TeacherRegisterService;
import com.example.soundoff.service.request.TeacherRegisterRequest;
import com.example.soundoff.service.response.TeacherRegisterResponse;

public class TeacherRegisterPresenter {

    private final TeacherRegisterPresenter.View view;

    public interface View {

    }

    public TeacherRegisterPresenter(TeacherRegisterPresenter.View view) {
        this.view = view;
    }

    public TeacherRegisterResponse registerTeacher(TeacherRegisterRequest request){
        TeacherRegisterService service = new TeacherRegisterService();
        return service.registerTeacher(request);
    }
}
