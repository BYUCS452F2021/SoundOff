package com.example.soundoff.view.asyncTasks;

import android.os.AsyncTask;

import com.example.soundoff.presenter.StudentRegisterPresenter;
import com.example.soundoff.service.request.StudentRegisterRequest;
import com.example.soundoff.service.response.StudentRegisterResponse;

import java.io.IOException;

public class StudentRegisterTask extends AsyncTask<StudentRegisterRequest, Void, StudentRegisterResponse> {
    private final StudentRegisterPresenter presenter;
    private final StudentRegisterTask.Observer observer;
    private Exception exception;

    public interface Observer {
        void studentRegisterSuccessful(StudentRegisterResponse studentRegisterResponse);
        void studentRegisterUnsuccessful(StudentRegisterResponse studentRegisterResponse);
        void handleException(Exception ex);
    }

    public StudentRegisterTask(StudentRegisterPresenter presenter, StudentRegisterTask.Observer observer) {
        if(observer == null) {
            throw new NullPointerException();
        }

        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected StudentRegisterResponse doInBackground(StudentRegisterRequest... studentRegisterRequests) {
        StudentRegisterResponse studentRegisterResponse = null;

        try {
            studentRegisterResponse = presenter.registerStudent(studentRegisterRequests[0]);

            if(studentRegisterResponse.isSuccess()) {
                //loadImage(registerResponse.getUser());
//                StoryPresenter presenter = new StoryPresenter(this);
//                GetStoryTask getStoryTask = new GetStoryTask(presenter, this);
//                StoryRequest request = new StoryRequest(postResponse.getPost().getPoster(), 10, null);
//                getStoryTask.execute(request);
            }
        } catch (IOException ex) {
            exception = ex;
        }

        return studentRegisterResponse;
    }

    @Override
    protected void onPostExecute(StudentRegisterResponse studentRegisterResponse) {
        if(exception != null) {
            observer.handleException(exception);
        } else if(studentRegisterResponse.isSuccess()) {
            observer.studentRegisterSuccessful(studentRegisterResponse);
        } else {
            observer.studentRegisterUnsuccessful(studentRegisterResponse);
        }
    }
}
