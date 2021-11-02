package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.StudentAttendanceRequest;
import com.example.soundoff.service.response.StudentAttendanceResponse;

import java.io.IOException;


public class StudentAttendanceService {

    public StudentAttendanceResponse recordAttendance(StudentAttendanceRequest request) throws IOException {
        StudentAttendanceResponse response = getServerFacade().recordAttendance(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
