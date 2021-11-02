package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.ClassRequest;
import com.example.soundoff.service.response.ClassResponse;

import java.io.IOException;

public class ClassService {

    public ClassResponse addClass(ClassRequest request) throws IOException {
        ClassResponse response = getServerFacade().addClass(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
