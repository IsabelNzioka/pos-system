package com.systechafrica.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseHandler {

    Connection connect(String connectionUrl, String user,  String password)   throws ClassNotFoundException, SQLException;
    
}
