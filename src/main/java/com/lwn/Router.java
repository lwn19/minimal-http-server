package com.lwn;

import com.lwn.handlers.HttpHandler;
import com.lwn.handlers.NotFoundHandler;

import java.util.HashMap;
import java.util.Map;

public class Router {

    private final Map<String, HttpHandler> routes = new HashMap<> ();

    public void addRoute(String path, HttpHandler handler) {
        routes.put(path, handler);
    }

    public HttpHandler findHandler(String path) {
        return routes.getOrDefault(path, new NotFoundHandler());
    }
}
