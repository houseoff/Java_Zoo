package ru.gb.zoo.view.ui;

import java.util.Scanner;

public class Input {
    private final Scanner sc;

    public Input() {
        sc = new Scanner(System.in);
    }

    private String getInput(String startMsg, String regex, String mismatchMsg) {
        if (!startMsg.isEmpty())
            System.out.print(startMsg + ": ");
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.print("Ввод не должен быть пустым. Пожалуйста, повторите ввод: ");
            } else if (!input.matches(regex)) {
                System.out.println(mismatchMsg);
                System.out.print("Пожалуйста, повторите ввод: ");
            } else {
                return input;
            }
        }
    }

    public Integer getInt(String startMsg, String regex, String mismatchMsg) {
        return Integer.parseInt(getInput(startMsg, regex, mismatchMsg));
    }

    public Integer getInt(String startMsg, String regex, int min, int max, String mismatchMsg) {
        int result;
        if (!startMsg.isEmpty())
            System.out.print(startMsg + ": ");
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.print("Ввод не должен быть пустым. Пожалуйста, повторите ввод: ");
            } else if (!input.matches(regex)) {
                System.out.println(mismatchMsg);
                System.out.print("Пожалуйста, повторите ввод: ");
            } else {
                result = Integer.parseInt(input);
                if (result >= min && result <= max) return result;
                System.out.println(mismatchMsg);
                System.out.print("Пожалуйста, повторите ввод: ");
            }
        }
    }

    public String getString(String startMsg) {
        return getInput(startMsg, ".*", "Ошибка ввода");
    }

    public String getString(String startMsg, String regex, String mismatchMsg) {
        return getInput(startMsg, regex, mismatchMsg);
    }
}

