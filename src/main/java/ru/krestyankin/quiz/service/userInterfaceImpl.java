package ru.krestyankin.quiz.service;

import java.util.Scanner;

public class userInterfaceImpl implements userInterfaceService {
    private final Scanner in;

    public userInterfaceImpl() {
        in = new Scanner(System.in);
    }

    public String getString() {
        String input="";
        while (input.length()==0)
          input=in.nextLine();
        return input;
    }

    public void writeString(String msg) {
        System.out.println(msg);
    }
}
