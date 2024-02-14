package de.twist.esvgamesserviceapp.helpers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import de.twist.esvgamesserviceapp.constants.Filepath;
import de.twist.esvgamesserviceapp.models.CalendarGameEvent;

public class IcsFileHelper {

	public IcsFileHelper() {
	}

	/** get .ics-File */
	public static File getIcsCalendarFile(String team) {
		Resource resource = new ClassPathResource(Filepath.STATIC.value + Filepath.GAME_SHEDULES.value + team);
		File file = new File("");

		try {
			file = resource.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}
	
	/** .ics-File - parse data*/
	public static List<CalendarGameEvent> parseCalendarDataToList(File file) {
		return IcsDataReadout.getMappedIcsData(file);
	}
}
