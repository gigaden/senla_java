package com.gigaden.service;

import com.gigaden.utils.WordMaker;

import java.util.Scanner;

public class GameService {
    private static final int MAX_ATTEMPTS = 5;

    private int attempts;
    private String letter;
    private final char[] word;
    private final char[] wordToInput;

    public GameService() {
        attempts = MAX_ATTEMPTS;
        word = WordMaker.getRandomWord().toCharArray();
        wordToInput = new char[word.length];
    }

    public void startGame() {
        initGame(word, wordToInput);
        Scanner sc = new Scanner(System.in);

        while (showMustGoOn()) {
            System.out.print("Введите букву: ");
            letter = sc.nextLine().toLowerCase();

            if (isValidInput(letter)) {
                checkLetterInTheWord();
                printWord();

                System.out.println();
                System.out.printf("количество оставшихся попыток: %d\n", attempts);
            } else {
                System.out.println("""
                        Бро, не обманывай меня, можно вводить только одну букву.
                        Или ты хочешь меня поломать???
                        """);
            }
        }

        gameIsOver();
    }

    private void initGame(char[] word, char[] wordToInput) {

        for (int i = 0; i < word.length; i++) {
            wordToInput[i] = '.';
        }
        System.out.println("Добро пожаловать!");
        System.out.printf("Загаданное слово состоит из %d букв\n", word.length);
        printWord();
        System.out.println();
    }

    private void checkLetterInTheWord() {

        boolean charIsExist = false;
        char userLetter = letter.charAt(0);

        for (int i = 0; i < word.length; i++) {
            if (!letter.isBlank() && word[i] == userLetter && wordToInput[i] == '.') {
                wordToInput[i] = userLetter;
                charIsExist = true;
            }
        }
        if (!charIsExist) {
            attempts--;
        }
        if (charIsExist) {
            System.out.println("Отличный ход! Будешь крутить барабан дальше, или назовёшь всё слово?)");
        } else {
            System.out.println("Такой буквы нет, но в алфавите есть ещё из чего выбрать)");
            printPicture();
        }
    }

    private void printWord() {

        for (int i = 0; i < word.length; i++) {
            if (wordToInput[i] != '.') {
                System.out.printf(" %c ", wordToInput[i]);
            } else {
                System.out.print(" ... ");
            }
        }
    }

    private void printPicture() {
        switch (attempts) {
            case 4 -> System.out.println("  O\n  |");
            case 3 -> System.out.println("  O\n /|");
            case 2 -> System.out.println("  O\n /|\\");
            case 1 -> System.out.println("  O\n /|\\\n /");
            case 0 -> System.out.println("  O\n /|\\\n / \\");
        }
        System.out.println();
    }

    private boolean showMustGoOn() {
        return attempts > 0 && String.valueOf(wordToInput).contains(".");
    }

    private boolean isValidInput(String input) {
        return input.length() == 1 && Character.isLetter(input.charAt(0));
    }

    private void gameIsOver() {
        System.out.println("Игра закончена!");
        if (attempts == 0) {
            System.out.printf("""
                    Чел, сегодня не твой день, ты проиграл(((
                    Я загадал слово "%s"
                    """, String.valueOf(word));
        } else {
            System.out.printf("""
                    Красава, сегодня твой день
                    Ты отгадал слово "%s"
                    """, String.valueOf(word));
        }
    }
}
