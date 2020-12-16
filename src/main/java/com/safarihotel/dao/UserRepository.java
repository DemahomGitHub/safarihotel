package com.safarihotel.dao;

import com.safarihotel.model.User;

public interface UserRepository {
    public User findByUsername(String username);
}
