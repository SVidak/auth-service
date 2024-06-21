package com.nwp.pmf.services.auth;

import com.nwp.pmf.dto.SignupRequest;
import com.nwp.pmf.dto.UserDTO;

public interface AuthService {

    UserDTO signup(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);
}
