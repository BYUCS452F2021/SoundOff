package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.CodeRequest;
import com.example.soundoff.service.response.CodeResponse;

import java.io.IOException;

public class CodeService {
    public CodeResponse attendanceCode(CodeRequest request) throws IOException {

        CodeResponse response = getServerFacade().attendanceCode(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
