package com.example.soundoff.presenter;


import com.example.soundoff.service.AttendanceService;
import com.example.soundoff.service.request.AttendanceRequest;
import com.example.soundoff.service.response.AttendanceResponse;

import java.io.IOException;

public class AttendancePresenter {
    private final AttendancePresenter.View view;

    public interface View {

    }

    public AttendancePresenter(AttendancePresenter.View view) {
        this.view = view;
    }

    public AttendanceResponse recordAttendance(AttendanceRequest request) throws IOException {
        AttendanceService service = new AttendanceService();
        return service.recordAttendance(request);
    }
}
