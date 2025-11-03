package com.lwn.handlers;

import com.lwn.Request;
import com.lwn.Response;

public interface HttpHandler {

    Response handle(Request request);
}
