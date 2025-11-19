package com.example.roomieFinder.Services;

import com.example.roomieFinder.dto.LoginRequestDto;
import com.example.roomieFinder.dto.LoginResponseDto;
import com.example.roomieFinder.dto.SignupRequestDto;
import com.example.roomieFinder.dto.SignupResponseDto;
import com.example.roomieFinder.Entities.User;
import com.example.roomieFinder.Repository.UserRepository;
import com.example.roomieFinder.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername() , loginRequestDto.getPassword())
        );

        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + authentication.getName()));

        String token= authUtil.generateAccessToken(user);
        System.out.println(" role:"+user.getRole());
        return new LoginResponseDto(token , user.getId() );
    }

    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        Optional<User> existingUserOpt = userRepository.findByUsername(signupRequestDto.getUsername());

        if (existingUserOpt.isPresent()) {
            throw new IllegalArgumentException("User with this username already exists");
        }
        User user = userRepository.save(User.builder()
                .username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .firstName(signupRequestDto.getFirstName())
                .role("user")
                .build()
        );
        return new SignupResponseDto(user.getId() , user.getUsername() );

    }
}
