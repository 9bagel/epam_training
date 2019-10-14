package com.epam.tasks_6.archive.server;

import com.epam.tasks_6.archive.server.server.Server;

public class ServerMain {
    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }
}
