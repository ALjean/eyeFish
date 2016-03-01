package com.jean.servlet.controller;


import com.jean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class AuthenticationController {

    @Autowired
    private UserService userService;


}
