package de.twist.esvgamesserviceapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.twist.esvgamesserviceapp.helpers.IcsFileHelper;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class GameDatesController {

	@GetMapping(value="/")
	public String home() {
		System.out.println("\n\nhome() - controller called!");
		return "home";
	}
	
	@GetMapping(value="/data")
	public String getFileTest() {
		IcsFileHelper  icsHelper = new IcsFileHelper();
		
		return icsHelper.getIcsCalendarFile().getName().equals("") ? 
				"getFileTest(): noFileFound" : "getFileTest(): " + icsHelper.getIcsCalendarFile().getName();
	}
}
