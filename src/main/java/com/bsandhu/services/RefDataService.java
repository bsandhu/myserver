package com.bsandhu.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RefDataService {

    public List<String> getAllBooks() {
        return Arrays.asList("Book1", "Book2", "Book3");
    }

}
