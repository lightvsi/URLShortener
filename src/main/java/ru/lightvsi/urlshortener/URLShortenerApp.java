package ru.lightvsi.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class URLShortenerApp {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(URLShortenerApp.class, args);
    }

}
