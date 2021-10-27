package com.example.soundoff.view.asyncTasks;

import android.os.AsyncTask;

import com.example.soundoff.presenter.TeacherLoginPresenter;
import com.example.soundoff.service.request.TeacherLoginRequest;
import com.example.soundoff.service.response.TeacherLoginResponse;

import java.io.IOException;

public class TeacherLoginTask extends AsyncTask<TeacherLoginRequest, Void, TeacherLoginResponse> {
    private final TeacherLoginPresenter presenter;
    private final TeacherLoginTask.Observer observer;
    private Exception exception;

    public interface Observer {
        void teacherLoginSuccessful(TeacherLoginResponse teacherLoginResponse);

        void teacherLoginUnsuccessful(TeacherLoginResponse teacherLoginResponse);

        void handleException(Exception ex);
    }

    public TeacherLoginTask(TeacherLoginPresenter presenter, TeacherLoginTask.Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }

        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected TeacherLoginResponse doInBackground(TeacherLoginRequest... teacherLoginRequests) {
        TeacherLoginResponse teacherLoginResponse = null;

        try {
            teacherLoginResponse = presenter.loginTeacher(teacherLoginRequests[0]);

            if (teacherLoginResponse.isSuccess()) {
                //loadImage(registerResponse.getUser());
//                StoryPresenter presenter = new StoryPresenter(this);
//                GetStoryTask getStoryTask = new GetStoryTask(presenter, this);
//                StoryRequest request = new StoryRequest(postResponse.getPost().getPoster(), 10, null);
//                getStoryTask.execute(request);
            }
        } catch (IOException ex) {
            exception = ex;
        }

        return teacherLoginResponse;
    }

    @Override
    protected void onPostExecute(TeacherLoginResponse teacherLoginResponse) {
        if (exception != null) {
            observer.handleException(exception);
        } else if (teacherLoginResponse.isSuccess()) {
            observer.teacherLoginSuccessful(teacherLoginResponse);
        } else {
            observer.teacherLoginUnsuccessful(teacherLoginResponse);
        }
    }
}