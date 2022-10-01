package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface MainRepository extends JpaRepository <User,Long> {

    Boolean existsByUsername(String username);
    Boolean existsByPassword(String password);
}
