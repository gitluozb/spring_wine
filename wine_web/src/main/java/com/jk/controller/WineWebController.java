package com.jk.controller;

import com.jk.service.WineWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WineWebController {

    @Autowired
    private WineWebService wineWebService;




}
