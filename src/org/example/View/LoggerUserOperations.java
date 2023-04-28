package org.example.View;

import org.example.Model.Interfaces.Calculable;
import org.example.Model.Interfaces.Loggable;
import org.example.Service.ICalculableFactory;
import org.example.Model.Classes.LoggerCalc;

import java.util.logging.Logger;

public class LoggerUserOperations extends UserInOutOperations implements Loggable {
    private Logger logger;

    public LoggerUserOperations
            ( ICalculableFactory calculator
            , Calculable resultCalc
                    , UIinteractable uii
                    , String sessionCalc
            )
    {
        super(calculator, resultCalc, uii, sessionCalc);
        logger = new LoggerCalc(LoggerUserOperations.class.getName()).getLogger();
    }

    @Override
    public void showTitle() {
        super.showTitle();
        logger.info("Calculate started: " + session + " numbers calculator");
    }

    @Override
    public void storeOperand(String cl) {
        super.storeOperand(cl);
        logger.info("Entered: " + cl);
    }

    @Override
    public void storeResult(String cl, String str) {
        super.storeResult(cl, str);
        logger.info("Intermediate result: " + cl);
    }

    @Override
    public void exceptionOperation(String errorMsg, String message, String cl) {
        super.exceptionOperation(errorMsg, message, cl);
        logger.warning(errorMsg);
    }

    @Override
    public void loggingInfo(String msg) {
        logger.info(msg);
    }

    @Override
    public void loggingWarning(String msg) {
        logger.warning(msg);
    }
}
