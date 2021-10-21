package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.Request;
import com.example.soundoff.service.response.Response;

public class ServiceObj {

    public Response connect(Request request) {
        Response response = getServerFacade().connect(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
