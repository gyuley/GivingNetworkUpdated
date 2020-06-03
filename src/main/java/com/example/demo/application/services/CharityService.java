package com.example.demo.application.services;

import java.util.List;

import com.example.demo.application.entities.Charity;
import com.example.demo.application.entities.User;
import com.example.demo.application.repositories.CharityRepository;
import com.example.demo.application.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CharityService implements ICharityService {

    @Autowired
    private CharityRepository charities;

    @Override
    public void save(Charity charity) {
        charities.save(charity);
    }

    @Override
    public List<Charity> getCharities() {
        return charities.getCharities();
    }

    @Override
    public List<Charity> getCharityByName(String name) {
        return charities.getCharityByName(name);
    }

    @Override
    public void deleteCharity(Charity charity) {
        charities.deleteCharity(charity);
    }

    @Override
    public void editCharity(Charity charity) {
        charities.editCharity(charity);
    }

}
