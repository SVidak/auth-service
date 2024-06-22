package com.nwp.pmf.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CarDTO {

    private Long id;
    private String name;
    private String brand;
    private String type;
    private String transmission;
    private String color;
    private Integer year;
    private Boolean sold;
    private String description;
    private Long price;
    private MultipartFile image;
    private Long userId;
    private byte[] returnedImage;
}
