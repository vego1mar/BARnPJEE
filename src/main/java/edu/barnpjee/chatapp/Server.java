package edu.barnpjee.chatapp;

import org.apache.xmlrpc.WebServer;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.remoting.support.RemoteExporter;


@SpringBootApplication
public class Server {

    public static int XML_RPC_PORT_NUMBER = 15_000;

    @Bean(name = "/burlap")
    RemoteExporter burlapService() {
        BurlapServiceExporter exporter = new BurlapServiceExporter();
        exporter.setService(new ChatApp());
        exporter.setServiceInterface(BurlapJunction.class);
        return exporter;
    }

    private static @NotNull WebServer getXLMRPCServer() {
        WebServer server = new WebServer(XML_RPC_PORT_NUMBER);
        server.addHandler("XMLRPCServer", Server.class);
        return server;
    }

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
        getXLMRPCServer().run();
    }

}
