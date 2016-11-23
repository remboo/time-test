package com.johnremboo.timetest;

import java.util.Calendar;

public class App {

    public static void main( String[] args ) {
        Calendar date = Calendar.getInstance();
        System.out.println(MessageCreator.createWelcomeMessage(date.get(Calendar.HOUR_OF_DAY)));
    }
}
