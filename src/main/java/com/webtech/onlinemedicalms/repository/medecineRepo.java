package com.webtech.onlinemedicalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webtech.onlinemedicalms.model.Medecine;

@Repository
public interface medecineRepo extends JpaRepository<Medecine, Long>   {
    
}
