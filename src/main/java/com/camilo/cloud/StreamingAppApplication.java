package com.camilo.cloud;

import com.camilo.cloud.model.Contributor;
import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class StreamingAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StreamingAppApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        Github github = Feign.builder()
                .decoder(new GsonDecoder())
                .target(Github.class, "https://api.github.com");

        // Fetch and print a list of the contributors to this library.
        List<Contributor> contributors = github.contributors("docker", "docker");
        for (Contributor contributor : contributors) {
            log.info(contributor.getLogin() + " (" + contributor.getContributions() + ")");
        }
    }
}
