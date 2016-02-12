package com.jean.servlet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by stas on 30.05.15.
 */
@RestController
@RequestMapping("/service")
public class MainController {

//    private static final Logger log = LogManager.getLogger(MainController.class); todo


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object testMethod(){

        return "Hello Controller";
    }
}

