package com.lwn.handlers;

import com.lwn.Request;
import com.lwn.Response;

public class RootHandler implements HttpHandler {

    @Override
    public Response handle(Request request) {
        String body = "<h1> Bienvendio a mi servidor HTTP </h1>";

        return new Response(200,"text/html", body);
    }
}
