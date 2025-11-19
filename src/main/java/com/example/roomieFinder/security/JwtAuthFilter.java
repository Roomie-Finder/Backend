package com.example.roomieFinder.security;

import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final AuthUtil authUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("incoming request:{}",request.getHeader("Authorization"));
        final String requestTokenHeader= request.getHeader("Authorization");
        if(requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return ;
        }

        String token = requestTokenHeader.split("Bearer ")[1];
        Claims claims = authUtil.getAllClaims(token);
        String username = claims.getSubject();
        String role= claims.get("role" ,String.class );
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));
        System.out.println();

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            User user = userRepository.findByUsername(username).orElseThrow();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user , null , authorities  );
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        filterChain.doFilter(request , response);
    }
}
