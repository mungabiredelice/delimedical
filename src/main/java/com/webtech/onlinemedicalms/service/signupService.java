package com.webtech.onlinemedicalms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtech.onlinemedicalms.model.Medecine;
import com.webtech.onlinemedicalms.model.SignupData;
import com.webtech.onlinemedicalms.repository.medecineRepo;

import com.webtech.onlinemedicalms.repository.usersRepository;

@Service
public class signupService {
    
    @Autowired
    private usersRepository uRepo;
    
    @Autowired
    private medecineRepo medeRepo;



    

    public void signupSave(SignupData signup){
        uRepo.save(signup);

    }

    public List<SignupData> getAllUsers(){
        return uRepo.findAll();
    } 

  

    public void saveMedecine(Medecine mede){
       medeRepo.save(mede);
    }

    public List<Medecine> Allmede(){
        return medeRepo.findAll();
    }

    public void deleteUserById(Long id){

        uRepo.deleteById(id);

    }
    public void deleteMedeById(Long id){
        medeRepo.deleteById(id);
    }
   
    public SignupData getUserById(Long id){
   
        return uRepo.findById(id).get();
    }

    public Medecine getMedecineById(Long id){
   
        return medeRepo.findById(id).get();
    }

  

 

    
}
