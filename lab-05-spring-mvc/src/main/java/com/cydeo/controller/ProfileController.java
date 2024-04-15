package com.cydeo.controller;

import com.cydeo.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String getProfilePage(Model model){
       Profile profile1 = new Profile();
        profile1.setName("John");
        profile1.setSurname("Doe");
        profile1.setUserName("johndoe");
        profile1.setPhoneNumber("0123456789");
        profile1.setEmail("johndoe@cydeo.com");
        profile1.setCreatedDate(LocalDateTime.now());

        model.addAttribute("profile", profile1);
        return  "profile/profile-info";
    }


}
