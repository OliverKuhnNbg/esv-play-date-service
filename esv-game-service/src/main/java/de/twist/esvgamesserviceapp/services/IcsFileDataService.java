package de.twist.esvgamesserviceapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.twist.esvgamesserviceapp.models.CalendarGameEvent;

@Service
public class IcsFileDataService {
	
	private List<CalendarGameEvent> mappedDataList;

	public List<CalendarGameEvent> getFileData() {
		System.out.println("\n\n-----\ntst service call");
		return new ArrayList<CalendarGameEvent>();
	}
}
