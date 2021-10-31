package com.ninos.apigatewaymicroservice3.service;

import com.ninos.apigatewaymicroservice3.model.User;

public interface AuthenticationService
{
    User signInAndReturnJWT(User signInRequest);
}
