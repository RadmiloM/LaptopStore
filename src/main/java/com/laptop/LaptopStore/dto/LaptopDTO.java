package com.laptop.LaptopStore.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LaptopDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String processor;
    @NotEmpty
    private String screen;
    @NotEmpty
    private String graphicCard;
    @NotEmpty
    private String memory;
    @NotEmpty
    private String image;
    @NotEmpty
    private String color;
    @NotEmpty
    private String keyboard;
    @NotNull
    private boolean camera;
    private String battery;

}
