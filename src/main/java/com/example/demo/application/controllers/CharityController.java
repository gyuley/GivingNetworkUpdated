package com.example.demo.application.controllers;

import java.util.List;

import com.example.demo.application.entities.Charity;
import com.example.demo.application.entities.User;
import com.example.demo.application.repositories.Users;
import com.example.demo.application.services.ICharityService;
import com.example.demo.application.services.IUserService;
import com.example.demo.application.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class CharityController {

    @Autowired
    private ICharityService charityService;

    @GetMapping("/charities")
    public List<Charity> getCharities() { return (List<Charity>) charityService.getCharities();}

    @GetMapping("/charity/{charity_name}")
    public List<Charity> getCharityByName(@PathVariable("charity_name") String charity_name) { return (List<Charity>) charityService.getCharityByName(charity_name);}

    @PostMapping("/charities")
    void addCharity(@RequestBody Charity charity) {
        charityService.save(charity);
    }

    @DeleteMapping("/delete-charity/{charity_id}")
    public void deleteCharity(@PathVariable("charity_id") int charity_id, Charity charity) {charityService.deleteCharity(charity);}

    @PostMapping("/edit-charity/{charity_id}")
    public void editCharity (@RequestBody Charity charity,@PathVariable("charity_id") int charity_id) {charityService.editCharity(charity);}
}
