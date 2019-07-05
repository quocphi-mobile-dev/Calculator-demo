package com.example.calcualator_demo.utils;

import com.example.calcualator_demo.constant.Constant;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static ArrayList<String> arrOperation;
    private static ArrayList<Float> arrNumber;

    public static boolean checkSyntax(String expression) {
        if (expression.length() == 0) return false;
        for (char startCharError : Constant.START_CHAR_ERROR) {
            if (expression.charAt(0) == startCharError) return false;
        }
        for (String syntaxError : Constant.SYNTAX_ERROR) {
            if (expression.contains(syntaxError)) return false;
        }
        for (char endCharError : Constant.END_CHAR_ERROR) {
            if (expression.charAt(expression.length() - 1) == endCharError) return false;
        }
        return true;
    }

    public static float result(String expression) {
        float result = 0;
        addOperation(expression);
        addNumber(expression);
        for (int i = 0; i < (arrNumber.size() - 1); i++) {

            switch (arrOperation.get(i)) {
                case "+":
                    if (i == 0) {
                        result = arrNumber.get(i) + arrNumber.get(i + 1);
                    } else {
                        result = result + arrNumber.get(i + 1);
                    }
                    break;
                case "-":
                    if (i == 0) {
                        result = arrNumber.get(i) - arrNumber.get(i + 1);
                    } else {
                        result = result - arrNumber.get(i + 1);
                    }
                    break;
                case "*":
                    if (i == 0) {
                        result = arrNumber.get(i) * arrNumber.get(i + 1);
                    } else {
                        result = result * arrNumber.get(i + 1);
                    }
                    break;
                case "/":
                    if (i == 0) {
                        result = arrNumber.get(i) / arrNumber.get(i + 1);
                    } else {
                        result = result / arrNumber.get(i + 1);
                    }
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    private static void addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (char c : cArray) {
            switch (c) {
                case Constant.ADD:
                    arrOperation.add(c + "");
                    break;
                case Constant.SUB:
                    arrOperation.add(c + "");
                    break;
                case Constant.MUL:
                    arrOperation.add(c + "");
                    break;
                case Constant.DIV:
                    arrOperation.add(c + "");
                    break;
                default:
                    break;
            }
        }
    }

    private static void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()) {
            arrNumber.add(Float.valueOf(matcher.group(1)));
        }
    }

}
