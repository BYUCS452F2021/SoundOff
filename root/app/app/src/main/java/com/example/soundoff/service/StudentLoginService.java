package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.StudentLoginRequest;
import com.example.soundoff.service.response.StudentLoginResponse;

public class StudentLoginService {
    public StudentLoginResponse loginStudent(StudentLoginRequest request) {
        StudentLoginResponse response = getServerFacade().loginStudent(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
