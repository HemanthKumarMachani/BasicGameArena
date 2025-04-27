package org.initial.basicgamearena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BasicGameArenaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicGameArenaApplication.class, args);
    }

}
