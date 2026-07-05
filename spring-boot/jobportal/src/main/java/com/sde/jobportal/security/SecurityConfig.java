package com.sde.jobportal.security;

import com.sde.jobportal.security.filter.JwtTokenValidatorFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final List<String> publicPaths;
    private final List<String> securedPaths;
    public SecurityConfig(
            @Qualifier("publicPaths") List<String> publicPaths,
            @Qualifier("securedPaths") List<String> securedPaths) {
        this.publicPaths = publicPaths;
        this.securedPaths = securedPaths;
    }
    @Bean
    SecurityFilterChain customSecurityFilterChain(HttpSecurity http) {
        return  http.csrf(AbstractHttpConfigurer::disable)
                .cors(crosConfig -> crosConfig.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(requests -> {
                    publicPaths.forEach(path -> requests.requestMatchers(path).permitAll());
                    securedPaths.forEach(path -> requests.requestMatchers(path).authenticated());
                    requests.anyRequest().denyAll();
                })
//                .authorizeHttpRequests((requests) ->
////                requests.requestMatchers("/api/companies/public").permitAll()
////                        .requestMatchers("/api/contacts/public").permitAll()
//                        requests.requestMatchers(RegexRequestMatcher.regexMatcher(".*public$")).permitAll()
//                                .requestMatchers("/api/swagger-ui.html",
//                                        "/swagger-ui/**",
//                                        "spi/v3/api-docs/**",
//                                        "swagger-ui.html",
//                                        "webjars/**").permitAll())
                .addFilterBefore(new JwtTokenValidatorFilter(publicPaths), BasicAuthenticationFilter.class)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .build();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http:/localhost:5173"));
        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public UserDetailsService userDetailsService() {
       var user =  User.builder().username("bhushan")
                .password("$2a$10$oTVqEu8ILO8ynwhBsnYSD.XQ/RmqySiGGx5UWBSMwVu/qwMGWcSKy")
                .roles("ADMIN").build();

        var user1 = User.builder().username("madan")
                .password("$2a$10$r4tCTHa.XC9paTSswmNvSe009ihAZvOtT.tDuJXl.vI1bh62TUwZm")
                .roles("USER").build();
        return new InMemoryUserDetailsManager(user, user1);
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        var authenticationProvider = new DaoAuthenticationProvider(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return  new ProviderManager(authenticationProvider);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
