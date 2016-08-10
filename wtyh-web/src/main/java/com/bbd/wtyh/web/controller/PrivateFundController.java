package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.PrivateFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marco on 2016/8/10.
 */
@RestController
public class PrivateFundController {

    @Autowired
    private PrivateFundService privateFundService;



}
