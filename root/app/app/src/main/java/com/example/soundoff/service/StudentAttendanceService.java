package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.StudentAttendanceRequest;
import com.example.soundoff.service.response.StudentAttendanceResponse;


public class StudentAttendanceService {

    public StudentAttendanceResponse recordAttendance(StudentAttendanceRequest request) {
        StudentAttendanceResponse response = getServerFacade().recordAttendance(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
