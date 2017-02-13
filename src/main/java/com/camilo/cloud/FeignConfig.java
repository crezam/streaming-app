package com.camilo.cloud;

import feign.Feign;
import feign.codec.Decoder;
import feign.gson.GsonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    interface Github {}

    @Bean
    public Github githubDecoder() {
        Decoder decoder = new GsonDecoder();
        return Feign.builder().decoder(decoder).target(Github.class, "https://api.github.com");
    }
}
