package com.gigaden;

import com.gigaden.service.CurrencyConverter;
import com.gigaden.utils.ExchangeRates;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Курсы валют зашил в отдельный файл.
 * Для большей точности решил использовать BigDecimal
 **/
public class App {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter(ExchangeRates.RATES);
        Scanner sc = new Scanner(System.in);

        System.out.println("Доступные валюты: " + ExchangeRates.RATES.keySet());

        System.out.print("Введите сумму: ");
        BigDecimal amount = sc.nextBigDecimal();

        System.out.print("Введите валюту (например, USD, EUR, GBP, JPY, RUB): ");
        String currency = sc.next().toUpperCase();

        converter.convert(amount, currency);
    }
}
