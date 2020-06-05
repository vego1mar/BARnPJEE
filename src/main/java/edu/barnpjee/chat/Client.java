package edu.barnpjee.chat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {

//    @Bean(name = "/chat")
//    public BurlapProxyFactoryBean burlapInvoker() {
//        BurlapProxyFactoryBean invoker = new BurlapProxyFactoryBean();
//        invoker.setServiceUrl("http://localhost:8080/chat");
//        invoker.setServiceInterface(ChatFacility.class);
//        return invoker;
//    }

    private static void runChat() {
        ApplicationContext context = new ClassPathXmlApplicationContext("burlap-proxy.xml");
        Chat chat = (Chat) context.getBean("burlapProxyBean");
        System.out.println(chat.readMessages());
    }

    public static void main(String[] args) {
        runChat();
    }

}
