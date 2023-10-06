package com.Gleb.hotelroomreservations.configurs;

import com.Gleb.hotelroomreservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        List<com.Gleb.hotelroomreservations.models.User> usersList = userRepository.getUsersList();
        List<UserDetails> usersDetails = new ArrayList<>();

        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).isAdmin()) {
                usersDetails.add(User.withDefaultPasswordEncoder().username(usersList.get(i).getLogin())
                                .password(new String(Base64.getDecoder().decode(usersList.get(i).getPassw())))
                                .roles("ADMIN", "USER").build());
            }
            else {
                usersDetails.add(User.withDefaultPasswordEncoder().username(usersList.get(i).getLogin())
                        .password(new String(Base64.getDecoder().decode(usersList.get(i).getPassw())))
                        .roles("USER").build());
            }
        }

        return new InMemoryUserDetailsManager(usersDetails);
    }

}
