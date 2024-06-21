package com.nwp.pmf.dto;

import com.nwp.pmf.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String name;
    private String email;
    private UserRole userRole;
}
