package com.lwn.handlers;

import com.lwn.Request;
import com.lwn.Response;

public class NotFoundHandler implements HttpHandler {

    @Override
    public Response handle(Request request) {
        return new Response(404,"text/plain","404");
    }
}
