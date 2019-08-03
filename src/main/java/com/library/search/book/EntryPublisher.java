package com.library.search.book;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 * Service Book Search
 */

import java.net.InetSocketAddress;
import javax.ws.rs.ext.RuntimeDelegate;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 *
 * Class to manage the publisher
 */

public class EntryPublisher {

    private static final int port = 8091;
    private static final String uri = "/books/";
    private static final String url = "http://localhost:" + port + uri;

    /**
     * HTTPSERVER CREATION
     * @return HttpServer created
     *
     */

    private HttpServer getServer() {
        HttpServer server = null;
        int backlog = 8;
        try {
            server = HttpServer.create(new InetSocketAddress("localhost", port), backlog);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return server;
    }

    /**
     * Point of entry main class
     * @param args args
     *
     */

    public static void main(String[ ] args) {
        new EntryPublisher().publish();
    }

    /**
     * End point
     *
     */

    private void publish() {
        HttpServer server = getServer();
        HttpHandler requestHandler =
                RuntimeDelegate.getInstance().createEndpoint(new AppConfig(), HttpHandler.class);
        server.createContext(uri, requestHandler);
        server.start();
        msg(server);
    }

    /**
     * Server Confirmation
     * @param server server confirmation
     */
    private void msg(HttpServer server) {
        String out = "Publishing Library on " + url + ". Hit any key to stop.";
        System.out.println(out);
        try {
            System.in.read();
        } catch(Exception e) { }
        server.stop(0); // normal termination
    }
}