package com.laptop.LaptopStore.controller;

import com.laptop.LaptopStore.dto.LaptopDTO;
import com.laptop.LaptopStore.entity.Laptop;
import com.laptop.LaptopStore.mapper.LaptopMapper;
import com.laptop.LaptopStore.service.LaptopService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/store")
public class LaptopController {

    private final LaptopService laptopService;
    private final LaptopMapper laptopMapper;

    @PostMapping("/laptops")
    public ResponseEntity<Void> createLaptop(@Valid @RequestBody LaptopDTO laptopDTO) {
        var laptop = laptopMapper.mapToEntity(laptopDTO);
        laptopService.createLaptop(laptop);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/laptops/{id}")
    public ResponseEntity<LaptopDTO> getLaptopById(@PathVariable Integer id) {
        var laptop = laptopService.findLaptopById(id);
        var laptopDTO = laptopMapper.mapToDTO(laptop);
        return ResponseEntity.ok(laptopDTO);
    }

    @GetMapping("/laptops")
    public ResponseEntity<List<LaptopDTO>> getAllLaptops() {
        var laptops = laptopService.findAllLaptops();
        var laptopsDTO = laptopMapper.mapToDTO(laptops);
        return ResponseEntity.ok(laptopsDTO);

    }

    @DeleteMapping("/laptops/{id}")
    public ResponseEntity<Void> deleteLaptopById(@PathVariable Integer id) {
        laptopService.deleteLaptopById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/laptops/{id}")
    public ResponseEntity<Void> updateLaptopById(@Valid @RequestBody LaptopDTO laptopDTO, @PathVariable Integer id) {
        var laptop = laptopMapper.mapToEntity(laptopDTO);
        laptopService.updateLaptopById(laptop, id);
        return ResponseEntity.ok().build();
    }

}
