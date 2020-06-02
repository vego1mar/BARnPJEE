package edu.barnpjee.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;


public class Client {

    @Bean(name = "/chat")
    public BurlapProxyFactoryBean burlapInvoker() {
        BurlapProxyFactoryBean invoker = new BurlapProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:8080/chat");
        invoker.setServiceInterface(Calculation.class);
        return invoker;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        Calculation calculation = (Calculation) context.getBean("calculationBean");
        System.out.println(calculation.cube(3));
    }

}