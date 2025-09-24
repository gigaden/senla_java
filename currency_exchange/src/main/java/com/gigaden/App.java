package com.gigaden;

import com.gigaden.service.CurrencyConverter;
import com.gigaden.utils.ExchangeRates;

/**
 * Курсы валют зашил в отдельный файл.
 * Для большей точности решил использовать BigDecimal
 **/
public class App {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter(ExchangeRates.RATES);
        converter.start();
    }
}
