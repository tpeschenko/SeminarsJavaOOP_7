package org.example.View;

import java.util.Scanner;

public class UIConsole implements UIinteractable{
    public static final Scanner scanner = new Scanner(System.in);


    @Override
    public void output(String string) {
        System.out.print(string);
    }

    @Override
    public String input() {
        return scanner.nextLine();
    }
}
