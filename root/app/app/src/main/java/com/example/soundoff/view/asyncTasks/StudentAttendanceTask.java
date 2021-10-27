package com.example.soundoff.view.asyncTasks;

import android.os.AsyncTask;

import com.example.soundoff.presenter.StudentAttendancePresenter;
import com.example.soundoff.service.StudentAttendanceService;
import com.example.soundoff.service.request.StudentAttendanceRequest;
import com.example.soundoff.service.response.StudentAttendanceResponse;

import java.io.IOException;

public class StudentAttendanceTask extends AsyncTask<StudentAttendanceRequest, Void, StudentAttendanceResponse> {
    private final StudentAttendancePresenter presenter;
    private final StudentAttendanceTask.Observer observer;
    private Exception exception;

    public interface Observer {
        void recordAttendanceSuccessful(StudentAttendanceResponse studentAttendanceResponse);
        void recordAttendanceUnsuccessful(StudentAttendanceResponse studentAttendanceResponse);
        void handleException(Exception ex);
    }

    public StudentAttendanceTask(StudentAttendancePresenter presenter, StudentAttendanceTask.Observer observer) {
        if(observer == null) {
            throw new NullPointerException();
        }

        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected StudentAttendanceResponse doInBackground(StudentAttendanceRequest... studentAttendanceRequests) {
        StudentAttendanceResponse studentAttendanceResponse = null;

        try {
            studentAttendanceResponse = presenter.recordAttendance(studentAttendanceRequests[0]);

            if(studentAttendanceResponse.isSuccess()) {
                //loadImage(registerResponse.getUser());
//                StoryPresenter presenter = new StoryPresenter(this);
//                GetStoryTask getStoryTask = new GetStoryTask(presenter, this);
//                StoryRequest request = new StoryRequest(postResponse.getPost().getPoster(), 10, null);
//                getStoryTask.execute(request);
            }
        } catch (IOException ex) {
            exception = ex;
        }

        return studentAttendanceResponse;
    }

    @Override
    protected void onPostExecute(StudentAttendanceResponse studentAttendanceResponse) {
        if(exception != null) {
            observer.handleException(exception);
        } else if(studentAttendanceResponse.isSuccess()) {
            observer.recordAttendanceSuccessful(studentAttendanceResponse);
        } else {
            observer.recordAttendanceUnsuccessful(studentAttendanceResponse);
        }
    }
}
