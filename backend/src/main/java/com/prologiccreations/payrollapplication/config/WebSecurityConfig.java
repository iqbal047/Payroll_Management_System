package com.prologiccreations.payrollapplication.config;//package com.isdbbros.realestate.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .anyRequest().permitAll()
//                )
//                .csrf((csrf) -> csrf.ignoringRequestMatchers("/token"))
//                .httpBasic(AbstractHttpConfigurer::disable)
////            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////            .exceptionHandling((exceptions) -> exceptions
////                    .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
////                    .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
////            )
//        ;
//        return http.build();
//    }
//
//}