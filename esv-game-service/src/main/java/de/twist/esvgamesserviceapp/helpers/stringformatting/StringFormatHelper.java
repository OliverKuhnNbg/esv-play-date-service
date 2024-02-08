package de.twist.esvgamesserviceapp.helpers.stringformatting;

import java.util.ArrayList;
import java.util.List;

public class StringFormatHelper {

	/** get LocalDate & LocalTime from current dataString */
	public static List<String> getHomeAndGuestTeamList(String dataString) {
		String data = dataString.split(",")[0].replace("\\", "");
		List<String> teamsList =new ArrayList<String>();

		if(data.split("-").length > 1) {
			teamsList.add(data.split("-")[0]);
			teamsList.add(data.split("-")[1]);
		}

		return teamsList;
	}
}
