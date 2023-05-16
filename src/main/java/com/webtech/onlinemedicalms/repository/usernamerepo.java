package com.webtech.onlinemedicalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webtech.onlinemedicalms.model.SignupData;

@Repository
public interface  usernamerepo extends JpaRepository<SignupData, Long> {
    SignupData findByName(String  name);
    
}
