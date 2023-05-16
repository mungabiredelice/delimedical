package com.webtech.onlinemedicalms.controller;






import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webtech.onlinemedicalms.model.Medecine;
import com.webtech.onlinemedicalms.model.SignupData;
import com.webtech.onlinemedicalms.repository.medeStatusRepo;
import com.webtech.onlinemedicalms.repository.usernamerepo;
import com.webtech.onlinemedicalms.service.signupService;


import jakarta.servlet.http.HttpSession;





@Controller
public class InventoryController {
  
    @Autowired
    private usernamerepo namerepo;
    @Autowired
    private signupService service;

    @Autowired
    private medeStatusRepo medecineStat;
    
    @GetMapping("/")
    public String landingForm(){

        return "landing_page";
    }

        @GetMapping("/dashboard")
        public ModelAndView dashForm(){
            List<Medecine> medecine = service.Allmede();
             return new ModelAndView("dashboard", "Medecine", medecine);
        }

        @GetMapping("/registerMedecine")
        public String regMedecien(){

            return"registerMedecine";
        }

        @PostMapping("/saveMedecine")
        public String savemedecine(@ModelAttribute Medecine data){
        String status = "available";
        String approve="no aproval";
        data.setStatus(status);
        data.setApproval(approve);

            service.saveMedecine(data);
            return "redirect:/dashboard";
        }

        public ModelAndView getAllMedecine(){
            List<Medecine> list = service.Allmede();
            

            return new ModelAndView("dashboard","Medecine",list);
        }


  @PostMapping("/saveUser")
        public String saveUser(@ModelAttribute SignupData data){
        
            service.signupSave(data);
            return "userPage";
        }
        
    

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session ){
        String admin ="admin";
        SignupData data = namerepo.findByName(name);
        if(data!=null && data.getName().equals(admin) && data.getPassword().equals(password)){
            session.setAttribute("logedinUser", data);
            return "redirect:/dashboard";
        }else if(data!=null && data.getName().equals(name) && data.getPassword().equals(password)){
            return "redirect:/userPage";
        }
        return"";
    }

    @RequestMapping("/deleteMedecine/{id}")
    public String deleteCarId(@PathVariable("id") Long id){
        service.deleteMedeById(id);
        return"redirect:/dashboard";
    }

    @RequestMapping("/update/{id}")
    public String editCarById(@PathVariable("id") Long id, Model model){
        Medecine mededata = service.getMedecineById(id);
        model.addAttribute("mededata",mededata);
      
        return "editMedecine";
    }
    
    @GetMapping("/userPage")
    public String normapage(Model model){
        Medecine available = medecineStat.findBystatus("available");
        model.addAttribute("available",available);
        return"userPage";
    }

    
    @RequestMapping("/buy/{id}")
    public String buyById(@PathVariable("id") Long id){
        Medecine data = service.getMedecineById(id);
        String status ="not available";
        data.setStatus(status);
        service.saveMedecine(data);
       

        return "redirect:/userPage";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    
    @GetMapping("/bought")
    public String  bought(Model model){
        // List<regCar> data = service.getCarList();
        Medecine notAvailable = medecineStat.findBystatus("not available");
        model.addAttribute("bought", notAvailable);
        return "bought";
        
    }
    
    @GetMapping("/stock")
    public String mystock(Model model){
        Medecine available = medecineStat.findBystatus("available");
        model.addAttribute("stock",available);
        return"stock";
    }
    @GetMapping("/users")
    public ModelAndView getAllUsers(){
        List<SignupData> list = service.getAllUsers();
        

        return new ModelAndView("users","SignupData",list);
    }
 
    @RequestMapping("/approve/{id}")
    public String approve(@PathVariable("id") Long id){
        Medecine data = service.getMedecineById(id);
        String approve ="approved";
        data.setApproval(approve);
        service.saveMedecine(data);
       

        return "redirect:/dashboard";
    }

    @RequestMapping("/reject/{id}")
    public String reject(@PathVariable("id") Long id){
        Medecine data = service.getMedecineById(id);
        String reject ="available";
        data.setApproval("noapproval");
        data.setStatus(reject);
        service.saveMedecine(data);
       

        return "redirect:/dashboard";
    }

}
