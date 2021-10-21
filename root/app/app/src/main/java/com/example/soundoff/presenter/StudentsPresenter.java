package com.example.soundoff.presenter;

import com.example.soundoff.service.StudentsService;
import com.example.soundoff.service.request.StudentsRequest;
import com.example.soundoff.service.response.StudentsResponse;


public class StudentsPresenter {
    private final StudentsPresenter.View view;

    public interface View {

    }

    public StudentsPresenter(StudentsPresenter.View view) {
        this.view = view;
    }

    public StudentsResponse listStudents(StudentsRequest request){
        StudentsService service = new StudentsService();
        return service.listStudents(request);
    }
}
