package com.gigaden;

import com.gigaden.service.PasswordGenerator;

/**
 * Решил использовать StringBuilder, хотя говорят, что сейчас стринг достаточно оптимизирован уже
 * **/
public class App
{
    public static void main( String[] args )
    {
        PasswordGenerator generator = new PasswordGenerator();
        generator.start();
    }
}
