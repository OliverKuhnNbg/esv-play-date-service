package de.twist.esvgamesserviceapp.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.twist.esvgamesserviceapp.constants.Filepath;
import de.twist.esvgamesserviceapp.helpers.IcsFileHelper;
import de.twist.esvgamesserviceapp.services.IcsFileDataService;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class GameDatesController {
	
	@Autowired
	IcsFileDataService dataservice;

	@GetMapping(value="/")
	public String home() {
		return "home";
	}
	
	@GetMapping(value="/data")
	public String getFileTest() {
		System.out.println("\n\ngetFileTest() - controller called!");
		new IcsFileDataService(Filepath.H1_FILENAME.value).getFileData();
		new IcsFileDataService(Filepath.H2_FILENAME.value).getFileData();
		
		File icsFile = IcsFileHelper.getIcsCalendarFile(Filepath.H1_FILENAME.value);
		return icsFile.getName().equals("") ? 
				"getFileTest(): noFileFound" : "getFileTest(): " + icsFile.getName();
	}
}
