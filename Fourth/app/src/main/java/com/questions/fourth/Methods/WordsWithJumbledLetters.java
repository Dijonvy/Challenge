package com.questions.fourth.Methods;

public class WordsWithJumbledLetters {

    public WordsWithJumbledLetters() {}

    public boolean isPartialPermutation(String firstWord, String secondWord) {
        if(((firstWord.length() < 3)) || (firstWord.length() != secondWord.length()) || (firstWord.charAt(0) != secondWord.charAt(0))) return false;
        int misspelledCharsCount = 0;
        for(int i=0; i<firstWord.length(); i++) {
            if(firstWord.charAt(i) != secondWord.charAt(i)) misspelledCharsCount++;
        }

        float threshold = 2/3f;
        if((misspelledCharsCount/(float)firstWord.length()) > threshold) return false;

        return true;
    }

}
