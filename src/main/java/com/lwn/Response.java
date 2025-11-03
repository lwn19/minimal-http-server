package com.lwn;

public class Response {

    private final int status;
    private final String contentType;
    private final String body;

    public Response(int status, String contentType, String body) {
        this.status = status;
        this.contentType = contentType;
        this.body = body;
    }
    public int getStatus() {
        return this.status;
    }
    public String getContentType() {
        return this.contentType;
    }
    public String getBody() {
        return this.body;
    }
}
