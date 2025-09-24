package com.gigaden.service;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>?";
    private static final String ALL_CHARS = UPPERCASE + LOWERCASE + DIGITS + SYMBOLS;

    private final Random random = new Random();

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Бро, я помогу создать тебе самый надёжный пароль!");
        System.out.println("Пароль должен быть длиной от 8 до 12 символов.");

        while (true) {
            System.out.print("\nВведи желаемую длину пароля (или 'exit' для выхода): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Бро, удачи, заходи ещё!");
                break;
            }

            int length;
            try {
                length = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ты опять ломаешь меня! Вводи число.");
                continue;
            }

            if (length < 8 || length > 12) {
                System.out.println("Длина должна быть от 8 до 12 символов.");
                continue;
            }

            String password = generatePassword(length);
            System.out.println("Твой пароль готов: " + password);
        }
    }

    private String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);

        password.append(randomChar(UPPERCASE));
        password.append(randomChar(LOWERCASE));
        password.append(randomChar(DIGITS));
        password.append(randomChar(SYMBOLS));

        for (int i = password.length(); i < length; i++) {
            password.append(randomChar(ALL_CHARS));
        }

        return shuffleString(password.toString());
    }

    private char randomChar(String chars) {
        return chars.charAt(random.nextInt(chars.length()));
    }

    private String shuffleString(String input) {
        char[] array = input.toCharArray();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return new String(array);
    }
}
