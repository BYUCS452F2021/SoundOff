package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.AttendanceRequest;
import com.example.soundoff.service.response.AttendanceResponse;

public class AttendanceService {
    public AttendanceResponse recordAttendance(AttendanceRequest request) {
        AttendanceResponse response = getServerFacade().recordAttendance(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
