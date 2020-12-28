package ru.julia.taxi.taxi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class leetcode262_taxiController {
    @RequestMapping("/")
    public static String hello(){
        return "hello";
    }
}
