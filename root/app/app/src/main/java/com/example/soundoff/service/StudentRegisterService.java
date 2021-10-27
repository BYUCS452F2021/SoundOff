package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.StudentRegisterRequest;
import com.example.soundoff.service.response.StudentRegisterResponse;

import java.io.IOException;

public class StudentRegisterService {
    public StudentRegisterResponse registerStudent(StudentRegisterRequest request) throws IOException {
        StudentRegisterResponse response = getServerFacade().registerStudent(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
