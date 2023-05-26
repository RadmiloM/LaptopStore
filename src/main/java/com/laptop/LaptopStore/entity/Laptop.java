package com.laptop.LaptopStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String processor;
    private String screen;
    private String graphicCard;
    private String memory;
    private String image;
    private LocalDateTime createdAt;
    private String color;
    private String keyboard;
    private boolean camera;
    private String battery;
}
