package com.johnremboo.timetest;

import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;
import java.util.Locale;

import static org.junit.Assert.*;

public class MessageCreatorTest {
    private String language;
    private String realMessage;
    private String sampleMessage;

    private EnumMap<TimeManager.Time, String> welcomeEng;
    private EnumMap<TimeManager.Time, String> welcomeRus;

    private String getSampleMessage(TimeManager.Time time) {
        if (language.equals("en"))
            return welcomeEng.get(time);
        else if (language.equals("ru"))
            return welcomeRus.get(time);
        else
            return null;
    }

    @Before
    public void init() {
        String worldEng = "World!";
        String worldRus = "Мир!";

        language = Locale.getDefault().getLanguage();
        welcomeEng = new EnumMap<>(TimeManager.Time.class);
        welcomeRus = new EnumMap<>(TimeManager.Time.class);

        welcomeEng.put(TimeManager.Time.MORNING, "Good morning, " + worldEng);
        welcomeEng.put(TimeManager.Time.DAY, "Good day, " + worldEng);
        welcomeEng.put(TimeManager.Time.EVENING, "Good evening, " + worldEng);
        welcomeEng.put(TimeManager.Time.NIGHT, "Good night, " + worldEng);

        welcomeRus.put(TimeManager.Time.MORNING, "Доброе утро, " + worldRus);
        welcomeRus.put(TimeManager.Time.DAY, "Добрый день, " + worldRus);
        welcomeRus.put(TimeManager.Time.MORNING, "Добрый вечер, " + worldRus);
        welcomeRus.put(TimeManager.Time.MORNING, "Доброй ночи, " + worldRus);
    }

    @Test
    public void morningTest6AM() {
        realMessage = MessageCreator.createWelcomeMessage(6);
        sampleMessage = getSampleMessage(TimeManager.Time.MORNING);

        assertEquals(realMessage, sampleMessage);
    }

    @Test
    public void morningTest7AM() {
        realMessage = MessageCreator.createWelcomeMessage(7);
        sampleMessage = getSampleMessage(TimeManager.Time.MORNING);

        assertEquals(realMessage, sampleMessage);
    }

    @Test
    public void morningTest8AM() {
        realMessage = MessageCreator.createWelcomeMessage(8);
        sampleMessage = getSampleMessage(TimeManager.Time.MORNING);

        assertEquals(realMessage, sampleMessage);
    }

    @Test
    public void dayTest9AM() {
        realMessage = MessageCreator.createWelcomeMessage(9);
        sampleMessage = getSampleMessage(TimeManager.Time.DAY);

        assertEquals(realMessage, sampleMessage);
    }

    @Test
    public void dayTest3PM() {
        realMessage = MessageCreator.createWelcomeMessage(15);
        sampleMessage = getSampleMessage(TimeManager.Time.DAY);

        assertEquals(realMessage, sampleMessage);
    }

    @Test
    public void dayTest6PM() {
        realMessage = MessageCreator.createWelcomeMessage(18);
        sampleMessage = getSampleMessage(TimeManager.Time.DAY);

        assertEquals(realMessage, sampleMessage);
    }


    @Test
    public void eveningTest7PM() {
        realMessage = MessageCreator.createWelcomeMessage(19);
        sampleMessage = getSampleMessage(TimeManager.Time.EVENING);

        assertEquals(realMessage, sampleMessage);
    }

    @Test
    public void eveningTest8PM() {
        realMessage = MessageCreator.createWelcomeMessage(20);
        sampleMessage = getSampleMessage(TimeManager.Time.EVENING);

        assertEquals(realMessage, sampleMessage);
    }

    @Test
    public void eveningTest10PM() {
        realMessage = MessageCreator.createWelcomeMessage(22);
        sampleMessage = getSampleMessage(TimeManager.Time.EVENING);

        assertEquals(realMessage, sampleMessage);
    }

    @Test
    public void nightTest11PM() {
        realMessage = MessageCreator.createWelcomeMessage(23);
        sampleMessage = getSampleMessage(TimeManager.Time.NIGHT);

        assertEquals(realMessage, sampleMessage);
    }

    @Test
    public void nightTest0AM() {
        realMessage = MessageCreator.createWelcomeMessage(0);
        sampleMessage = getSampleMessage(TimeManager.Time.NIGHT);

        assertEquals(realMessage, sampleMessage);
    }

    @Test
    public void nightTest5AM() {
        realMessage = MessageCreator.createWelcomeMessage(5);
        sampleMessage = getSampleMessage(TimeManager.Time.NIGHT);

        assertEquals(realMessage, sampleMessage);
    }
}
