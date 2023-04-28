package org.example.View;

import org.example.Model.Interfaces.Calculable;
import org.example.Model.Interfaces.Parsable;
import org.example.Service.ICalculableFactory;

import java.util.List;

public class UserInOutOperations {
    static ICalculableFactory calcFactory;
    static Calculable calc;
    static StringBuilder sb;
    static UIinteractable ui;
    String session;

    final String errorInputOperationMessage = "Incorrect input data: ";
    final String inputOperationMessage =
            "Use signs:  +  -  *  /  +/-  1/x  ^2  C  Q -Quit";
    String inputOperandMessage ="Use numbers: 0  1  2  3  4  5  6  7  8  9";

    public UserInOutOperations
            ( ICalculableFactory calculator
            , Calculable resultCalc
            , UIinteractable uii,
              String sessionCalc
            )

    {
        calcFactory = calculator;
        calc = resultCalc;
        ui = uii;
        session = sessionCalc;
        sb = new StringBuilder();
        inputOperandMessage += (session.equals("Complex")
                ? "  i  for example: 8 - 4i ; -i +0.2"
                : "");
    }

    public String inputOperation(List<String> allOperations) {
        String op;
        while (true){
            ui.output("\nEnter operation: ");
            op = ui.input();
            if (allOperations.contains(op)) {
                storeOperand(op);
                return op;
            } else {
                exceptionOperation(errorInputOperationMessage
                        + op, inputOperationMessage, sb.toString());
            }
        }
    }

    public Parsable inputOperand() {
        while (true){
            ui.output("\nEnter operand: ");
            try{
                var cl = calcFactory.createNumber(ui.input());
                storeOperand(cl.toString());
                return cl;
            } catch (Exception e) {
                exceptionOperation(e.getMessage(), inputOperandMessage, sb.toString());
            }
        }
    }

    public void storeOperand(String cl){
        sb.append(cl).append(" ");
        showResult();
    }

    public void storeResult(String cl, String str){
        sb.append(str).append(cl).append(" ");
        showResult();
    }

    public void clearResult(String str) {
        sb.setLength(0);
        sb.append(str);
    }

    public void showResult(){
        ui.output(sb.toString());
    }

    public void showTitle() {
        String msg = "\n" + session + " numbers calculator\n";
        ui.output(msg);
        showMessage(inputOperationMessage + "\n" + inputOperandMessage + "\n");
    }

    public void showOperationMessage(String string) {
        ui.output(string);
    }

    public void exceptionOperation(String errorMsg,String message, String cl) {
        showMessage(errorMsg + "\n" + message +"\n" +cl);
    }

    public void showMessage(String message){
        ui.output(message);
    }
}
