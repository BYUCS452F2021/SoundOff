package com.example.soundoff.view.asyncTasks;

import android.os.AsyncTask;

import com.example.soundoff.presenter.ClassPresenter;
import com.example.soundoff.service.request.ClassRequest;
import com.example.soundoff.service.response.ClassResponse;

import java.io.IOException;

public class ClassTask extends AsyncTask<ClassRequest, Void, ClassResponse> {
    private final ClassPresenter presenter;
    private final ClassTask.Observer observer;
    private Exception exception;

    public interface Observer {
        void addClassSuccessful(ClassResponse classResponse);

        void addClassUnsuccessful(ClassResponse classResponse);

        void handleException(Exception ex);
    }

    public ClassTask(ClassPresenter presenter, ClassTask.Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }

        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected ClassResponse doInBackground(ClassRequest... classRequests) {
        ClassResponse classResponse = null;

        try {
            classResponse = presenter.addClass(classRequests[0]);

            if (classResponse.isSuccess()) {
                //loadImage(registerResponse.getUser());
//                StoryPresenter presenter = new StoryPresenter(this);
//                GetStoryTask getStoryTask = new GetStoryTask(presenter, this);
//                StoryRequest request = new StoryRequest(postResponse.getPost().getPoster(), 10, null);
//                getStoryTask.execute(request);
            }
        } catch (IOException ex) {
            exception = ex;
        }

        return classResponse;
    }

    @Override
    protected void onPostExecute(ClassResponse classResponse) {
        if (exception != null) {
            observer.handleException(exception);
        } else if (classResponse.isSuccess()) {
            observer.addClassSuccessful(classResponse);
        } else {
            observer.addClassUnsuccessful(classResponse);
        }
    }
}
