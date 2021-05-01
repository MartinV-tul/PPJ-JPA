package cz.tul.service;


import cz.tul.data.Town;
import cz.tul.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TownService {

    @Autowired
    private TownRepository townRepository;

    public List<Town> getTowns(){
        return StreamSupport.stream(townRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void create(Town town){
        townRepository.save(town);
    }

    public List<Town> getTownsByCountryName(String countryName){
        if(countryName == null)return null;

        List<Town> towns = townRepository.findByCountryName(countryName);

        if(towns.size() == 0) return null;

        return towns;
    }

    public void deleteTown(Town town){
        townRepository.delete(town);
    }

    public void deleteAllTowns(){
        townRepository.deleteAll();
    }
}
