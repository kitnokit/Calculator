package main;
import java.util.Scanner;
public class calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        try {
            System.out.println("Напишите своё выражение (например, 1 + 10 или I + X): ");
            input = scanner.nextLine();
            boolean Arab = input.matches("[0-9 ]+");
            boolean Rom = input.matches("[IVXLCDM ]+");
            if (!Rom && !Arab) {
            throw new Exception("throws Exception");
                }
            } catch (Exception e) {
        }
        try {
            calc(input);
            String result = calc(input);
            if (result == null) {
                throw new Exception();
            } else System.out.println(result);
        } catch (Exception e) {
            throw new Exception("throws Exception");
        }
    }
    static String calc(String input) throws Exception {
        String result = null;
        String[] romArray = {"I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX", "X"};
        String[] romArrayOut = {"I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII",
                "XIX", "XX"};
        int x;
        int y;
        int Index = 0;
        try {
            Index = findIndex(input);
        } catch (Exception e) {
                System.out.println("throws Exception");
            }
        String leftOperand = input.substring(0, Index).trim();
        String operator = input.substring(Index, Index + 1).trim();
        String rightOperand = input.substring(Index + 1).trim();

        boolean romX = false;
        boolean romY = false;
        for (String rom : romArray) {
            if (leftOperand.equals(rom)) {
                romX = true;
            }
            if (rightOperand.equals(rom)) {
                romY = true;
            }
        }
        if (romX || romY) {
            switch (leftOperand) {
                case "I" -> x = 1;
                case "II" -> x = 2;
                case "III" -> x = 3;
                case "IV" -> x = 4;
                case "V" -> x = 5;
                case "VI" -> x = 6;
                case "VII" -> x = 7;
                case "VIII" -> x = 8;
                case "IX" -> x = 9;
                case "X" -> x = 10;
                default -> throw new Exception("throws Exception");
            }
            switch (rightOperand) {
                case "I" -> y = 1;
                case "II" -> y = 2;
                case "III" -> y = 3;
                case "IV" -> y = 4;
                case "V" -> y = 5;
                case "VI" -> y = 6;
                case "VII" -> y = 7;
                case "VIII" -> y = 8;
                case "IX" -> y = 9;
                case "X" -> y = 10;
                default -> throw new Exception("throws Exception");
            }
            int b = 0;
            switch (operator) {
                case "+" -> b = x + y;
                case "-" -> b = x - y;
                case "/" -> b = x / y;
                case "*" -> b = x * y;
            }
            switch (b) { // возможно также реализовать циклом (наверное), но я решил пойти сложным путём (- 15 строчек
                case 1 -> result = romArrayOut[0];
                case 2 -> result = romArrayOut[1];
                case 3 -> result = romArrayOut[2];
                case 4 -> result = romArrayOut[3];
                case 5 -> result = romArrayOut[4];
                case 6 -> result = romArrayOut[5];
                case 7 -> result = romArrayOut[6];
                case 8 -> result = romArrayOut[7];
                case 9 -> result = romArrayOut[8];
                case 10 -> result = romArrayOut[9];
                case 11 -> result = romArrayOut[10];
                case 12 -> result = romArrayOut[11];
                case 13 -> result = romArrayOut[12];
                case 14 -> result = romArrayOut[13];
                case 15 -> result = romArrayOut[14];
                case 16 -> result = romArrayOut[15];
                case 17 -> result = romArrayOut[16];
                case 18 -> result = romArrayOut[17];
                case 19 -> result = romArrayOut[18];
                case 20 -> result = romArrayOut[19];
            } return result;
        } else {
            x = Integer.parseInt(leftOperand);
            y = Integer.parseInt(rightOperand);
            if (x > 10 || y > 10) {
                return result;
            } int b = 0;
            switch (operator) {
                case "+" -> b = x + y;
                case "-" -> b = x - y;
                case "/" -> b = x / y;
                case "*" -> b = x * y;
            } result = Integer.toString(b);
        } return result;
    }
    static int findIndex(String inPut) {
        char[] operators = {'+', '-', '*', '/'};
        int index = 0;
        for (char operator : operators) {
            index = inPut.indexOf(operator);
            if (index != -1) {
                return index;
            }
        } return index;
    }
}