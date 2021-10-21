package com.example.soundoff.presenter;

import com.example.soundoff.service.CodeService;
import com.example.soundoff.service.request.CodeRequest;
import com.example.soundoff.service.response.CodeResponse;

public class CodePresenter {
    private final CodePresenter.View view;

    public interface View {

    }

    public CodePresenter(CodePresenter.View view) {
        this.view = view;
    }

    public CodeResponse attendanceCode(CodeRequest request){
        CodeService service = new CodeService();
        return service.attendanceCode(request);
    }
}
