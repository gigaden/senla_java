package com.gigaden.utils;

import java.math.BigDecimal;
import java.util.Map;

public class ExchangeRates {

    public static final Map<String, BigDecimal> RATES = Map.of(
            "USD", BigDecimal.valueOf(1.0),
            "EUR", BigDecimal.valueOf(0.94),
            "GBP", BigDecimal.valueOf(0.81),
            "JPY", BigDecimal.valueOf(148.15),
            "RUB", BigDecimal.valueOf(84.0)
    );
}
