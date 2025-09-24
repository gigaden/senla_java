package com.gigaden.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class CurrencyConverter {
    private final Map<String, BigDecimal> rates;

    public CurrencyConverter(Map<String, BigDecimal> rates) {
        this.rates = rates;
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
