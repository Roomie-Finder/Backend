//package com.example.roomieFinder.Security;
//
//
//import com.example.roomieFinder.Entities.User;
//import com.example.roomieFinder.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private final UserRepository userRepository;
//    @Autowired
//    UserDetailsServiceImpl(UserRepository userRepository){
//        this.userRepository=userRepository;
//    }
//
//    @Override
//    public UserDetails  loadUserByUsername(String email )throws UsernameNotFoundException {
//        User user = userRepository.findUserByUserName(email);
//        if(user != null){
//            return org.springframework.security.core.userdetails.User.builder()
//                    .username(user.getEmail())
//                    .roles(user.getRole())
//                    .build();
//        }
//        else{
//            throw new UsernameNotFoundException("email not found" + email);
//        }
//    }
//}
