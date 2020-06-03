package com.example.demo.application.services;

import com.example.demo.application.entities.Charity;
import java.util.List;

public interface ICharityService {

    public void save(Charity charity);
    public List<Charity> getCharities();
    public List<Charity> getCharityByName(String name);
    public void deleteCharity(Charity charity);
    public void editCharity(Charity charity);
}