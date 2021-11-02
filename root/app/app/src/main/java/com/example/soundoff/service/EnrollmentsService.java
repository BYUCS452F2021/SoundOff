package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.EnrollmentRequest;
import com.example.soundoff.service.response.EnrollmentResponse;

import java.io.IOException;


public class EnrollmentsService {
    public EnrollmentResponse enroll(EnrollmentRequest request) throws IOException {
        EnrollmentResponse response = getServerFacade().enroll(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
