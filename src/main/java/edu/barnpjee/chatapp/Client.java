package edu.barnpjee.chatapp;

import org.apache.xmlrpc.XmlRpcClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;

import java.net.MalformedURLException;


@Configuration
public class Client {

    private static final String BASE_URL = "http://localhost:";
    public static final String BURLAP_SERVICE_URL = BASE_URL + "8080/burlap";
    public static final String XML_RPC_CLIENT_URL = BASE_URL + Server.XML_RPC_PORT_NUMBER;

    @Bean
    public BurlapProxyFactoryBean burlapInvoker() {
        BurlapProxyFactoryBean invoker = new BurlapProxyFactoryBean();
        invoker.setServiceUrl(BURLAP_SERVICE_URL);
        invoker.setServiceInterface(BurlapJunction.class);
        return invoker;
    }

    @Bean
    public XmlRpcClient getXMLRPCClient() throws MalformedURLException {
        return new XmlRpcClient(XML_RPC_CLIENT_URL);
    }

    public static void main(String[] args) {
        //ConfigurableApplicationContext context = SpringApplication.run(Server.class, args);
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Server.class).headless(false).run(args);
        BurlapJunction chatApp = context.getBean(BurlapJunction.class);

        chatApp.writeMessages("First msg!");
        String messages = chatApp.readMessages();
        System.out.println(messages);
    }

}
