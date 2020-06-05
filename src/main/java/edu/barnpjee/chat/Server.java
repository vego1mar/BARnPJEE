package edu.barnpjee.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.remoting.support.RemoteExporter;
import org.apache.xmlrpc.WebServer;

import java.io.IOException;


@SpringBootApplication
@Configuration
public class Server {

    public static int XML_RPC_SERVER_PORT = 15_000;

    @Bean(name = "/chat/Chat")
    RemoteExporter burlapService() throws IOException {
        WebServer xmlRpcServer = new WebServer(XML_RPC_SERVER_PORT);
        xmlRpcServer.addHandler("chat", new ChatImpl());
        xmlRpcServer.start();

        BurlapServiceExporter exporter = new BurlapServiceExporter();
        exporter.setService(new ChatImpl());
        exporter.setServiceInterface(Chat.class);
        return exporter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }

}
