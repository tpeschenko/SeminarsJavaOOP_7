package org.example.Model.Classes;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LoggerCalc {
    public Logger logger;

    public LoggerCalc(String name) {
        logger = Logger.getLogger(name);
        logger.setUseParentHandlers(false);

        try {
            FileHandler fh = new FileHandler("logcalc.txt");
            fh.setFormatter(new TXTSimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Logger getLogger(){
        return this.logger;
    }
}
