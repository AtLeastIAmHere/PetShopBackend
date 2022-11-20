package com.itaem.crazy.petshopdemo.modules.petshop.config;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogManager {
    public Logger logger;
    private static LogManager instance = null;
    public static LogManager GetInstance(){
        if(instance ==null)
            instance = new LogManager();
        return instance;
    }
    public LogManager(){
        logger = LoggerFactory.getLogger(getClass());
    }
}
