package com.lwn;

import com.lwn.handlers.RootHandler;
import com.lwn.handlers.TimeHandler;

public class Server {

    public static void main(String[] args) throws Exception {
        Router router = new Router();
        router.addRoute("/",new RootHandler());
        router.addRoute("/time",new TimeHandler());

        HttpServer server = new HttpServer(8080,router,8);
        server.start();
    }
}
