package com.bsandhu.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/16/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RefDataService {

    public List<String> getAllBooks() {
        return Arrays.asList("Book1", "Book2", "Book3");
    }

}
