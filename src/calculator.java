package calcalated;
import java.util.Scanner;


public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите своё выражение (например, 1 + 7 или I + III): ");
        String input = scanner.nextLine();
        calc(input);
        String result = calc(input);
        if (result == null) {
            System.out.println("throws Exception");
        } else System.out.println(result);


//        if (input.length()!=5) { Придумать что-то, чтобы значение х+у выдавало ошибку
//            System.out.println("Ошибка: выражение должно содержать ровно 5 символов");
//        }
//        else  {
//            System.out.println(input);
//            splitExpression(input);
//        }
    }

    static String calc(String input) {
        String result = null;
        int x = 0;
        int y = 0;
        int Index = findIndex(input);
        if (Index == -1) {
            System.out.println("throws Exception");
        }
        // Разделить строку на три части
        String leftOperand = input.substring(0, Index).trim();
        String operator = input.substring(Index, Index + 1).trim();
        String rightOperand = input.substring(Index + 1).trim();
        //Замена римских цифр арабискими:
        String[] romArray = {"I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX", "X"};
        String[] romArrayOut = {"I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        // Проверка значений на соответствие римским символам
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
                default -> {
                    System.out.println("throws Exception");
                }
            }
            switch (rightOperand) {
//            case Rom.I -> x = Rom.getArabian(); неудачная реализация через enum
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
                default -> {
                    System.out.println("throws Exception");
                }
            }
            String[] operandArray = {"+", "-", "/", "*"};
            int b = 0;
            if (x >= 1 && x <= 10 && y >= 1 && y <= 10) {
                if (operator.equals(operandArray[0])) {
                    b = x + y;
                } else if (operator.equals(operandArray[1])) {
                    if (x == y) {
                        System.out.println("throws Exception");
                    } else b = x - y;
                } else if (operator.equals(operandArray[2])) {
                    if (y != 0) {
                        b = x / y;
                    } else if (operator.equals(operandArray[3])) {
                        b = x * y;
                    } else {
                        System.out.println("throws Exception");
                    }
                } else {
                    System.out.println("throws Exception");
                }
            }
            switch (b) { // возможно также реализовать циклом (наверное), но я решил пойти сложным путем..
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
            String[] operandArray = {"+", "-", "/", "*"};
            x = Integer.parseInt(leftOperand);
            y = Integer.parseInt(rightOperand);
            int b = 0;
            if (x >= 1 && x <= 10 && y <= 10 && y >= 0) {
                if (operator.equals(operandArray[0])) {
                    b = x + y;
                    result = Integer.toString(b);
                    return result;
                } else if (operator.equals(operandArray[1])) {
                    if (x - y >= 0) {
                        b = x - y;
                        result = Integer.toString(b);
                        return result;
                    }
                } else if (operator.equals(operandArray[2])) {
                    if (y == 0) {
                        return result;
                    } else {
                        b = x / y;
                        result = Integer.toString(b);
                        return result;
                    }
                } else if (operator.equals(operandArray[3])) {
                    b = x * y;
                    result = Integer.toString(b);
                    return result;
                }
            } return result;
        }
    }
    static int findIndex(String expression) {
        char[] operators = {'+', '-', '*', '/'};
        for (char operator : operators) {
            int index = expression.indexOf(operator);
            if (index != -1) {
                return index;
            }
        }
        return -1;
    }
}
