package com.bsandhu.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ClientController {

    static Logger logger = Logger.getLogger(ClientController.class);

    @RequestMapping("/client")
    public String simple() {
        logger.info("serving client");
        return "client";
    }

}