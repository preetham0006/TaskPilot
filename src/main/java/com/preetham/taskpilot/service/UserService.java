package com.preetham.taskpilot.service;

import org.springframework.stereotype.Service;
import com.preetham.taskpilot.repository.UserRepository;
import com.preetham.taskpilot.dto.auth.RegisterRequestDTO;
import com.preetham.taskpilot.entity.User;
import com.preetham.taskpilot.enums.Role;
import com.preetham.taskpilot.exception.EmailAlreadyExistsException;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
}
public void register(RegisterRequestDTO request) {
    if (userRepository.findByEmail(request.getEmail()).isPresent()) {
    throw new EmailAlreadyExistsException("Email already exists");
}
User user = new User();
user.setName(request.getName());
user.setEmail(request.getEmail());
user.setPassword(request.getPassword());
user.setRole(Role.USER);
userRepository.save(user);
}
}
