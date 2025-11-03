package com.lwn;

public class Request {

    private final String method;
    private final String path;

    public Request(String method, String path) {
        this.method = method;
        this.path = path;
    }
    public String getMethod() {
        return this.method;
    }
    public String getPath() {
        return this.path;
    }

}
