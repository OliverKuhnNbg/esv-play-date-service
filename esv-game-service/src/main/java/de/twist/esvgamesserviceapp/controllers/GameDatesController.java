package de.twist.esvgamesserviceapp.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.twist.esvgamesserviceapp.constants.Filepath;
import de.twist.esvgamesserviceapp.models.CalendarGameEvent;
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
	public HashMap<String, List<CalendarGameEvent>> getFileTest() {
		System.out.println("\n\ngetFileTest() - controller called!");
		List<CalendarGameEvent> datalistH1 = new IcsFileDataService(Filepath.H1_FILENAME.value).getFileData();
		List<CalendarGameEvent> datalistH2 = new IcsFileDataService(Filepath.H2_FILENAME.value).getFileData();

		HashMap<String, List<CalendarGameEvent>> teamDataLists = new HashMap<>();
		teamDataLists.put("h1", datalistH1);
		teamDataLists.put("h2", datalistH2);

		return teamDataLists;
	}
}
