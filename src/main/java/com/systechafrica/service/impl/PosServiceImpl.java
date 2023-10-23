package com.systechafrica.service.impl;



import java.util.logging.Logger;

import com.systechafrica.service.PosService;

public class PosServiceImpl implements PosService {


    @Override
    public void startApplication(Logger logger) {
      logger.info("IN the posServiceImpl");
    }
    
}
