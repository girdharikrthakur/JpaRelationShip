package com.girdhari.association.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girdhari.association.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
