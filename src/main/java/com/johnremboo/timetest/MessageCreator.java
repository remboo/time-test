package com.johnremboo.timetest;

import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

// Class creates welcome message depending on current time period ans user locale
class MessageCreator {
    /**
     * Resource bundle name
     */
    private static String resourceBundle = "message";
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(MessageCreator.class);

    public MessageCreator() {
        // no operations
    }

    /**
     * Detects whether input hour is valid, gets time period and creates message
     *
     * @param hour - input hour value
     */
    static String createWelcomeMessage(int hour) {
        String time = TimeManager.getTimeName(hour);

        if (time == null) {
            logger.error("Invalid hour. Value: " + hour + " Valid values: from 0 to 23");
            return null;
        }

        String[] params = {time, "world"};
        return createMessage(params);
    }

    /**
     * Creates message
     *
     * @param values - parameters of the message
     */
    private static String createMessage(String... values) {

        return ResourceBundle.getBundle(resourceBundle, Locale.getDefault()).getString(values[0]) +
                ", " +
                ResourceBundle.getBundle(resourceBundle, Locale.getDefault()).getString(values[1]) +
                "!";
    }
}
