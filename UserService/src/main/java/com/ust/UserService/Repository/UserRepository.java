package com.ust.UserService.Repository;

import com.ust.UserService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByPid(Long pid);
}
