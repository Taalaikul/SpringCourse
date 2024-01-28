package com.luvspring.myapp.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim a 1000m as a warmup";
    }
}
