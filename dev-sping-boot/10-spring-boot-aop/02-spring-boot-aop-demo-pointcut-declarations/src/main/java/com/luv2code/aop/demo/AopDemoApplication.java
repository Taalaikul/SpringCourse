package com.luv2code.aop.demo;

import com.luv2code.aop.demo.dao.AccountDAO;
import com.luv2code.aop.demo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){

		return runner -> {
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		//call the business method
		Account myAccount=new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		//call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}
