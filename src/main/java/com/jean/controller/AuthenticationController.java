package com.jean.controller;


import com.jean.model.UserDto;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController("/security")
public class AuthenticationController {

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public Object authentication(HttpServletRequest request, HttpServletResponse response, @RequestBody UserDto userDto) {
        if (checkPermission(userDto))
            response.setHeader("fish-authenticate-id", "123455657678798");

        return "Hello AuthenticationController";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Object logout(HttpSession session) {
        session.invalidate();
        return "Session invalidate";
    }


    private boolean checkPermission(UserDto userDto) {
        return userDto.getUserName().equals("user") && userDto.getPassword().equals("password");
    }


}
