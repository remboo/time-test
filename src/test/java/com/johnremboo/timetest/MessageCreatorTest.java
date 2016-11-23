package com.johnremboo.timetest;

import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;
import java.util.Locale;

import static org.junit.Assert.*;

public class MessageCreatorTest {
    private String language;

    private EnumMap<TimeManager.Time, String> welcomeEng;
    private EnumMap<TimeManager.Time, String> welcomeRus;

    @Before
    public void init() {
        welcomeEng = new EnumMap<>(TimeManager.Time.class);
        welcomeRus = new EnumMap<>(TimeManager.Time.class);

        for (int i = 0; i < TimeManager.Time.values().length; i++) {
            TimeManager.Time time = TimeManager.Time.values()[i];
            welcomeEng.put(time, "Good " + time.toString().toLowerCase() + ", World!");

            createWelcomeMessagesRuList(time);
        }


        language = Locale.getDefault().getLanguage();
    }

    private void createWelcomeMessagesRuList(TimeManager.Time time) {

        switch (time) {
            case MORNING:
                welcomeRus.put(time, "Доброе утро, Мир!");
                break;
            case DAY:
                welcomeRus.put(time, "Добрый день, Мир!");
                break;
            case EVENING:
                welcomeRus.put(time, "Добрый вечер, Мир!");
                break;
            case NIGHT:
                welcomeRus.put(time, "Доброй ночи, Мир!");
                break;
        }
    }


    @Test
    public void morningMessageTest() {
        String message;

        for (int i = 6; i < 9; i++) {
            message = MessageCreator.createWelcomeMessage(i);

            switch (language) {
                case "en":
                    assertEquals(welcomeEng.get(TimeManager.Time.MORNING), message);
                    break;
                case "ru":
                    assertEquals(welcomeRus.get(TimeManager.Time.MORNING), message);
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    public void dayMessageTest() {
        String message;

        for (int i = 9; i < 19; i++) {
            message = MessageCreator.createWelcomeMessage(i);

            switch (language) {
                case "en":
                    assertEquals(welcomeEng.get(TimeManager.Time.DAY), message);
                    break;
                case "ru":
                    assertEquals(welcomeRus.get(TimeManager.Time.DAY), message);
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    public void eveningMessageTest() {
        String message;

        for (int i = 19; i < 23; i++) {
            message = MessageCreator.createWelcomeMessage(i);

            switch (language) {
                case "en":
                    assertEquals(welcomeEng.get(TimeManager.Time.EVENING), message);
                    break;
                case "ru":
                    assertEquals(welcomeRus.get(TimeManager.Time.EVENING), message);
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    public void nightMessageTest() {
        String message;

        for (int i = 0; i < 24; i++) {

            if (!(i >= 0 && i < 6) || i != 23)
                continue;

            message = MessageCreator.createWelcomeMessage(i);

            switch (language) {
                case "en":
                    assertEquals(welcomeEng.get(TimeManager.Time.NIGHT), message);
                    break;
                case "ru":
                    assertEquals(welcomeRus.get(TimeManager.Time.NIGHT), message);
                    break;
                default:
                    break;
            }
        }
    }
}
