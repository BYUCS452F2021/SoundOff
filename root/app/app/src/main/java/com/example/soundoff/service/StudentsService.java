package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.StudentsRequest;
import com.example.soundoff.service.response.StudentsResponse;

public class StudentsService {
    public StudentsResponse listStudents(StudentsRequest request) {
        StudentsResponse response = getServerFacade().listStudents(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
