//package com.example.demo.security.jwt;
//
//import com.example.demo.security.JwtUserDetailsService;
//import lombok.AllArgsConstructor;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@AllArgsConstructor
//public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
//
//    private final JwtUtil jwtUtil;
//    private final JwtUserDetailsService jwtUserDetailsService;
//
//
//    @Override
//    public void configure(HttpSecurity httpSecurity) {
//        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtUtil, jwtUserDetailsService);
//        httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//}
