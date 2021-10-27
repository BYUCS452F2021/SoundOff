package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.TeacherLoginRequest;
import com.example.soundoff.service.response.TeacherLoginResponse;

import java.io.IOException;

public class TeacherLoginService {


    public TeacherLoginResponse loginTeacher(TeacherLoginRequest request) throws IOException {
        TeacherLoginResponse response = getServerFacade().loginTeacher(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
