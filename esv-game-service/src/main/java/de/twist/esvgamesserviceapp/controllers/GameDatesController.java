package de.twist.esvgamesserviceapp.controllers;

import java.io.File;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.twist.esvgamesserviceapp.helpers.IcsFileHelper;
import de.twist.esvgamesserviceapp.models.CalendarGameEvent;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class GameDatesController {

	@GetMapping(value="/")
	public String home() {
		return "home";
	}
	
	@GetMapping(value="/data")
	public String getFileTest() {
		File icsFile = IcsFileHelper.getIcsCalendarFile();
//		TODO: do evenList call over spring service - and data mapping date boolean
		List<CalendarGameEvent> mappedDataList = IcsFileHelper.parseCalendarDataToList(icsFile);
		System.out.println("\n\ngetFileTest() - controller called!");
		System.out.println("\n---------\nmapped amount of .ics-entrys: # " + mappedDataList.size());

		return icsFile.getName().equals("") ? 
				"getFileTest(): noFileFound" : "getFileTest(): " + icsFile.getName();
	}
}
