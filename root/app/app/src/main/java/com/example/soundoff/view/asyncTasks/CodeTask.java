package com.example.soundoff.view.asyncTasks;

import android.os.AsyncTask;


import com.example.soundoff.presenter.CodePresenter;
import com.example.soundoff.service.request.CodeRequest;
import com.example.soundoff.service.response.CodeResponse;

import java.io.IOException;

public class CodeTask extends AsyncTask<CodeRequest, Void, CodeResponse> {
    private final CodePresenter presenter;
    private final CodeTask.Observer observer;
    private Exception exception;

    public interface Observer {
        void attendanceCodeSuccessful(CodeResponse codeResponse);
        void attendanceCodeUnsuccessful(CodeResponse codeResponse);
        void handleException(Exception ex);
    }

    public CodeTask(CodePresenter presenter, CodeTask.Observer observer) {
        if(observer == null) {
            throw new NullPointerException();
        }

        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected CodeResponse doInBackground(CodeRequest... codeRequests) {
        CodeResponse codeResponse = null;

        try {
            codeResponse = presenter.attendanceCode(codeRequests[0]);

            if(codeResponse.isSuccess()) {
                //loadImage(registerResponse.getUser());
//                StoryPresenter presenter = new StoryPresenter(this);
//                GetStoryTask getStoryTask = new GetStoryTask(presenter, this);
//                StoryRequest request = new StoryRequest(postResponse.getPost().getPoster(), 10, null);
//                getStoryTask.execute(request);
            }
        } catch (IOException ex) {
            exception = ex;
        }

        return codeResponse;
    }

    @Override
    protected void onPostExecute(CodeResponse codeResponse) {
        if(exception != null) {
            observer.handleException(exception);
        } else if(codeResponse.isSuccess()) {
            observer.attendanceCodeSuccessful(codeResponse);
        } else {
            observer.attendanceCodeUnsuccessful(codeResponse);
        }
    }
}
