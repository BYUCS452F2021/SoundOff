package com.example.soundoff.view.asyncTasks;

import android.os.AsyncTask;

import com.example.soundoff.presenter.TeacherRegisterPresenter;
import com.example.soundoff.service.request.TeacherRegisterRequest;
import com.example.soundoff.service.response.TeacherRegisterResponse;

import java.io.IOException;

public class TeacherRegisterTask extends AsyncTask<TeacherRegisterRequest, Void, TeacherRegisterResponse> {
    private final TeacherRegisterPresenter presenter;
    private final TeacherRegisterTask.Observer observer;
    private Exception exception;

    public interface Observer {
        void teacherRegisterSuccessful(TeacherRegisterResponse teacherRegisterResponse);
        void teacherRegisterUnsuccessful(TeacherRegisterResponse teacherRegisterResponse);
        void handleException(Exception ex);
    }

    public TeacherRegisterTask(TeacherRegisterPresenter presenter, TeacherRegisterTask.Observer observer) {
        if(observer == null) {
            throw new NullPointerException();
        }

        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected TeacherRegisterResponse doInBackground(TeacherRegisterRequest... teacherRegisterRequests) {
        TeacherRegisterResponse teacherRegisterResponse = null;

//        try {
            teacherRegisterResponse = presenter.registerTeacher(teacherRegisterRequests[0]);

            if(teacherRegisterResponse.isSuccess()) {
                //loadImage(registerResponse.getUser());
//                StoryPresenter presenter = new StoryPresenter(this);
//                GetStoryTask getStoryTask = new GetStoryTask(presenter, this);
//                StoryRequest request = new StoryRequest(postResponse.getPost().getPoster(), 10, null);
//                getStoryTask.execute(request);
            }
//        } catch (IOException ex) {
//            exception = ex;
//        }

        return teacherRegisterResponse;
    }

    @Override
    protected void onPostExecute(TeacherRegisterResponse teacherRegisterResponse) {
        if(exception != null) {
            observer.handleException(exception);
        } else if(teacherRegisterResponse.isSuccess()) {
            observer.teacherRegisterSuccessful(teacherRegisterResponse);
        } else {
            observer.teacherRegisterUnsuccessful(teacherRegisterResponse);
        }
    }
}
