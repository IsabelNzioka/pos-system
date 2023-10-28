package com.systechafrica.util;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
     public static Dotenv dotenv = Dotenv.configure().load();


    public static final String USER_DEFAULT_PASSWORD = "Admin123";
    public static final String USER_DEFAULT_USERNAME = "Admin";


    public static final int LOGIN_RETRIES_LIMIT = 3;


    public static final String CONNECTION_URL = dotenv.get("DB_URL");
    public static final String DB_USER = dotenv.get("DB_USER");
    public static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");
    
}
