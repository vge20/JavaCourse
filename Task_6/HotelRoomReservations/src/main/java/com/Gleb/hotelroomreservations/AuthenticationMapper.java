package com.Gleb.hotelroomreservations;

import com.Gleb.hotelroomreservations.exceptions.MappingException;
import com.Gleb.hotelroomreservations.models.AuthenticateParameters;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMapper {

    public AuthenticateParameters mapAuthenticationParameters(String parameters) throws MappingException {
        if (parameters.indexOf(':') == -1) throw new MappingException();

        AuthenticateParameters authenticateParameters = new AuthenticateParameters(
                parameters.substring(0, parameters.indexOf(':')),
                parameters.substring(parameters.indexOf(':'), parameters.length()));

        return authenticateParameters;
    }
}
