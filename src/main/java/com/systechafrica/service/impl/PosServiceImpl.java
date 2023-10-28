package com.systechafrica.service.impl;



import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.systechafrica.service.AuthenticationService;
import com.systechafrica.service.PosService;
import com.systechafrica.util.Config;

public class PosServiceImpl implements PosService {
    private Logger logger;
    Scanner scanner;
    private AuthenticationService authenticationService;

    public PosServiceImpl(Logger logger) {
        scanner = new Scanner(System.in);
        this.logger = logger;

        authenticationService = new AuthenticateServiceImpl();
    }


    @Override
    public void startApplication() {
      logger.info("IN the posServiceImpl");

    
      try {
         boolean isLoggedIn = authenticateUser();
        logger.info("User authenticated: " + isLoggedIn);
      } catch ( SQLException e) {
        logger.severe(e.getMessage());
      }catch (ClassNotFoundException e) {
        logger.severe(e.getMessage());
      }
      
    }

    private boolean authenticateUser()  throws SQLException, ClassNotFoundException{
        logger.info("Authenticating the user");

        int loginEntries = 1;
        while(loginEntries <= Config.LOGIN_RETRIES_LIMIT) {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        if(authenticationService.authenticate(username, password)){
        return true;
        }
      loginEntries++;
      System.out.println();
      logger.info("user entered wrong creadentials!!!!!!!");
}
     return false;

    }
    
}
