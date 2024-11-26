package com.converter.Dateconverter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DateConversionService {

    
    private static final String API_URL = "https://www.hebcal.com/converter?cfg=json&date={date}&g2h=1&strict=1";

    // Method to get Hebrew date
    public String getHebrewDate(String gregorianDate) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL;

        // Call the Hebcal API with the provided date
        String response = restTemplate.getForObject(url, String.class, gregorianDate);

        // Extract the Hebrew date from the response
        if (response != null && response.contains("hebrew")) {
            String hebrewDate = response.split("\"hebrew\":\"")[1].split("\"")[0];
            return hebrewDate;
        }
        return "Invalid Date";
    }
}
