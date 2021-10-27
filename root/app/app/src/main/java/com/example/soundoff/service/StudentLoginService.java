package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.StudentLoginRequest;
import com.example.soundoff.service.response.StudentLoginResponse;

import java.io.IOException;

public class StudentLoginService {
    public StudentLoginService() {
    }

    public StudentLoginResponse loginStudent(StudentLoginRequest request) throws IOException {
        StudentLoginResponse response = getServerFacade().loginStudent(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
