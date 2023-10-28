package com.systechafrica.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.systechafrica.db.DatabaseHandler;
import com.systechafrica.db.impl.DatabaseHandlerMySqlImpl;
import com.systechafrica.service.AuthenticationService;
import com.systechafrica.util.Config;



public class AuthenticateServiceImpl  implements AuthenticationService{
   

    DatabaseHandler databaseHandler;
    public AuthenticateServiceImpl() {
        databaseHandler = new DatabaseHandlerMySqlImpl();  
    }

    @Override
    public boolean authenticate(String username, String password) throws  SQLException, ClassNotFoundException {
      Connection connection =   databaseHandler.connect(Config.CONNECTION_URL, Config.DB_USER, Config.DB_PASSWORD);
      PreparedStatement preparedStatement = connection.prepareStatement("select * from users where name=? and password=?" );

      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);

      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()) {
        return true;
      }
        return false;
    }
    
}
