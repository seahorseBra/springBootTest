package com.example.demo.service;

import com.example.demo.domain.Girlaaa;
import com.example.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {
    @Autowired
    GirlRepository girlRepository;

    public void insertTwo() {
        Girlaaa girl1 = new Girlaaa();
        girl1.setName("bbbbbbb");
        girl1.setAge(999);
        girl1.setCupSize("NNN");
        girlRepository.save(girl1);

        Girlaaa girl2 = new Girlaaa();
        girl2.setName("vvvvv");
        girl2.setAge(888);
        girl2.setCupSize("MMM");
        girlRepository.save(girl2);
    }
}
