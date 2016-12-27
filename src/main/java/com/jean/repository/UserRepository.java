package com.jean.repository;

import com.jean.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Integer> {
}
