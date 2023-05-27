package com.laptop.LaptopStore.service;

import com.laptop.LaptopStore.entity.Laptop;
import com.laptop.LaptopStore.exception.LaptopNotFoundException;
import com.laptop.LaptopStore.repository.LaptopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LaptopService {

    private final LaptopRepository laptopRepository;

    public void createLaptop(Laptop laptop){
        laptopRepository.save(laptop);
    }

    public List<Laptop> findAllLaptops(){
        return laptopRepository.findAll();
    }

    public Laptop findLaptopById(Integer id){
        var laptop = laptopRepository.findById(id);
        if(laptop.isEmpty()){
            throw new LaptopNotFoundException("laptop with id " + id + " was not found in database");
        }
        return laptop.get();

    }

    public void deleteLaptopById(Integer id){
        var laptop = laptopRepository.findById(id);
        if(laptop.isEmpty()){
            throw new LaptopNotFoundException("laptop with id " + id + " was not found in database");
        }
        laptopRepository.deleteById(id);
    }

    public void updateLaptopById(Laptop laptopRequest, Integer id){
        var laptopDB = laptopRepository.findById(id);
        if(laptopDB.isEmpty()){
            throw new LaptopNotFoundException("laptop with id " + id + " was not found in database");
        }
        var laptop = laptopDB.get();
        if(null != laptopRequest.getBattery() && !"".equals(laptopRequest.getBattery())){
            laptop.setBattery(laptopRequest.getBattery());
        }
        if(null != laptopRequest.getName() && !"".equals(laptopRequest.getName())){
            laptop.setName(laptopRequest.getName());
        }
        if(null != laptopRequest.getScreen() && !"".equals(laptopRequest.getScreen())){
            laptop.setScreen(laptopRequest.getScreen());
        }
        if(null != laptopRequest.getColor() && !"".equals(laptopRequest.getColor())){
            laptop.setColor(laptopRequest.getColor());
        }
        if(null != laptopRequest.getGraphicCard() && !"".equals(laptopRequest.getGraphicCard())){
            laptop.setGraphicCard(laptopRequest.getGraphicCard());
        }
        if(null != laptopRequest.getKeyboard() && !"".equals(laptopRequest.getKeyboard())){
            laptop.setKeyboard(laptopRequest.getKeyboard());
        }
        if(null != laptopRequest.getProcessor() && !"".equals(laptopRequest.getProcessor())){
            laptop.setProcessor(laptopRequest.getProcessor());
        }
        if(null != laptopRequest.getImage() && !"".equals(laptopRequest.getImage())){
            laptop.setImage(laptopRequest.getImage());
        }
        laptopRepository.save(laptop);

    }

}
