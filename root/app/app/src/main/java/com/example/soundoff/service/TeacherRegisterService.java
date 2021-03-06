package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.TeacherRegisterRequest;
import com.example.soundoff.service.response.TeacherRegisterResponse;

import java.io.IOException;

public class TeacherRegisterService {

    public TeacherRegisterResponse registerTeacher(TeacherRegisterRequest request) throws IOException {
        TeacherRegisterResponse response = getServerFacade().registerTeacher(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
