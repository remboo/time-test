package com.johnremboo.timetest;

// Class has methods in order to detect whether current time hour is valid and get current time period
class TimeManager {

    /**
     * Gets the current time period depending on hour
     *
     * @param hour - current hour (from 0 to 24)
     * @return - current time period
     */
    static String getTimeName(int hour) {
        String time = null;

        if (hour >= 6 && hour < 9) {
            time = Time.MORNING.name().toLowerCase();
        } else if (hour >= 9 && hour < 19) {
            time = Time.DAY.name().toLowerCase();
        } else if (hour >= 19 && hour < 23) {
            time = Time.EVENING.name().toLowerCase();
        } else if (hour >= 0 && hour < 6 || hour == 23) {
            time = Time.NIGHT.name().toLowerCase();
        }
        return time;
    }

    /**
     * Time periods
     */
    enum Time {
        MORNING,
        DAY,
        EVENING,
        NIGHT
    }
}
