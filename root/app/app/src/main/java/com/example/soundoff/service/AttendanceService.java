package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.AttendanceRequest;
import com.example.soundoff.service.response.AttendanceResponse;

import java.io.IOException;

public class AttendanceService {
    public AttendanceResponse recordAttendance(AttendanceRequest request) throws IOException {
        AttendanceResponse response = getServerFacade().recordAttendance(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
