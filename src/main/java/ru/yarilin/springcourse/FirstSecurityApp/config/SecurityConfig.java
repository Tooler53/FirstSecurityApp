package ru.yarilin.springcourse.FirstSecurityApp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
//    @Bean
//    @ConditionalOnMissingBean(PersonDetailsService.class)
//    InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        String generatedPassword = "";
//        return new InMemoryUserDetailsManager(User.withUsername("user")
//                .password(generatedPassword).roles("USER").build());
//    }

    @Bean
    @ConditionalOnMissingBean(AuthenticationEventPublisher.class)
    DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher(ApplicationEventPublisher delegate) {
        return new DefaultAuthenticationEventPublisher(delegate);
    }
}
