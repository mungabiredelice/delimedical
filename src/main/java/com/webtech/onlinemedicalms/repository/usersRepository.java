package com.webtech.onlinemedicalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webtech.onlinemedicalms.model.SignupData;

@Repository
public interface usersRepository extends JpaRepository<SignupData, Long>{



}
