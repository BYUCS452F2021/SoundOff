package com.example.soundoff.presenter;

import com.example.soundoff.service.request.Request;
import com.example.soundoff.service.response.Response;
import com.example.soundoff.service.ServiceObj;

public class Presenter {

    private final View view;

    public interface View {

    }

    public Presenter(View view) {
        this.view = view;
    }

    public Response connect(Request request){
        ServiceObj service = new ServiceObj();
        return service.connect(request);
    }
}
