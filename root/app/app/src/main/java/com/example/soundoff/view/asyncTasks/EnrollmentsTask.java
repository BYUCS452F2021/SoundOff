package com.example.soundoff.view.asyncTasks;

import android.os.AsyncTask;


import com.example.soundoff.presenter.EnrollmentsPresenter;
import com.example.soundoff.service.request.EnrollmentRequest;
import com.example.soundoff.service.response.EnrollmentResponse;

import java.io.IOException;

public class EnrollmentsTask extends AsyncTask<EnrollmentRequest, Void, EnrollmentResponse> {
    private final EnrollmentsPresenter presenter;
    private final EnrollmentsTask.Observer observer;
    private Exception exception;

    public interface Observer {
        void enrollSuccessful(EnrollmentResponse enrollmentResponse);
        void enrollUnsuccessful(EnrollmentResponse enrollmentResponse);
        void handleException(Exception ex);
    }

    public EnrollmentsTask(EnrollmentsPresenter presenter, EnrollmentsTask.Observer observer) {
        if(observer == null) {
            throw new NullPointerException();
        }

        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected EnrollmentResponse doInBackground(EnrollmentRequest... enrollmentRequests) {
        EnrollmentResponse enrollmentResponse = null;

        try {
            enrollmentResponse = presenter.enroll(enrollmentRequests[0]);

            if(enrollmentResponse.isSuccess()) {
                //loadImage(registerResponse.getUser());
//                StoryPresenter presenter = new StoryPresenter(this);
//                GetStoryTask getStoryTask = new GetStoryTask(presenter, this);
//                StoryRequest request = new StoryRequest(postResponse.getPost().getPoster(), 10, null);
//                getStoryTask.execute(request);
            }
        } catch (IOException ex) {
            exception = ex;
        }

        return enrollmentResponse;
    }

    @Override
    protected void onPostExecute(EnrollmentResponse enrollmentResponse) {
        if(exception != null) {
            observer.handleException(exception);
        } else if(enrollmentResponse.isSuccess()) {
            observer.enrollSuccessful(enrollmentResponse);
        } else {
            observer.enrollUnsuccessful(enrollmentResponse);
        }
    }
}
