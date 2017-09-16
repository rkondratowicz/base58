package com.github.rkondratowicz;

import io.vavr.collection.List;

public class Base58 {

    private static final List<Character> ALPHABET =
        List.ofAll("123456789abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ".toCharArray());

    public static String encode(long number) {
        return encode(number, List.empty());
    }

    public static Long decode(String str) {
        return decode(List.ofAll(str.toCharArray()), 0);
    }

    private static String encode(Long number, List<Character> acc) {
        if (number == 0 && acc.isEmpty()) {
            return String.valueOf(ALPHABET.head());
        } else if (number == 0) {
            return acc.mkString();
        } else {
            return encode(number / 58, acc.prepend(ALPHABET.get((int) (number % 58))));
        }
    }

    private static Long decode(List<Character> chars, long acc) {
        if (chars.isEmpty()) {
            return acc;
        } else {
            return decode(chars.tail(), acc * 58 + ALPHABET.indexOf(chars.head()));
        }
    }
}
