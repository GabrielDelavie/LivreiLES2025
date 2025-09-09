package com.livrei.les.ecomercy.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;

import jakarta.servlet.http.HttpServletRequest;

public class RequestUtils {

    public static String getSafeParam(HttpServletRequest request, String name) {
        String value = request.getParameter(name);
        return (value != null && !value.trim().isEmpty()) ? value.trim() : null;
    }

    public static Integer getIntParam(HttpServletRequest request, String name) {
        String value = getSafeParam(request, name);
        try {
            return (value != null) ? Integer.parseInt(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double getDoubleParam(HttpServletRequest request, String name) {
        String value = getSafeParam(request, name);
        try {
            return (value != null) ? Double.parseDouble(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Instant getDateParam(HttpServletRequest request, String name) {
        String value = getSafeParam(request, name);
        try {
            if (value != null) {
                LocalDate date = LocalDate.parse(value); // espera yyyy-MM-dd
                return date.atStartOfDay(ZoneId.systemDefault()).toInstant();
            }
        } catch (DateTimeParseException e) {
            return null;
        }
        return null;
    }
}
