package com.lwn.handlers;

import com.lwn.Request;
import com.lwn.Response;

import java.time.LocalDateTime;

public class TimeHandler implements HttpHandler{

    @Override
    public Response handle(Request request) {
        String body = "Hora actual: " + LocalDateTime.now();
        return new Response(200,"text/plain", body);
    }
}
