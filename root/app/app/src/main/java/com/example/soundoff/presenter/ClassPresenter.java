package com.example.soundoff.presenter;


import com.example.soundoff.service.ClassService;
import com.example.soundoff.service.request.ClassRequest;
import com.example.soundoff.service.response.ClassResponse;

public class ClassPresenter {
    private final ClassPresenter.View view;

    public interface View {

    }

    public ClassPresenter(ClassPresenter.View view) {
        this.view = view;
    }

    public ClassResponse connect(ClassRequest request){
        ClassService service = new ClassService();
        return service.addClass(request);
    }
}
