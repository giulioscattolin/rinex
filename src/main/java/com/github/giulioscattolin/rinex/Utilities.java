package com.github.giulioscattolin.rinex;

import static java.lang.Double.NaN;
import static java.lang.Double.parseDouble;

class Utilities {
    static boolean isDigit(char digit) {
        return '0' <= digit && digit <= '9';
    }

    static double toFloatingPointNumberOrNaN(String number) {
        if (isBlank(number))
            return NaN;
        else
            return parseDouble(number.replace('D', 'E'));
    }

    static boolean isBlank(String string) {
        int length = string.length();
        for (int i = 0; i < length; i++)
            if (string.charAt(i) != ' ')
                return false;
        return true;
    }

    static int parseFourDigitIntegerOrDefault(String number, int defaultInt) {
        int firstHalf = parseTwoDigitIntegerOrDefault(number.substring(0, 2), -1);
        int secondHalf = parseTwoDigitIntegerOrDefault(number.substring(2, 4), -1);
        if (firstHalf == -1 || secondHalf == -1)
            return defaultInt;
        else
            return firstHalf * 100 + secondHalf;
    }

    static int parseTwoDigitIntegerOrDefault(String number, int defaultInt) {
        if ((number.charAt(0) == '0' || number.charAt(0) == ' ') && isDigit(number.charAt(1)))
            return number.charAt(1) - '0';
        if (isDigit(number.charAt(0)) && isDigit(number.charAt(1)))
            return 10 * (number.charAt(0) - '0') + number.charAt(1) - '0';
        return defaultInt;
    }
}
