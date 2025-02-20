package com.bimuan.freshpress.controller;


import com.bimuan.freshpress.model.User;
import com.bimuan.freshpress.repository.UserRepository;
import com.bimuan.freshpress.util.OtpUtil;
import com.bimuan.freshpress.util.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostMapping("/register")
//    public ResponseEntity<String> register(
//            @RequestParam String phoneNumber,
//            @RequestParam String email,
//            @RequestParam String fullName,
//            @RequestParam String password,
//            @RequestParam Set<String> roles) {
//
//        if (!PhoneNumberValidator.isValidPhoneNumber(phoneNumber, "US")) {
//            return ResponseEntity.badRequest().body("Invalid phone number");
//        }
//
//        if (userRepository.findByPhoneNumber(phoneNumber).isPresent()) {
//            return ResponseEntity.badRequest().body("Phone number already registered");
//        }
//
//        if (userRepository.findByEmail(email).isPresent()) {
//            return ResponseEntity.badRequest().body("Email already registered");
//        }
//
//        User user = new User();
//        user.setPhoneNumber(phoneNumber);
//        user.setEmail(email);
//        user.setFullName(fullName);
//        user.setPassword(passwordEncoder.encode(password));
//        user.setRoles(roles);
//        user.setEnabled(false); // User is not enabled until OTP is verified
//        userRepository.save(user);
//
//        String otp = OtpUtil.generateOtp();
//        // Send OTP to the user's phone number (e.g., via SMS)
//        // Save OTP in cache or database with an expiration time
//
//        return ResponseEntity.ok("OTP sent to " + phoneNumber);
//    }

//    @PostMapping("/validate-otp")
//    public ResponseEntity<String> validateOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
//        // Retrieve OTP from cache or database
//        String storedOtp = getOtpFromCache(phoneNumber);
//
//        if (storedOtp != null && storedOtp.equals(otp)) {
//            User user = userRepository.findByPhoneNumber(phoneNumber)
//                    .orElseThrow(() -> new RuntimeException("User not found"));
//            user.setEnabled(true);
//            userRepository.save(user);
//            return ResponseEntity.ok("OTP validated successfully");
//        } else {
//            return ResponseEntity.badRequest().body("Invalid OTP");
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
//        // Spring Security will handle authentication
//        return ResponseEntity.ok("Login successful");
//    }
}
