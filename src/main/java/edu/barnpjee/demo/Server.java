package edu.barnpjee.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@SpringBootApplication
@Configuration
public class Server {

    @Bean(name = "/demo/Calculation")
    RemoteExporter burlapService() {
        BurlapServiceExporter exporter = new BurlapServiceExporter();
        exporter.setService(new CalculationImpl());
        exporter.setServiceInterface(Calculation.class);
        return exporter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }

}

