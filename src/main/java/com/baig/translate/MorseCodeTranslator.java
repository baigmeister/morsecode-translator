package com.baig.translate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MorseCodeTranslator {

    private static final List<String> morseAlphabet = Arrays.asList(
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..");

    private static final List<String> englishAlphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    public String convertToMorse(String param) {
        String[] words = param.split(" ");

        StringBuilder results = new StringBuilder();
        int length = words.length;
        int count = 0;
        for (String word : words) {
            results.append(convertWordToMorse(word.chars()));
            if (count != length - 1) results.append(" / ");
            count++;
        }
        return results.toString();
    }

    public String convertToEnglish(String code) {
        String[] codeWords = code.split(" / ");

        StringBuilder results = new StringBuilder();
        int length = codeWords.length;
        int count = 0;
        String[] codeLetters;

        for (String codeWord : codeWords) {
            codeLetters = codeWord.split(" ");
            for (String codeLetter : codeLetters) {
                results.append(convertMorseToLetter(codeLetter));
            }
            count++;
            if (count != length) results.append(" ");
        }
        return results.toString();
    }

    private String convertMorseToLetter(String codeLetter) {
        return englishAlphabet.get(morseAlphabet.indexOf(codeLetter));
    }

    private String convertWordToMorse(IntStream intStream) {
        return intStream.mapToObj(p -> morseAlphabet.get(englishAlphabet.indexOf(String.valueOf((char) p)))).collect(Collectors.joining(" "));
    }
}

