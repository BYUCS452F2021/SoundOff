package com.example.soundoff.service;

import com.example.soundoff.data.ServerConnection.ServerFacade;
import com.example.soundoff.service.request.CodeRequest;
import com.example.soundoff.service.response.CodeResponse;

public class CodeService {
    public CodeResponse attendanceCode(CodeRequest request) {

        CodeResponse response = getServerFacade().attendanceCode(request);

        return response;
    }

    ServerFacade getServerFacade() {
        return new ServerFacade();
    }
}
