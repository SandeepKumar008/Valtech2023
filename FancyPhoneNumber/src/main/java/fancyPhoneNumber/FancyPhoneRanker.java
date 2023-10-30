package fancyPhoneNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyPhoneRanker {

    public static List<String> rankFancyPhoneNumbers(List<String> phoneNumbers) {
        List<PhoneNumberScore> fancyNumbers = new ArrayList<>();
        List<PhoneNumberScore> nonFancyNumbers = new ArrayList();

        for (String phoneNumber : phoneNumbers) {
            int score = 0;

            // Condition 1: If all digits in the phone number are the same
            if (isAllDigitsSame(phoneNumber)) {
                score += 6;
            }

            // Condition 2: If the phone number is a palindrome
            if (isPalindrome(phoneNumber)) {
                score += 5;
            }

            // Condition 3: If the phone number has at least one repeated digit
            if (hasRepeatedDigit(phoneNumber)) {
                score += 4;
            }

            // Condition 4: If the phone number is in ascending order
            if (isAscendingOrder(phoneNumber)) {
                score += 3;
            }

            // Condition 5: If the phone number is in descending order
            if (isDescendingOrder(phoneNumber)) {
                score += 2;
            }

            // Condition 6: If the phone number contains a consecutive sequence of numbers
            if (hasConsecutiveSequence(phoneNumber)) {
                score += 1;
            }

            PhoneNumberScore phoneScore = new PhoneNumberScore(phoneNumber, score);

            if (score > 0) {
                fancyNumbers.add(phoneScore);
            } else {
                nonFancyNumbers.add(phoneScore);
            }
        }

        Collections.sort(fancyNumbers, new PhoneNumberScoreComparator());
        Collections.sort(nonFancyNumbers, new PhoneNumberScoreComparator());

        List<String> rankedPhoneNumbers = new ArrayList<>();

        for (PhoneNumberScore fancyNumber : fancyNumbers) {
            rankedPhoneNumbers.add(fancyNumber.phoneNumber);
        }

        for (PhoneNumberScore nonFancyNumber : nonFancyNumbers) {
            rankedPhoneNumbers.add(nonFancyNumber.phoneNumber);
        }

        return rankedPhoneNumbers;
    }

    // Check if all digits in the phone number are the same
    private static boolean isAllDigitsSame(String phoneNumber) {
        return phoneNumber.matches("^(.)\\1*$");
    }

    // Check if the phone number is a palindrome
    private static boolean isPalindrome(String phoneNumber) {
        String reversed = new StringBuilder(phoneNumber).reverse().toString();
        return phoneNumber.equals(reversed);
    }

    // Check if the phone number has at least one repeated digit
    private static boolean hasRepeatedDigit(String phoneNumber) {
        return phoneNumber.matches(".*(\\d)\\1.*");
    }

    // Check if the phone number is in ascending order
    private static boolean isAscendingOrder(String phoneNumber) {
        String sorted = phoneNumber.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return phoneNumber.equals(sorted);
    }

    // Check if the phone number is in descending order
    private static boolean isDescendingOrder(String phoneNumber) {
        String sorted = phoneNumber.chars()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return phoneNumber.equals(sorted);
    }

    // Check if the phone number contains a consecutive sequence of numbers
    private static boolean hasConsecutiveSequence(String phoneNumber) {
        return phoneNumber.matches(".*0123456789.*");
    }

    private static class PhoneNumberScore {
        String phoneNumber;
        int score;

        PhoneNumberScore(String phoneNumber, int score) {
            this.phoneNumber = phoneNumber;
            this.score = score;
        }
    }

    private static class PhoneNumberScoreComparator implements Comparator<PhoneNumberScore> {
        @Override
        public int compare(PhoneNumberScore p1, PhoneNumberScore p2) {
            return Integer.compare(p2.score, p1.score);
        }
    }
}
