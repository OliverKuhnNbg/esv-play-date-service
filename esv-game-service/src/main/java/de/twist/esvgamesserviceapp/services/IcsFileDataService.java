package de.twist.esvgamesserviceapp.services;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import de.twist.esvgamesserviceapp.helpers.IcsFileHelper;
import de.twist.esvgamesserviceapp.models.CalendarGameEvent;

@Service
public class IcsFileDataService {
	
	private List<CalendarGameEvent> mappedDataList;
	private String teamIndicator = "";

	public IcsFileDataService() {
	}
	public IcsFileDataService(String teamIndicator) {
		this.teamIndicator = teamIndicator;
	}

	public List<CalendarGameEvent> getFileData() {
		System.out.println("\n\n-----\ntst service call");
		File icsFile = IcsFileHelper.getIcsCalendarFile(this.teamIndicator);
		mappedDataList = IcsFileHelper.parseCalendarDataToList(icsFile);
		
		System.out.println("\n\ngetFileTest() - controller called!");
		System.out.println("\n---------\nmapped amount of .ics-entrys: # " + mappedDataList.size());
		
		return mappedDataList;
	}
}
