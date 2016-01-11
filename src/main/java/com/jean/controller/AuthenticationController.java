package com.jean.controller;


import com.jean.model.UserDto;
import com.jean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/security")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public Object authentication(HttpServletResponse response, @RequestBody UserDto userDto) throws Exception {
        if (userService.authenticate(userDto.getEmail(), userDto.getPassword())){
            response.setHeader("fish-authenticate-id", userService.generateToken());

        }

        return "Hello AuthenticationController in header now you have token";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Object logout(HttpSession session) {
        session.invalidate();
        return "Session invalidate";
    }

}
