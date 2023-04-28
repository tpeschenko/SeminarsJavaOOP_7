package org.example.View;

public class LoggerUserMenu extends UserMenu {

    public LoggerUserMenu( UIinteractable uIinteractable) {
        super(uIinteractable);
    }

    @Override
    public void startCalculation(String session) {
        this.session = session;
        calc = calcFactory.getCalculator();
        uo = new LoggerUserOperations(calcFactory, calc, ui, session);
        Calculation();
    }
}
