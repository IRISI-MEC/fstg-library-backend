package com.mec.libapi.util;

public enum Availability {
    AVAILABLE, // DTO Presentation : 1
    UNAVAILABLE, // DTO Presentation : -2
    BOOKED, // DTO Presentation : 0
    BOOKED_NON_RETURNED // DTO presentation : -1
}
