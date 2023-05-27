package com.laptop.LaptopStore.mapper;

import com.laptop.LaptopStore.dto.LaptopDTO;
import com.laptop.LaptopStore.entity.Laptop;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LaptopMapper {

    public LaptopDTO mapToDTO(Laptop laptop){
        LaptopDTO laptopDTO = new LaptopDTO();
        laptopDTO.setBattery(laptop.getBattery());
        laptopDTO.setScreen(laptop.getScreen());
        laptopDTO.setCamera(laptop.isCamera());
        laptopDTO.setMemory(laptop.getMemory());
        laptopDTO.setName(laptop.getName());
        laptopDTO.setGraphicCard(laptop.getGraphicCard());
        laptopDTO.setImage(laptop.getImage());
        laptopDTO.setColor(laptop.getColor());
        laptopDTO.setKeyboard(laptop.getKeyboard());
        laptopDTO.setProcessor(laptop.getProcessor());
        return laptopDTO;
    }

    public List<LaptopDTO> mapToDTO(List<Laptop> laptops){
        return laptops.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Laptop mapToEntity(LaptopDTO laptopDTO){
        var time = LocalDateTime.now();
        Laptop laptop = new Laptop();
        laptop.setScreen(laptopDTO.getScreen());
        laptop.setCamera(laptopDTO.isCamera());
        laptop.setImage(laptopDTO.getImage());
        laptop.setName(laptopDTO.getName());
        laptop.setBattery(laptopDTO.getBattery());
        laptop.setMemory(laptopDTO.getMemory());
        laptop.setKeyboard(laptopDTO.getKeyboard());
        laptop.setCreatedAt(time);
        laptop.setGraphicCard(laptopDTO.getGraphicCard());
        laptop.setColor(laptopDTO.getColor());
        laptop.setProcessor(laptopDTO.getProcessor());
        return laptop;
    }


}
