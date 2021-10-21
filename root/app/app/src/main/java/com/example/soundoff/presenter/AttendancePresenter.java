package com.example.soundoff.presenter;


import com.example.soundoff.service.AttendanceService;
import com.example.soundoff.service.request.AttendanceRequest;
import com.example.soundoff.service.response.AttendanceResponse;

public class AttendancePresenter {
    private final AttendancePresenter.View view;

    public interface View {

    }

    public AttendancePresenter(AttendancePresenter.View view) {
        this.view = view;
    }

    public AttendanceResponse connect(AttendanceRequest request){
        AttendanceService service = new AttendanceService();
        return service.recordAttendance(request);
    }
}
