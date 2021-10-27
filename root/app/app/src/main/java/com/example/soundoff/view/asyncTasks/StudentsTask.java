package com.example.soundoff.view.asyncTasks;

import android.os.AsyncTask;


import com.example.soundoff.presenter.StudentsPresenter;
import com.example.soundoff.service.request.StudentsRequest;
import com.example.soundoff.service.response.StudentsResponse;

import java.io.IOException;

public class StudentsTask extends AsyncTask<StudentsRequest, Void, StudentsResponse> {
    private final StudentsPresenter presenter;
    private final StudentsTask.Observer observer;
    private Exception exception;

    public interface Observer {
        void listStudentsSuccessful(StudentsResponse studentsResponse);
        void listStudentsUnsuccessful(StudentsResponse studentsResponse);
        void handleException(Exception ex);
    }

    public StudentsTask(StudentsPresenter presenter, StudentsTask.Observer observer) {
        if(observer == null) {
            throw new NullPointerException();
        }

        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected StudentsResponse doInBackground(StudentsRequest... studentsRequests) {
        StudentsResponse studentsResponse = null;

        try {
            studentsResponse = presenter.listStudents(studentsRequests[0]);

            if(studentsResponse.isSuccess()) {
                //loadImage(registerResponse.getUser());
//                StoryPresenter presenter = new StoryPresenter(this);
//                GetStoryTask getStoryTask = new GetStoryTask(presenter, this);
//                StoryRequest request = new StoryRequest(postResponse.getPost().getPoster(), 10, null);
//                getStoryTask.execute(request);
            }
        } catch (IOException ex) {
            exception = ex;
        }

        return studentsResponse;
    }

    @Override
    protected void onPostExecute(StudentsResponse studentsResponse) {
        if(exception != null) {
            observer.handleException(exception);
        } else if(studentsResponse.isSuccess()) {
            observer.listStudentsSuccessful(studentsResponse);
        } else {
            observer.listStudentsUnsuccessful(studentsResponse);
        }
    }
}
