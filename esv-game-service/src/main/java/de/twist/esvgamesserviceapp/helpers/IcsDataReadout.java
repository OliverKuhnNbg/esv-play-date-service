package de.twist.esvgamesserviceapp.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import de.twist.esvgamesserviceapp.constants.IcsDefinitions;
import de.twist.esvgamesserviceapp.helpers.datamapping.DataStringHelper;
import de.twist.esvgamesserviceapp.models.CalendarGameEvent;

public class IcsDataReadout {
	
	public static String getMappedIcsData(File file) {
		FileReader fileReader;
		
		try {
			fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String currentLine = getReadoutDataFromFile(br);
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "oli";
	}

	private static String getReadoutDataFromFile(BufferedReader bufferedReader) throws IOException {
		String currentLine = "";
		boolean newEventSwitch = false;
		CalendarGameEvent calGameEvent = new CalendarGameEvent();

		for (int i = 0; (currentLine = bufferedReader.readLine()) != null; i++) {
			newEventSwitch = checkForNewEvent(newEventSwitch, currentLine);

			if (currentLine.equals(IcsDefinitions.BEGIN_VEVENT.value)) {
				calGameEvent= new CalendarGameEvent();
			}
			
			if (newEventSwitch && !currentLine.equals(IcsDefinitions.BEGIN_VEVENT.value)) {
				//TODO: read out data datamapping to objects
				DataStringHelper.mapIcsFileData(calGameEvent, currentLine);
			}
		}

		return currentLine;
	}

	/** checks if current file line related to new event*/
	private static boolean checkForNewEvent(boolean eventSwitch, String currentLine) {

		if(currentLine.equals("BEGIN:VEVENT")) {
			eventSwitch=true;
			System.out.println("***********************************************\n");
		} else if(currentLine.equals("END:VEVENT")){
			eventSwitch=false;
		}

		return eventSwitch;
	}
}
