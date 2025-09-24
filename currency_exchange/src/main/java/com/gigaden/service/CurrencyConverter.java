package com.gigaden.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private final Map<String, BigDecimal> rates;

    public CurrencyConverter(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Бро, добро пожаловать в конвертер валют!");
        System.out.println("Доступные валюты: " + rates.keySet());
        System.out.println("Надоело конвертировать? Введи exit");

        while (true) {
            System.out.print("\nВведи сумму: ");
            String input = sc.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("До встречи, ещё увидимся!)");
                break;
            }

            BigDecimal amount;
            try {
                amount = new BigDecimal(input);
            } catch (NumberFormatException e) {
                System.out.println("Хватит меня ломать, вводи число!.");
                continue;
            }

            System.out.print("Введи валюту (например, USD, EUR, GBP, JPY, RUB): ");
            String currency = sc.next().toUpperCase();

            convert(amount, currency);
        }
    }

    public void convert(BigDecimal amount, String fromCurrency) {
        if (!rates.containsKey(fromCurrency)) {
            System.out.println("Неизвестная валюта: " + fromCurrency);
            return;
        }

        BigDecimal baseAmount = amount.divide(rates.get(fromCurrency), 10, RoundingMode.HALF_UP);

        System.out.printf("%n%.2f %s =%n", amount, fromCurrency);

        for (var entry : rates.entrySet()) {
            String targetCurrency = entry.getKey();
            if (!targetCurrency.equals(fromCurrency)) {
                BigDecimal converted = baseAmount.multiply(entry.getValue());
                System.out.printf("  %.2f %s%n", converted.setScale(2, RoundingMode.HALF_UP), targetCurrency);
            }
        }
    }
}
