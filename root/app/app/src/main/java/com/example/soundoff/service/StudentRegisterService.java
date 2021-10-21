package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.StudentRegisterRequest;
import com.example.soundoff.service.response.StudentRegisterResponse;

public class StudentRegisterService {
    public StudentRegisterResponse registerStudent(StudentRegisterRequest request) {
        StudentRegisterResponse response = getServerFacade().registerStudent(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
