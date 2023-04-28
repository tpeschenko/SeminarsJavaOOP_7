package org.example.Controller;

import org.example.Model.Exeptions.CalculateFormatException;
import org.example.Model.Exeptions.DivisionByZeroException;
import org.example.View.LoggerUserMenu;
import org.example.View.UIConsole;

public class Controller {
    public Controller() throws DivisionByZeroException, CalculateFormatException {
        new LoggerUserMenu( new UIConsole()).startMenu();
    }
}
