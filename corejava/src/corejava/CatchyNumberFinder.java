package corejava;

import java.util.ArrayList;
import java.util.List;

public class CatchyNumberFinder {

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        numbers.add("4444");
        numbers.add("444444");
        numbers.add("44444");
        numbers.add("1111");
        numbers.add("111111");
        numbers.add("2222");
        numbers.add("222222");
        numbers.add("00001");
        numbers.add("00007");

        String catchyNumber = findCatchyNumber(numbers);
        System.out.println("The catchiest number is: " + catchyNumber);
    }

    public static String findCatchyNumber(List<String> numbers) {
        String catchyNumber = "";
        int maxPriority = Integer.MIN_VALUE;

        for (String number : numbers) {
            int priority = calculatePriority(number);
            if (priority > maxPriority) {
                maxPriority = priority;
                catchyNumber = number;
            }
        }

        return catchyNumber;
    }

    public static int calculatePriority(String number) {
        int priority = 0;

        if (isSuperElite(number)) {
            priority += 10;
        }

        int repetitionCount = getRepetitionCount(number);
        priority += repetitionCount;

        if (isPalindrome(number)) {
            priority += 4;
        }

        if (hasSimilarPattern(number)) {
            priority += 3;
        }

        if (hasOddMiddleNumber(number)) {
            priority += 2;
        }

        if (isAscendingDescending(number)) {
            priority += 1;
        }

        return priority;
    }

    public static int getRepetitionCount(String number) {
        int maxCount = 0;
        for (int i = 0; i < 10; i++) {
            String pattern = String.valueOf(i);
            int count = number.length() - number.replace(pattern, "").length();
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static boolean isPalindrome(String number) {
        return new StringBuilder(number).reverse().toString().equals(number);
    }

    public static boolean isSuperElite(String number) {
        return number.matches("0+\\d");
    }

    public static boolean hasSimilarPattern(String number) {
        int length = number.length();
        return length % 2 == 0 && number.substring(0, length / 2).equals(number.substring(length / 2));
    }

    public static boolean hasOddMiddleNumber(String number) {
        int length = number.length();
        if (length % 2 == 0) {
            return false;
        } else {
            char middleChar = number.charAt(length / 2);
            return middleChar % 2 != 0;
        }
    }

    public static boolean isAscendingDescending(String number) {
        boolean ascending = true;
        boolean descending = true;
        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i) > number.charAt(i - 1)) {
                descending = false;
            }
            if (number.charAt(i) < number.charAt(i - 1)) {
                ascending = false;
            }
        }
        return ascending || descending;
    }
}