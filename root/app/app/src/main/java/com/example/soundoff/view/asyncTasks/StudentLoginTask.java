package com.example.soundoff.view.asyncTasks;

import android.os.AsyncTask;

import com.example.soundoff.presenter.StudentLoginPresenter;
import com.example.soundoff.service.request.StudentLoginRequest;
import com.example.soundoff.service.response.StudentLoginResponse;

import java.io.IOException;

public class StudentLoginTask extends AsyncTask<StudentLoginRequest, Void, StudentLoginResponse> {
    private final StudentLoginPresenter presenter;
    private final StudentLoginTask.Observer observer;
    private Exception exception;

    public interface Observer {
        void studentLoginSuccessful(StudentLoginResponse studentLoginResponse);
        void studentLoginUnsuccessful(StudentLoginResponse studentLoginResponse);
        void handleException(Exception ex);
    }

    public StudentLoginTask(StudentLoginPresenter presenter, StudentLoginTask.Observer observer) {
        if(observer == null) {
            throw new NullPointerException();
        }

        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected StudentLoginResponse doInBackground(StudentLoginRequest... studentLoginRequests) {
        StudentLoginResponse studentLoginResponse = null;

        try {
            studentLoginResponse = presenter.loginStudent(studentLoginRequests[0]);

            if(studentLoginResponse.isSuccess()) {
                //loadImage(registerResponse.getUser());
//                StoryPresenter presenter = new StoryPresenter(this);
//                GetStoryTask getStoryTask = new GetStoryTask(presenter, this);
//                StoryRequest request = new StoryRequest(postResponse.getPost().getPoster(), 10, null);
//                getStoryTask.execute(request);
            }
        } catch (IOException ex) {
            exception = ex;
        }

        return studentLoginResponse;
    }

    @Override
    protected void onPostExecute(StudentLoginResponse studentLoginResponse) {
        if(exception != null) {
            observer.handleException(exception);
        } else if(studentLoginResponse.isSuccess()) {
            observer.studentLoginSuccessful(studentLoginResponse);
        } else {
            observer.studentLoginUnsuccessful(studentLoginResponse);
        }
    }
}
