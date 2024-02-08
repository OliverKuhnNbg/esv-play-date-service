package de.twist.esvgamesserviceapp.helpers.datamapping;

import java.util.Date;
import java.util.List;

import de.twist.esvgamesserviceapp.constants.IcsDefinitions;
import de.twist.esvgamesserviceapp.constants.StringFormatDefinitions;
import de.twist.esvgamesserviceapp.helpers.date.StringDateHelper;
import de.twist.esvgamesserviceapp.helpers.stringformatting.StringFormatHelper;
import de.twist.esvgamesserviceapp.models.CalendarGameEvent;
import de.twist.esvgamesserviceapp.models.submodels.Location;

public class DataStringHelper {

	public static CalendarGameEvent mapIcsFileData(CalendarGameEvent calGameEvent, String currentIcsLine) {
		String icsDefinition = currentIcsLine.split(StringFormatDefinitions.DOUBLE_POINT.value)[0];
		String icsDefinitionData = currentIcsLine.split(StringFormatDefinitions.DOUBLE_POINT.value).length > 1 ? 
				currentIcsLine.split(StringFormatDefinitions.DOUBLE_POINT.value)[1] : StringFormatDefinitions.EMPTY_STRING.value;
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
			List<String> teamsList= StringFormatHelper.getHomeAndGuestTeamList(icsDefinitionData);
			System.out.println(teamsList.getFirst() + " - " + teamsList.getLast());
			calGameEvent.setHomeTeam(teamsList.getFirst());
			calGameEvent.setGuestTeam(teamsList.getLast());
		} else if(icsDefinition.equals(IcsDefinitions.LOCATION.value)) {
			List<String> locationDataList = StringFormatHelper.getLocationDataList(icsDefinitionData);
			System.out.println(locationDataList.getFirst() + " - " + locationDataList.get(1) + " - " + locationDataList.getLast());
			Location location = new Location();
			location.setStreet(locationDataList.getFirst());
			location.setZipCode(locationDataList.get(1));
			location.setCity(locationDataList.getLast());

			calGameEvent.setLocation(location);
		}
		return calGameEvent;
	}
}
