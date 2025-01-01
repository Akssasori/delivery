package com.lucas.delivery.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConvert {

    private static final String DEFAULT_PATTERN = "dd-MM-yyyy HH:mm:ss";

    public static String formatLocalDateTime(LocalDateTime dateTime) {
        return formatLocalDateTime(dateTime, DEFAULT_PATTERN);
    }

    public static LocalDateTime nowLocalDateTimeBrazil() {
        LocalDateTime localNow = LocalDateTime.now();
        ZonedDateTime zonedUTC = localNow.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedBR = zonedUTC.withZoneSameInstant(ZoneId.of("America/Sao_Paulo"));
        return zonedBR.toLocalDateTime();
    }

    public static String formatLocalDateTime(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                pattern != null && !pattern.isBlank() ? pattern : DEFAULT_PATTERN
        );
        return dateTime.format(formatter);
    }
}
