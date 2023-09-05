package edu.escuelaing.app;

import java.io.IOException;

public class MySparkApp {

    public static void main(String[] args) throws IOException {
        HttpServer.register("/hello", str -> HttpServer.getHello(str));
        HttpServer.register("/getFile", str -> {
            try {
                return HttpServer.getFile(str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        HttpServer.getInstance().start(args);
    }
}
