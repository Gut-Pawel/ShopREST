package com.example.ShopREST.assortment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AssortimentController {

    @Autowired
    AssortimentRepository assortimentRepository;

    //Get ALL ASSORTIMENT



}
