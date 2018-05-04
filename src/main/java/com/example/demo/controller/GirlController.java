package com.example.demo.controller;

import com.example.demo.domain.Girlaaa;
import com.example.demo.domain.Result;
import com.example.demo.repository.GirlRepository;
import com.example.demo.service.GirlService;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有数据列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girlaaa> girlList() {
        logger.info("处理请求");
        return girlRepository.findAll();
    }

    /**
     * 插入一个数据
     *
     * @return
     */
    @PostMapping(value = "/girlsadd")
    public Result<Girlaaa> addGirl(@Valid Girlaaa girl, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girls/{id}")
    public Girlaaa getGirlById(@PathVariable("id") Integer id) {
        Girlaaa girl = new Girlaaa();
        girl.setId(id);
        Optional<Girlaaa> byId = girlRepository.findById(id);
        return byId.get();
    }

    @PostMapping(value = "/girls/{id}")
    public Girlaaa girlUpdate(@PathVariable("id") Integer id,
                              @RequestParam("cupSize") String cupSize,
                              @RequestParam("name") String name,
                              @RequestParam("age") Integer age) {
        Girlaaa girl = new Girlaaa();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setName(name);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    @GetMapping(value = "/girlsdel/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "/girls/age")
    public List<Girlaaa> getGirls(@RequestParam("age") Integer age) {
        return girlRepository.findByAge(age);
    }


    @GetMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }
}
