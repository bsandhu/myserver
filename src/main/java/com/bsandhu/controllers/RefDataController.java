package com.bsandhu.controllers;

import com.bsandhu.services.RefDataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/16/13
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/refdata")
public class RefDataController {

    private static Logger logger = Logger.getLogger(RefDataController.class);
    private RefDataService service;

    @Autowired
    public RefDataController(RefDataService service) {
        this.service = service;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> getAllBookNames() {
        logger.info("All books");
        return this.service.getAllBooks();
    }
}
