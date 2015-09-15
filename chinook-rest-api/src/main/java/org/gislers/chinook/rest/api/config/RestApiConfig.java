package org.gislers.chinook.rest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by:   jgisle
 * Created date: 9/8/15
 */
@Configuration
@ComponentScan("org.gislers.chinook")
public class RestApiConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer applicationProperties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
