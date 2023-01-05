package com.example.springsecurity.security;

import com.example.springsecurity.filters.CustomAuthenticationFilter;
import com.example.springsecurity.filters.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration {
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable();
        http.headers().frameOptions().disable();

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.GET, "/login").permitAll(); //token almak için
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/users/**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/users/**").hasAnyAuthority("ROLE_ADMIN");

        //FACULTY
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/faculty").hasAnyAuthority("ROLE_ADMIN","ROLE_FACULTY_MANAGEMENT");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/faculty/{id}").hasAnyAuthority("ROLE_ADMIN","ROLE_FACULTY_MANAGEMENT");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/faculty/{id}").hasAnyAuthority("ROLE_ADMIN","ROLE_FACULTY_MANAGEMENT");


        //INSTITUTE
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/institute").hasAnyAuthority("ROLE_ADMIN","ROLE_INSTITUTE_MANAGEMENT");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/institute/{id}").hasAnyAuthority("ROLE_ADMIN","ROLE_INSTITUTE_MANAGEMENT");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/institute/{id}").hasAnyAuthority("ROLE_ADMIN","ROLE_INSTITUTE_MANAGEMENT");


        //DEPARTMENT
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/faculties/{id}/department").hasAnyAuthority("ROLE_ADMIN","ROLE_FACULTY_MANAGEMENT");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/department/{id}").hasAnyAuthority("ROLE_ADMIN","ROLE_FACULTY_MANAGEMENT","ROLE_INSTITUTE_MANAGEMENT");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/department/{id}").hasAnyAuthority("ROLE_ADMIN","ROLE_FACULTY_MANAGEMENT", "ROLE_INSTITUTE_MANAGEMENT");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/institute/{id}/department").hasAnyAuthority("ROLE_ADMIN","ROLE_INSTITUTE_MANAGEMENT");

        //COURSE
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/departments/{id}/course").hasAnyAuthority("ROLE_STUDENT","ROLE_FACULTY_MANAGEMENT","ROLE_INSTITUTE_MANAGEMENT");

        //PERSONAL
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/personal").hasAnyAuthority("ROLE_ADMIN");

        //STUDENT
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/student").hasAnyAuthority("ROLE_ADMIN");




        http.authorizeRequests().anyRequest().authenticated();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilter(new CustomAuthenticationFilter(authenticationManager(http.getSharedObject(AuthenticationConfiguration.class))));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
