package com.luv2code.aop.demo.service;

import org.springframework.stereotype.Service;


@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{

    @Override
    public String getFortune() {

        //simulate a delay

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //return a fortune
        return "Expect heavy traffic this morning!";
    }
}
