package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.EnrollmentRequest;
import com.example.soundoff.service.response.EnrollmentResponse;


public class EnrollmentsService {
    public EnrollmentResponse enroll(EnrollmentRequest request) {
        EnrollmentResponse response = getServerFacade().enroll(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
