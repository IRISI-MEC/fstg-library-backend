package com.mec.libapi.util;

public class AvailabilityUtil {

    public static Availability getAvailability(Integer number) {
        switch (number) {
            case 1:
                return Availability.AVAILABLE;
            case 0:
                return Availability.BOOKED;
            case -1:
                return Availability.BOOKED_NON_RETURNED;
            case -2:
                return Availability.UNAVAILABLE;
            default:
                return null;
        }
    }

}
