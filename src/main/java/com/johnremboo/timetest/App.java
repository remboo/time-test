package com.johnremboo.timetest;

import java.util.Calendar;
import java.util.Locale;

public class App {

    public static void main( String[] args ) {
        Calendar date = Calendar.getInstance();
        MessageCreator.createWelcomeMessage(date.get(Calendar.HOUR_OF_DAY));
    }
}
