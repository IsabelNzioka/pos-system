package com.systechafrica;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.systechafrica.service.PosService;
import com.systechafrica.service.impl.PosServiceImpl;
import com.systechafrica.util.CustomFormatter;

/**
 * Hello world!
 */
public class PointOfSaleApplication {

    private static final Logger LOGGER = Logger.getLogger(PointOfSaleApplication.class.getName());

      public static void initializeLogger(){
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("log.txt");
            CustomFormatter formatter = new CustomFormatter();
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);
            LOGGER.info("Initialized application");
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }

    }


    public static void main(String[] args) {
        initializeLogger();
        
        PosService posService = new PosServiceImpl();
        posService.startApplication(LOGGER);
    }
}
