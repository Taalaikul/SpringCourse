package com.luvspring.myapp.rest;


import com.luvspring.myapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach){
        System.out.println("In constructor: " +getClass().getSimpleName());
        myCoach = theCoach;

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


  /*
   Constructor injection

   @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

   Setter injection

    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }




    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach){
        myCoach = theCoach;
    }

    */


}
