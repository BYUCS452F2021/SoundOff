package com.example.soundoff.presenter;

import com.example.soundoff.service.EnrollmentsService;
import com.example.soundoff.service.request.EnrollmentRequest;
import com.example.soundoff.service.response.EnrollmentResponse;

import java.io.IOException;

public class EnrollmentsPresenter {

    private final EnrollmentsPresenter.View view;

    public interface View {

    }

    public EnrollmentsPresenter(EnrollmentsPresenter.View view) {
        this.view = view;
    }

    public EnrollmentResponse enroll(EnrollmentRequest request) throws IOException {
        EnrollmentsService service = new EnrollmentsService();
        return service.enroll(request);
    }
}
