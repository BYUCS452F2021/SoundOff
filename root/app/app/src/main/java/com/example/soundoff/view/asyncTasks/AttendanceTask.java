package com.example.soundoff.view.asyncTasks;

import android.os.AsyncTask;

import com.example.soundoff.presenter.AttendancePresenter;
import com.example.soundoff.presenter.TeacherRegisterPresenter;
import com.example.soundoff.service.request.AttendanceRequest;
import com.example.soundoff.service.request.TeacherRegisterRequest;
import com.example.soundoff.service.response.AttendanceResponse;
import com.example.soundoff.service.response.TeacherRegisterResponse;

import java.io.IOException;

public class AttendanceTask extends AsyncTask<AttendanceRequest, Void, AttendanceResponse> {
    private final AttendancePresenter presenter;
    private final AttendanceTask.Observer observer;
    private Exception exception;

    public interface Observer {
        void recordAttendanceSuccessful(AttendanceResponse attendanceResponse);
        void recordAttendanceUnsuccessful(AttendanceResponse attendanceResponse);
        void handleException(Exception ex);
    }

    public AttendanceTask(AttendancePresenter presenter, AttendanceTask.Observer observer) {
        if(observer == null) {
            throw new NullPointerException();
        }

        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected AttendanceResponse doInBackground(AttendanceRequest... attendanceRequests) {
        AttendanceResponse attendanceResponse = null;

        try {
            attendanceResponse = presenter.recordAttendance(attendanceRequests[0]);

            if(attendanceResponse.isSuccess()) {
                //loadImage(registerResponse.getUser());
//                StoryPresenter presenter = new StoryPresenter(this);
//                GetStoryTask getStoryTask = new GetStoryTask(presenter, this);
//                StoryRequest request = new StoryRequest(postResponse.getPost().getPoster(), 10, null);
//                getStoryTask.execute(request);
            }
        } catch (IOException ex) {
            exception = ex;
        }

        return attendanceResponse;
    }

    @Override
    protected void onPostExecute(AttendanceResponse attendanceResponse) {
        if(exception != null) {
            observer.handleException(exception);
        } else if(attendanceResponse.isSuccess()) {
            observer.recordAttendanceSuccessful(attendanceResponse);
        } else {
            observer.recordAttendanceUnsuccessful(attendanceResponse);
        }
    }
}

