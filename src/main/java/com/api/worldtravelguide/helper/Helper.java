package com.api.worldtravelguide.helper;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper {
    public static String getIpAddress() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ipAddress = request.getHeader("x-forwarded-for");

        if (ipAddress == null) {
            return request.getRemoteAddr();
        }

        String[] ips = ipAddress.split(",");
        ipAddress = ips[ips.length - 1].trim();

        if (ipAddress.isEmpty()) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    public static LocalDateTime getLocalDateTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m");
        return LocalDateTime.parse(time, formatter);
    }

    public static LocalDateTime getToday(String date) {
        // Date format must be yyyy-MM-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m");
        return LocalDateTime.parse(String.format("%s %s", date, "00:00"), formatter);
    }

    /*public static String fixHour(String hour){
        String[] parsed=hour.split(":");
        if(parsed.length!=2){
            //
        }
        if(parsed[0].length())
    }*/
}
