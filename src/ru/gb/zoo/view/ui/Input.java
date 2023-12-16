package ru.gb.zoo.view.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private final Scanner sc;

    public Input() {
        sc = new Scanner(System.in);
    }

    private String getInput(String startMsg,
                            String regex,
                            String mismatchMsg,
                            boolean reverse,
                            boolean convertRegexToList) {
        boolean flag;
        if (!startMsg.isEmpty())
            System.out.print(startMsg + ": ");
        while (true) {
            String input = sc.nextLine().trim();

            if (reverse) flag = regex.matches(input);
            else flag = input.matches(regex);

            if (convertRegexToList) {
                List<String> regexList = new ArrayList<>();
                for (String line : regex.split(",")) {
                    regexList.add(line.trim());
                }
                flag = regexList.contains(input);
            }

            if (input.isEmpty()) {
                System.out.print("Ввод не должен быть пустым. Пожалуйста, повторите ввод: ");
            } else if (!flag) {
                System.out.println(mismatchMsg);
                System.out.print("Пожалуйста, повторите ввод: ");
            } else {
                return input;
            }
        }
    }

    public Integer getInt(String startMsg, String regex, String mismatchMsg) {
        return Integer.parseInt(getInput(startMsg, regex, mismatchMsg, false, false));
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
        return getInput(
                startMsg,
                ".*",
                "Ошибка ввода",
                false,
                false);
    }

    public String getString(String startMsg, String regex, String mismatchMsg) {
        return getInput(startMsg, regex, mismatchMsg, false, false);
    }

    public String getString(String startMsg, String regex, String mismatchMsg, boolean reverse) {
        return getInput(startMsg, regex, mismatchMsg, reverse, false);
    }

    public String getString(String startMsg,
                            String regex,
                            String mismatchMsg,
                            boolean reverse,
                            boolean convertRegexToList) {
        return getInput(startMsg, regex, mismatchMsg, reverse, convertRegexToList);
    }
}

