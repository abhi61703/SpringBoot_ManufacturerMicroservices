package com.ust.UserService.Service;

import com.ust.UserService.Entity.User;
import com.ust.UserService.Feign.ProductFeignClient;
import com.ust.UserService.Repository.UserRepository;
import com.ust.UserService.Response.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductFeignClient productFeignClient;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUname(user.getUname());
            existingUser.setUmailid(user.getUmailid());
            existingUser.setUnumber(user.getUnumber());
            existingUser.setPid(user.getPid());
            userRepository.save(existingUser);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Product getProductById(Long pid) {
        return productFeignClient.getProductById(pid);
    }

    public List<User> getUsersByProductId(Long pid) {
        return userRepository.findByPid(pid);
    }
}
