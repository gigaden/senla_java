package com.gigaden.utils;

import java.util.Random;

public class WordMaker {
    private static final String[] WORDS = new String[]{"солнце", "замок", "дом"};

    private WordMaker() {};

    public static String getRandomWord() {
        Random rnd = new Random();
        int rndNum = rnd.nextInt(WORDS.length);
        return WORDS[rndNum];
    }
}
