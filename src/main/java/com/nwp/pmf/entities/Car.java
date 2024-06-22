package com.nwp.pmf.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nwp.pmf.dto.CarDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String type;
    private String transmission;
    private String color;
    private Integer year;
    private Boolean sold;
    @Lob
    private String description;
    private Long price;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public CarDTO getCardDTO() {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(id);
        carDTO.setName(name);
        carDTO.setBrand(brand);
        carDTO.setType(type);
        carDTO.setTransmission(transmission);
        carDTO.setColor(color);
        carDTO.setYear(year);
        carDTO.setSold(sold);
        carDTO.setDescription(description);
        carDTO.setPrice(price);
        carDTO.setReturnedImage(image);

        return carDTO;
    }
}
