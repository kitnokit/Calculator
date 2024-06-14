package main;
import java.util.Scanner;
class calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        try {
            System.out.println("Напишите своё выражение (например, 1 + 10 или I + X): ");
            input = scanner.nextLine();
            boolean Arab = input.matches("[1-9 ]|10");
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
        String leftOperand, operator, rightOperand;
        String result;
        String[] romArray = {"I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX", "X"};
        int x, y, b;
        int Index = 0;
        try {
            Index = findIndex(input);
        } catch (Exception e) {
            System.out.println("throws Exception");
        }
        leftOperand = input.substring(0, Index).trim();
        operator = input.substring(Index, Index + 1).trim();
        rightOperand = input.substring(Index + 1).trim();

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
            x = romanArrayOut.valueOf(leftOperand).toInt();
            y = romanArrayOut.valueOf(rightOperand).toInt();
        } else {
            x = Integer.parseInt(leftOperand);
            y = Integer.parseInt(rightOperand);
        }
        if (x > 10 || y > 10 || x <= 0 || y <= 0) {
            throw new Exception("throws Exception");
        } else
            switch (operator) {
                case "+" -> b = x + y;
                case "-" -> b = x - y;
                case "/" -> b = x / y;
                case "*" -> b = x * y;
                default -> throw new Exception("throw Exception");
            }
            if (romX || romY) {
                result = romanArrayOut.fromInt(b).name();
                return result;
            } else {
                result = Integer.toString(b);
            return result;
            }
        }

    static int findIndex(String inPut) {
        char[] operators = {'+', '-', '*', '/'};
        int index = 0;
        for (char operator : operators) {
            index = inPut.indexOf(operator);
            if (index != -1) {
                return index;
            }
        }
        return index;

    }

    enum romanArrayOut {
        I(1), II(2), III(3), IV(4), V(5),
        VI(6), VII(7), VIII(8), IX(9), X(10),
        XI(11), XII(12), XIII(13), XIV(14), XV(15),
        XVI(16), XVII(17), XVIII(18), XIX(19), XX(20),
        XXI(21), XXII(22), XXIII(23), XXIV(24), XXV(25),
        XXVI(26), XXVII(27), XXVIII(28), XXIX(29), XXX(30),
        XXXI(31), XXXII(32), XXXIII(33), XXXIV(34), XXXV(35),
        XXXVI(36), XXXVII(37), XXXVIII(38), XXXIX(39), XL(40),
        XLI(41), XLII(42), XLIII(43), XLIV(44), XLV(45),
        XLVI(46), XLVII(47), XLVIII(48), XLIX(49), L(50),
        LI(51), LII(52), LIII(53), LIV(54), LV(55),
        LVI(56), LVII(57), LVIII(58), LIX(59), LX(60),
        LXI(61), LXII(62), LXIII(63), LXIV(64), LXV(65),
        LXVI(66), LXVII(67), LXVIII(68), LXIX(69), LXX(70),
        LXXI(71), LXXII(72), LXXIII(73), LXXIV(74), LXXV(75),
        LXXVI(76), LXXVII(77), LXXVIII(78), LXXIX(79), LXXX(80),
        LXXXI(81), LXXXII(82), LXXXIII(83), LXXXIV(84), LXXXV(85),
        LXXXVI(86), LXXXVII(87), LXXXVIII(88), LXXXIX(89), XC(90),
        XCI(91), XCII(92), XCIII(93), XCIV(94), XCV(95),
        XCVI(96), XCVII(97), XCVIII(98), XCIX(99), C(100);

        private final int value;

        romanArrayOut(int value) {
            this.value = value;
        }

        int toInt() {
            return value;
        }

        static romanArrayOut fromInt(int number) throws Exception {
            for (romanArrayOut numeral : values()) {
                if (numeral.value == number) {
                    return numeral;
                }
            }
            throw new Exception("new Exception");
        }

    }
}
