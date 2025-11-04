package com.lwn;

import com.lwn.handlers.HttpHandler;
import com.lwn.logger.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {

    private final int port;
    private final ExecutorService pool;
    private final Router router;

    public HttpServer (int port, Router router, int maxTheads) {
        this.port = port;
        this.router = router;
        this.pool = Executors.newFixedThreadPool(maxTheads);
    }


    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket client = serverSocket.accept();
                pool.submit(() -> handleClient(client));
            }
        }
    }

    public void handleClient (Socket client) {

        long start = System.currentTimeMillis();
        String clientIp = client.getInetAddress().getHostAddress();

        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                client.getInputStream()
                        ));
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(
                                client.getOutputStream()
                        ));

        ) {
            //Leer la primera linea: "GET /RUTA http/1.1"
            String requestLine = in.readLine();
            if(requestLine == null) return;
            String [] parts = requestLine.split(" ");
            if(parts.length < 2) return;
            String method = parts[0];
            String path = parts[1];

            //Crear la request

            Request request = new Request(method,path);

            //Ejecutar el handler y recibir la respuesta

            HttpHandler handler = router.findHandler(path);
            Response response = handler.handle(request);

            //Escribir la respuesta

            out.write("HTTP/1.1"+ response.getStatus() + " OK\r\n");
            out.write("Content-Type: "+ response.getContentType() + "\r\n");
            out.write("Content-Length: " +response.getBody().getBytes().length + "\r\n");
            out.write("Connection: close\r\n\r\n");
            out.write(response.getBody());
            out.flush();

            long elapsed = System.currentTimeMillis() - start;
            Logger.info (method + " " + path + " (" + response.getStatus() + ") from" +
                    clientIp + " in " + elapsed + "ms");



        } catch (IOException e) {
            Logger.info("Error en cliente : " + clientIp + ": " + e.getMessage());
        }
    }
}
