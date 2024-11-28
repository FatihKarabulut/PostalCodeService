package com.ahbap.GeonamesPostalCodeServiceLib.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestBean {

    @Bean
    @Scope("prototype")
    public RestTemplate tamplet()
    {
        return  new RestTemplate();
    }
}
