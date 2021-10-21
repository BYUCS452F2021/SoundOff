package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.TeacherLoginRequest;
import com.example.soundoff.service.response.TeacherLoginResponse;

public class TeacherLoginService {


    public TeacherLoginResponse loginTeacher(TeacherLoginRequest request) {
        TeacherLoginResponse response = getServerFacade().loginTeacher(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
