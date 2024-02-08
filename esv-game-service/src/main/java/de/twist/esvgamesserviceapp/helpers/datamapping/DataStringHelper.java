package de.twist.esvgamesserviceapp.helpers.datamapping;

import java.util.Date;

import de.twist.esvgamesserviceapp.constants.IcsDefinitions;
import de.twist.esvgamesserviceapp.helpers.StringDateHelper;
import de.twist.esvgamesserviceapp.models.CalendarGameEvent;

public class DataStringHelper {

	public static CalendarGameEvent mapIcsFileData(CalendarGameEvent calGameEvent, String currentIcsLine) {
//		System.out.println(currentIcsLine);
		String icsDefinition = currentIcsLine.split(":")[0];
		String icsDefinitionData = currentIcsLine.split(":").length > 1 ? currentIcsLine.split(":")[1] : "";
		Date date;
		if(icsDefinition.equals(IcsDefinitions.DTSTAMP.value)) {
			System.out.println(StringDateHelper.getDateFromString(icsDefinitionData));
			date = StringDateHelper.getDateFromString(icsDefinitionData);
			calGameEvent.setLastDataUpdate(date);
		} else if(icsDefinition.equals(IcsDefinitions.DTSTART.value)) {
			System.out.println(StringDateHelper.getDateFromString(icsDefinitionData));
			date = StringDateHelper.getDateFromString(icsDefinitionData);
			calGameEvent.setStartGameDate(date);
		} else if(icsDefinition.equals(IcsDefinitions.DTEND.value)) {
			System.out.println(StringDateHelper.getDateFromString(icsDefinitionData));
			date = StringDateHelper.getDateFromString(icsDefinitionData);
			calGameEvent.setEndGameDate(date);
		} else if(icsDefinition.equals(IcsDefinitions.SUMMARY.value)) {
			System.out.println(icsDefinitionData);
		}
		return calGameEvent;
	}
}
