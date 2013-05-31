package com.bsandhu.transport;

import com.bsandhu.services.RefDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/refdata")
public class RefDataTransport {

    private static Logger logger = LoggerFactory.getLogger(RefDataTransport.class);
    private RefDataService service;

    @Autowired
    public RefDataTransport(RefDataService service) {
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
