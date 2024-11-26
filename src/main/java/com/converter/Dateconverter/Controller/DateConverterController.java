package com.converter.Dateconverter.Controller;

import com.converter.Dateconverter.service.DateConversionService;  // Correct import for the service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DateConverterController {

    @Autowired
    private DateConversionService dateConversionService;  // This will inject the service correctly

    // Show the form page
    @GetMapping("/")
    public String showForm() {
        return "dateform";  // This will return the dateform.html template
    }

    @GetMapping("/convertDate")
    public String convertDate(@RequestParam String gregorianDate, Model model) {
        // Call the service to get the Hebrew date
        String hebrewDate = dateConversionService.getHebrewDate(gregorianDate);

        model.addAttribute("hebrewDate", hebrewDate);
        model.addAttribute("gregorianDate", gregorianDate);

        return "result";  
    }
}
